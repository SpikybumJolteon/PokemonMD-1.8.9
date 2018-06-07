package com.fuzzyacornindustries.pokemonmd.tileentity;

import java.util.Random;

import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.block.BlockVespeneCondenser;
import com.fuzzyacornindustries.pokemonmd.container.ContainerVespeneCondenser;
import com.fuzzyacornindustries.pokemonmd.recipes.RecipesVespeneCondenser;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityVespeneCondenser extends TileEntityLockable implements ISidedInventory, ITickable, IAnimatedEntity
{
	private IdleAnimationClock rotationIdleAnimationClock[] = new IdleAnimationClock[4];
	private IdleAnimationClock verticalShiftIdleAnimationClock[] = new IdleAnimationClock[4];
	private IdleAnimationClock coreShiftIdleAnimationClock;

	public static final int actionIDNone = 0;

	private int animationID;
	private int animationTick;

	private String localizedName;

	public enum slotEnum 
	{
		INPUT_SLOT, OUTPUT_SLOT
	}

	private static final int[] slotsTop = new int[] {slotEnum.INPUT_SLOT.ordinal()};
	private static final int[] slotsBottom = new int[] {slotEnum.OUTPUT_SLOT.ordinal()};
	private static final int[] slotsSides = new int[] {};
	private ItemStack[] vespeneCondenserItemStackArray = new ItemStack[2];
	private int timeCanCondense;

	private int currentItemCondensationTime;
	private int ticksCondensingItemSoFar;
	private int ticksPerItem;
	private String vespeneCondenserCustomName;

	public TileEntityVespeneCondenser()
	{
		animationID = actionIDNone;
		animationTick = 0;

		setClockDefaults();
	}

	@Override
	public boolean shouldRefresh(World parWorld, BlockPos parPos, IBlockState parOldState, IBlockState parNewState)
	{
		return false;
	}

	@Override
	public int getSizeInventory()
	{
		return vespeneCondenserItemStackArray.length;
	}

	@Override
	public ItemStack getStackInSlot(int index)
	{
		return vespeneCondenserItemStackArray[index];
	}

	@Override
	public ItemStack decrStackSize(int index, int count)
	{
		if (vespeneCondenserItemStackArray[index] != null)
		{
			ItemStack itemstack;

			if (vespeneCondenserItemStackArray[index].stackSize <= count)
			{
				itemstack = vespeneCondenserItemStackArray[index];
				vespeneCondenserItemStackArray[index] = null;
				return itemstack;
			}
			else
			{
				itemstack = vespeneCondenserItemStackArray[index].splitStack(count);

				if (vespeneCondenserItemStackArray[index].stackSize == 0)
				{
					vespeneCondenserItemStackArray[index] = null;
				}

				return itemstack;
			}
		}
		else
		{
			return null;
		}
	}

	/**
	 * When some containers are closed they call this on each slot, then 

	 * drop whatever it returns as an EntityItem -
	 * like when you close a workbench GUI.
	 */
	@Override
	public ItemStack removeStackFromSlot(int index)
	{
		if (vespeneCondenserItemStackArray[index] != null)
		{
			ItemStack itemstack = vespeneCondenserItemStackArray[index];
			vespeneCondenserItemStackArray[index] = null;
			return itemstack;
		}
		else
		{
			return null;
		}
	}

	@Override

	public void setInventorySlotContents(int index, ItemStack stack)
	{
		boolean isSameItemStackAlreadyInSlot = stack != null && stack.isItemEqual(vespeneCondenserItemStackArray[index]) 
				&& ItemStack.areItemStackTagsEqual(stack, vespeneCondenserItemStackArray[index]);

		vespeneCondenserItemStackArray[index] = stack;

		if (stack != null && stack.stackSize > getInventoryStackLimit())
		{
			stack.stackSize = getInventoryStackLimit();
		}

		// if input slot, reset the condensing timers
		if (index == slotEnum.INPUT_SLOT.ordinal() && !isSameItemStackAlreadyInSlot)
		{
			ticksPerItem = timeToCondenseOneItem(stack);
			ticksCondensingItemSoFar = 0;
			markDirty();
		}
	}

	@Override
	public String getName()
	{
		return hasCustomName() ? vespeneCondenserCustomName : "container.vespenecondenser";
	}

	@Override
	public boolean hasCustomName()
	{
		return vespeneCondenserCustomName != null && vespeneCondenserCustomName.length() > 0;
	}

	public void setCustomInventoryName(String parCustomName)
	{
		vespeneCondenserCustomName = parCustomName;
	}

	@Override
	public void readFromNBT(NBTTagCompound compound)
	{
		super.readFromNBT(compound);
		NBTTagList nbttaglist = compound.getTagList("Items", 10);
		vespeneCondenserItemStackArray = new ItemStack[getSizeInventory()];

		for (int i = 0; i < nbttaglist.tagCount(); ++i)
		{
			NBTTagCompound nbtTagCompound = nbttaglist.getCompoundTagAt(i);
			byte b0 = nbtTagCompound.getByte("Slot");

			if (b0 >= 0 && b0 < vespeneCondenserItemStackArray.length)
			{
				vespeneCondenserItemStackArray[b0] = ItemStack.loadItemStackFromNBT(nbtTagCompound);
			}
		}

		timeCanCondense = compound.getShort("CondensationTime");
		ticksCondensingItemSoFar = compound.getShort("CookTime");
		ticksPerItem = compound.getShort("CookTimeTotal");

		if (compound.hasKey("CustomName", 8))
		{
			vespeneCondenserCustomName = compound.getString("CustomName");
		}
	}

	@Override
	public void writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setShort("CondensationTime", (short)timeCanCondense);
		compound.setShort("CookTime", (short)ticksCondensingItemSoFar);
		compound.setShort("CookTimeTotal", (short)ticksPerItem);
		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < vespeneCondenserItemStackArray.length; ++i)
		{
			if (vespeneCondenserItemStackArray[i] != null)
			{
				NBTTagCompound nbtTagCompound = new NBTTagCompound();
				nbtTagCompound.setByte("Slot", (byte)i);
				vespeneCondenserItemStackArray[i].writeToNBT(nbtTagCompound);
				nbttaglist.appendTag(nbtTagCompound);
			}
		}

		compound.setTag("Items", nbttaglist);

		if (hasCustomName())
		{
			compound.setString("CustomName", vespeneCondenserCustomName);
		}
	}

	@Override

	public int getInventoryStackLimit()
	{
		return 64;
	}

	public boolean condensingSomething()
	{
		return true;
	}

	// this function indicates whether container texture should be drawn
	@SideOnly(Side.CLIENT)
	public static boolean func_174903_a(IInventory parIInventory)
	{
		return true ;
	}

	@Override
	public void update()
	{
		boolean hasBeenCondensing = condensingSomething();
		boolean changedCondensationState = false;

		if (BlockVespeneCondenser.isPylonNearby(this.worldObj, this.pos) == true)
		{
			if (condensingSomething())
			{
				--timeCanCondense;
			}

			if (!worldObj.isRemote)
			{
				// if something in input slot
				if (vespeneCondenserItemStackArray[slotEnum.INPUT_SLOT.ordinal()] != null)
				{                
					// start condensing
					if (!condensingSomething() && canCondense())
					{
						timeCanCondense = 150;

						if (condensingSomething())
						{
							changedCondensationState = true;
						}
					}

					// continue condensing
					if (condensingSomething() && canCondense())
					{
						++ticksCondensingItemSoFar;

						// check if completed grinding an item
						if (ticksCondensingItemSoFar == ticksPerItem)
						{
							ticksCondensingItemSoFar = 0;
							ticksPerItem = timeToCondenseOneItem(vespeneCondenserItemStackArray[0]);
							condenseItem();
							changedCondensationState = true;
						}
					}
				}
				else
				{
					ticksCondensingItemSoFar = 0;
				}
			}

			incrementPartClocks();
		}
		
		// started or stopped condensing, update block to change to active 

		// or inactive model
		if (hasBeenCondensing != condensingSomething())
		{
			changedCondensationState = true;

		}

		if (changedCondensationState)
		{
			markDirty();
		}
	}

	public int timeToCondenseOneItem(ItemStack parItemStack)
	{
		return 200;
	}

	private boolean canCondense()
	{
		// if nothing in input slot
		if (vespeneCondenserItemStackArray[slotEnum.INPUT_SLOT.ordinal()] == null)
		{
			return false;
		}
		else // check if it has a condensation recipe
		{
			ItemStack itemStackToOutput = RecipesVespeneCondenser.instance().getCondensingResult(vespeneCondenserItemStackArray[slotEnum.INPUT_SLOT.ordinal()]);
			if (itemStackToOutput == null) return false; 
			if (vespeneCondenserItemStackArray[slotEnum.OUTPUT_SLOT.ordinal()] == null) return true; 
			if (!vespeneCondenserItemStackArray[slotEnum.OUTPUT_SLOT.ordinal()].isItemEqual(itemStackToOutput)) return false; 
			int result = vespeneCondenserItemStackArray[slotEnum.OUTPUT_SLOT.ordinal()].stackSize + itemStackToOutput.stackSize;
			return result <= getInventoryStackLimit() && result <= vespeneCondenserItemStackArray[slotEnum.OUTPUT_SLOT.ordinal()].getMaxStackSize();
		}
	}

	public void condenseItem()
	{
		if (canCondense())
		{
			ItemStack itemstack = RecipesVespeneCondenser.instance().getCondensingResult(vespeneCondenserItemStackArray[slotEnum.INPUT_SLOT.ordinal()]);

			// check if output slot is empty
			if (vespeneCondenserItemStackArray[slotEnum.OUTPUT_SLOT.ordinal()] == null)
			{
				vespeneCondenserItemStackArray[slotEnum.OUTPUT_SLOT.ordinal()] = itemstack.copy();

			}
			else if (vespeneCondenserItemStackArray[slotEnum.OUTPUT_SLOT.ordinal()].getItem() == itemstack.getItem())
			{
				vespeneCondenserItemStackArray[slotEnum.OUTPUT_SLOT.ordinal()].stackSize += itemstack.stackSize; 
			}

			--vespeneCondenserItemStackArray[slotEnum.INPUT_SLOT.ordinal()].stackSize;

			if (vespeneCondenserItemStackArray[slotEnum.INPUT_SLOT.ordinal()].stackSize <= 0)
			{
				vespeneCondenserItemStackArray[slotEnum.INPUT_SLOT.ordinal()] = null;
			}
		}
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer playerIn)
	{
		return worldObj.getTileEntity(pos) != this ? false : playerIn.getDistanceSq(pos.getX()+0.5D, pos.getY()+0.5D, pos.getZ()+0.5D) <= 64.0D;
	}

	@Override
	public void openInventory(EntityPlayer playerIn) {}

	@Override
	public void closeInventory(EntityPlayer playerIn) {}

	@Override
	public boolean isItemValidForSlot(int index, ItemStack stack)
	{
		return index == slotEnum.INPUT_SLOT.ordinal() ? true : false; 
	}

	@Override
	public int[] getSlotsForFace(EnumFacing side)
	{
		return side == EnumFacing.DOWN ? slotsBottom : 

			(side == EnumFacing.UP ? slotsTop : slotsSides);
	}

	@Override
	public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction)
	{
		return isItemValidForSlot(index, itemStackIn);
	}

	@Override
	public boolean canExtractItem(int parSlotIndex, ItemStack parStack, EnumFacing parFacing)
	{
		return true;
	}

	@Override
	public String getGuiID()
	{
		return "pokemonmd:vespenecondenser";
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
	{
		return new ContainerVespeneCondenser(playerInventory, this);
	}

	@Override
	public int getField(int id)
	{
		switch (id)
		{
		case 0:
			return timeCanCondense;
		case 1:
			return currentItemCondensationTime;
		case 2:
			return ticksCondensingItemSoFar;
		case 3:
			return ticksPerItem;
		default:
			return 0;
		}
	}

	@Override
	public void setField(int id, int value)
	{
		switch (id)
		{
		case 0:
			timeCanCondense = value;
			break;
		case 1:
			currentItemCondensationTime = value;
			break;
		case 2:
			ticksCondensingItemSoFar = value;
			break;
		case 3:
			ticksPerItem = value;
			break;
		default:
			break;
		}
	}

	@Override
	public int getFieldCount()
	{
		return 4;
	}

	@Override
	public void clear()
	{
		for (int i = 0; i < vespeneCondenserItemStackArray.length; ++i)
		{
			vespeneCondenserItemStackArray[i] = null;
		}
	}

	/************************************
	 * Animation dependent code follows.*
	 ************************************/
	public void incrementPartClocks()
	{
		for(int i = 0; i < rotationIdleAnimationClock.length; i++)
		{
			rotationIdleAnimationClock[i].incrementClocks();
		}

		for(int i = 0; i < verticalShiftIdleAnimationClock.length; i++)
		{
			verticalShiftIdleAnimationClock[i].incrementClocks();
		}

		coreShiftIdleAnimationClock.incrementClocks();
	}

	public IdleAnimationClock getIdleAnimationClockRotation(int partNumber) 
	{
		return rotationIdleAnimationClock[partNumber];
	}

	public IdleAnimationClock getIdleAnimationClockVerticalShift(int partNumber) 
	{
		return verticalShiftIdleAnimationClock[partNumber];
	}

	public IdleAnimationClock getIdleAnimationClockCoreShift() 
	{
		return coreShiftIdleAnimationClock;
	}	

	public void setClockDefaults()
	{
		setVerticalShiftClockDefaults();
		setRotationClockDefaults();
		setCoreShiftClockDefaults();
	}

	public void setVerticalShiftClockDefaults()
	{
		Random rand = new Random();

		int randomInt = rand.nextInt(100);

		for(int i = 0; i < verticalShiftIdleAnimationClock.length; i++)
		{
			verticalShiftIdleAnimationClock[i] = new IdleAnimationClock(0, 1, 0);

			verticalShiftIdleAnimationClock[i].setPhaseDurationY(0, 80);

			float frequencyY = 0.35F;

			int startingClockY = (int)(((float)(verticalShiftIdleAnimationClock.length - i) / (float)verticalShiftIdleAnimationClock.length) * (float)verticalShiftIdleAnimationClock[i].getTotalDurationLengthY() * frequencyY) + randomInt;

			while(startingClockY > verticalShiftIdleAnimationClock[i].getTotalDurationLengthY())
			{
				startingClockY -= verticalShiftIdleAnimationClock[i].getTotalDurationLengthY();
			}

			verticalShiftIdleAnimationClock[i].setClockY(startingClockY);
		}
	}

	public void setRotationClockDefaults()
	{
		Random rand = new Random();

		int randomInt = rand.nextInt(100);

		for(int i = 0; i < rotationIdleAnimationClock.length; i++)
		{
			rotationIdleAnimationClock[i] = new IdleAnimationClock(0, 1, 0);

			rotationIdleAnimationClock[i].setPhaseDurationY(0, 300);

			float frequencyY = 0.35F;

			int startingClockY = (int)(((float)(rotationIdleAnimationClock.length - i) / (float)rotationIdleAnimationClock.length) * (float)rotationIdleAnimationClock[i].getTotalDurationLengthY() * frequencyY) + randomInt;

			while(startingClockY > rotationIdleAnimationClock[i].getTotalDurationLengthY())
			{
				startingClockY -= rotationIdleAnimationClock[i].getTotalDurationLengthY();
			}

			rotationIdleAnimationClock[i].setClockY(startingClockY);
		}
	}

	public void setCoreShiftClockDefaults()
	{
		Random rand = new Random();

		int startingClockY = rand.nextInt(100);

		coreShiftIdleAnimationClock = new IdleAnimationClock(0, 1, 0);

		coreShiftIdleAnimationClock.setPhaseDurationY(0, 40);

		while(startingClockY > coreShiftIdleAnimationClock.getTotalDurationLengthY())
		{
			startingClockY -= coreShiftIdleAnimationClock.getTotalDurationLengthY();
		}

		coreShiftIdleAnimationClock.setClockY(startingClockY);
	}

	@Override
	public void setAnimationID(int id) 
	{
		animationID = id;
	}

	@Override
	public void setAnimationTick(int tick) 
	{
		animationTick = tick;	
	}

	@Override
	public int getAnimationID() 
	{
		return animationID;
	}

	@Override
	public int getAnimationTick() 
	{
		return animationTick;
	}
}
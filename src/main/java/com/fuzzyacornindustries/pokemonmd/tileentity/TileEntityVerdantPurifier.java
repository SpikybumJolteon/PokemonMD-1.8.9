package com.fuzzyacornindustries.pokemonmd.tileentity;

import java.util.Random;

import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.block.BlockVerdantPurifier;
import com.fuzzyacornindustries.pokemonmd.container.ContainerVerdantPurifier;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItems;
import com.fuzzyacornindustries.pokemonmd.recipes.FuelsVerdantPurifier;
import com.fuzzyacornindustries.pokemonmd.recipes.RecipesVerdantPurifier;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityVerdantPurifier extends TileEntityLockable implements ISidedInventory, ITickable, IAnimatedEntity
{	
	public enum slotEnum 
	{
		INPUT_SLOT, FUEL_SLOT, OUTPUT_SLOT
	}

	private static final int[] slotsTop = new int[] { slotEnum.INPUT_SLOT.ordinal() };
	private static final int[] slotsBottom = new int[] { slotEnum.OUTPUT_SLOT.ordinal(), slotEnum.FUEL_SLOT.ordinal() };
	private static final int[] slotsSides = new int[] { slotEnum.FUEL_SLOT.ordinal() };

	private ItemStack[] purifierItemStackArray = new ItemStack[3];

	private int purifierFuelTime; // furnaceBurnTime equivalent
	private int currentFuelTime; // currentBurnTime equivalent
	private int purifierDurationTime; // furnaceCookTime equivalent
	private int ticksPerItem;
	private int ticksPerFuel;

	private String purifierCustomName;

	private IdleAnimationClock petalsIdleAnimationClock;
	private IdleAnimationClock chamberIdleAnimationClock;
	private IdleAnimationClock chamberShiftIdleAnimationClock;
	private IdleAnimationClock verticalShiftIdleAnimationClock[] = new IdleAnimationClock[2];

	public static final int actionIDNone = 0;

	private int animationID;
	private int animationTick;

	public TileEntityVerdantPurifier()
	{
		animationID = actionIDNone;
		animationTick = 0;

		setClockDefaults();
	}

	@Override
	public boolean shouldRefresh(World parWorld, BlockPos parPos, 
			IBlockState parOldState, IBlockState parNewState)
	{
		return false;
	}

	@Override
	public int getSizeInventory() 
	{
		return this.purifierItemStackArray.length;
	}

	@Override
	public ItemStack getStackInSlot(int slotIndex) 
	{
		return this.purifierItemStackArray[slotIndex];
	}

	@Override
	public ItemStack decrStackSize(int slotIndex, int maximumStackSize) 
	{
		if (this.purifierItemStackArray[slotIndex] != null) 
		{
			ItemStack itemstack;

			if (this.purifierItemStackArray[slotIndex].stackSize <= maximumStackSize) 
			{
				itemstack = this.purifierItemStackArray[slotIndex];
				this.purifierItemStackArray[slotIndex] = null;
				return itemstack;
			} 
			else 
			{
				itemstack = this.purifierItemStackArray[slotIndex].splitStack(maximumStackSize);

				if (this.purifierItemStackArray[slotIndex].stackSize == 0) 
				{
					this.purifierItemStackArray[slotIndex] = null;
				}
				return itemstack;
			}
		} 
		else 
		{
			return null;
		}
	}

	@Override
	public ItemStack removeStackFromSlot(int slotIndex) 
	{
		if (this.purifierItemStackArray[slotIndex] != null) 
		{
			ItemStack itemstack = this.purifierItemStackArray[slotIndex];
			this.purifierItemStackArray[slotIndex] = null;
			return itemstack;
		} 
		else 
		{
			return null;
		}
	}
	
	@Override
	public void setInventorySlotContents(int slotIndex, ItemStack itemStack) 
	{
		boolean isSameItemStackAlreadyInSlot = itemStack != null 
				&& itemStack.isItemEqual(purifierItemStackArray[slotIndex]) 
				&& ItemStack.areItemStackTagsEqual(itemStack, purifierItemStackArray[slotIndex]);

		purifierItemStackArray[slotIndex] = itemStack;

		if (itemStack != null && itemStack.stackSize > getInventoryStackLimit())
		{
			itemStack.stackSize = getInventoryStackLimit();
		}

		// if input slot, reset the purifier timers
		if (slotIndex == slotEnum.INPUT_SLOT.ordinal() && !isSameItemStackAlreadyInSlot)
		{
			ticksPerItem = timeToPurifyOneItem(itemStack);
			purifierDurationTime = 0;
			markDirty();
		}
	}

	@Override
	public String getName() 
	{
		return this.hasCustomName() ? this.purifierCustomName : "container.verdantpurifier";
	}

	@Override
	public boolean hasCustomName() 
	{
		return this.purifierCustomName != null && this.purifierCustomName.length() > 0;
	}

	public void setCustomInventoryName(String parCustomName)
	{
		purifierCustomName = parCustomName;
	}

	public void readFromNBT(NBTTagCompound tagCompound) 
	{
		super.readFromNBT(tagCompound);

		NBTTagList tagList = tagCompound.getTagList("Items", 10);
		this.purifierItemStackArray = new ItemStack[this.getSizeInventory()];

		for (int i = 0; i < tagList.tagCount(); ++i) 
		{
			NBTTagCompound tabCompound1 = tagList.getCompoundTagAt(i);
			byte byte0 = tabCompound1.getByte("Slot");

			if (byte0 >= 0 && byte0 < this.purifierItemStackArray.length) 
			{
				this.purifierItemStackArray[byte0] = ItemStack.loadItemStackFromNBT(tabCompound1);
			}
		}

		this.purifierFuelTime = tagCompound.getShort("PurifyTime");
		this.purifierDurationTime = tagCompound.getShort("PurifyDurationTime");
		this.currentFuelTime = getItemPurificationFuelTime(this.purifierItemStackArray[1]);

		if (tagCompound.hasKey("CustomName", 8)) 
		{
			this.purifierCustomName = tagCompound.getString("CustomName");
		}
	}

	public void writeToNBT(NBTTagCompound tagCompound) 
	{
		super.writeToNBT(tagCompound);

		tagCompound.setShort("PurifyTime", (short) this.purifierFuelTime);
		tagCompound.setShort("PurifyDurationTime", (short) this.purifierFuelTime);

		NBTTagList tagList = new NBTTagList();

		for (int i = 0; i < this.purifierItemStackArray.length; ++i) 
		{
			if (this.purifierItemStackArray[i] != null) 
			{
				NBTTagCompound tagCompound1 = new NBTTagCompound();
				tagCompound1.setByte("Slot", (byte) i);
				this.purifierItemStackArray[i].writeToNBT(tagCompound1);
				tagList.appendTag(tagCompound1);
			}
		}

		tagCompound.setTag("Items", tagList);

		if (this.hasCustomName()) 
		{
			tagCompound.setString("CustomName", this.purifierCustomName);
		}
	}

	@Override
	public int getInventoryStackLimit() 
	{
		return 64;
	}

	public boolean isPurifying() 
	{
		return this.purifierFuelTime > 0;
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
		boolean hasBeenPurifying = isPurifying();
		boolean changedPurifyingState = false;

		if (BlockVerdantPurifier.isPylonNearby(this.worldObj, this.pos) == true)
		{
			if (isPurifying()) 
			{
				--this.purifierFuelTime;
			}

			if (!this.worldObj.isRemote) 
			{
				if (this.purifierFuelTime == 0 && this.canPurify()) 
				{
					//System.out.println("Before");
					//System.out.println(Integer.toString(this.furnaceBurnTime) + " " + Integer.toString(this.currentBurnTime) + " " + getItemBurnTime(this.furnaceItemStacks[1]));

					this.currentFuelTime = this.purifierFuelTime = getItemPurificationFuelTime(this.purifierItemStackArray[slotEnum.FUEL_SLOT.ordinal()]);

					//System.out.println("After");
					//System.out.println(Integer.toString(this.furnaceBurnTime) + " " + Integer.toString(this.currentBurnTime) + " " + getItemBurnTime(this.furnaceItemStacks[1]));
					//System.out.println("--------------------");

					if (this.purifierFuelTime > 0) 
					{
						changedPurifyingState = true;

						if (this.purifierItemStackArray[slotEnum.FUEL_SLOT.ordinal()] != null) 
						{
							--this.purifierItemStackArray[slotEnum.FUEL_SLOT.ordinal()].stackSize;

							if (this.purifierItemStackArray[slotEnum.FUEL_SLOT.ordinal()].stackSize == 0) 
							{
								this.purifierItemStackArray[slotEnum.FUEL_SLOT.ordinal()] = purifierItemStackArray[1].getItem().getContainerItem(this.purifierItemStackArray[slotEnum.FUEL_SLOT.ordinal()]);
							}
						}
					}
				}

				if (this.isPurifying() && this.canPurify()) 
				{
					++this.purifierDurationTime;

					//System.out.println( "Test Fuel Time Code" );
					//System.out.println(Integer.toString(getItemPurificationFuelTime(this.purifierItemStackArray[slotEnum.FUEL_SLOT.ordinal()])));

					this.ticksPerItem = 200;
					this.ticksPerFuel = getItemPurificationFuelTime(this.purifierItemStackArray[slotEnum.FUEL_SLOT.ordinal()]);

					if (this.purifierDurationTime >= 200) 
					{
						this.purifierDurationTime = 0;
						this.purifyItem();
						changedPurifyingState = true;
					}
				} 
				else 
				{
					this.purifierDurationTime = 0;
					this.ticksPerFuel = 0;
				}
			}

			incrementPartClocks();
		}

		if (hasBeenPurifying != isPurifying()) 
		{
			changedPurifyingState = true;
		}

		if (changedPurifyingState) 
		{
			this.markDirty();
		}
	}


	public int timeToPurifyOneItem(ItemStack parItemStack)
	{
		return 200;
	}

	private boolean canPurify() 
	{
		if (this.purifierItemStackArray[slotEnum.INPUT_SLOT.ordinal()] == null) 
		{
			return false;
		} 
		else 
		{
			ItemStack itemStackToOutput = RecipesVerdantPurifier.instance().getPurifyingResult(this.purifierItemStackArray[slotEnum.INPUT_SLOT.ordinal()]);

			if (itemStackToOutput == null) return false;

			if (this.purifierItemStackArray[slotEnum.OUTPUT_SLOT.ordinal()] == null) return true;

			if (!this.purifierItemStackArray[slotEnum.OUTPUT_SLOT.ordinal()].isItemEqual(itemStackToOutput)) return false;

			int result = purifierItemStackArray[slotEnum.OUTPUT_SLOT.ordinal()].stackSize + itemStackToOutput.stackSize;
			return result <= getInventoryStackLimit() && result <= this.purifierItemStackArray[slotEnum.OUTPUT_SLOT.ordinal()].getMaxStackSize();
		}
	}

	public void purifyItem() 
	{
		if (this.canPurify()) 
		{
			ItemStack resaultingItemstack = RecipesVerdantPurifier.instance().getPurifyingResult(this.purifierItemStackArray[slotEnum.INPUT_SLOT.ordinal()]);

			if (this.purifierItemStackArray[slotEnum.OUTPUT_SLOT.ordinal()] == null) 
			{
				this.purifierItemStackArray[slotEnum.OUTPUT_SLOT.ordinal()] = resaultingItemstack.copy();
			} 
			else if (this.purifierItemStackArray[slotEnum.OUTPUT_SLOT.ordinal()].getItem() == resaultingItemstack.getItem()) 
			{
				this.purifierItemStackArray[slotEnum.OUTPUT_SLOT.ordinal()].stackSize += resaultingItemstack.stackSize;
			}

			--this.purifierItemStackArray[slotEnum.INPUT_SLOT.ordinal()].stackSize;

			if(this.purifierItemStackArray[slotEnum.INPUT_SLOT.ordinal()].stackSize <= 0)
			{
				this.purifierItemStackArray[slotEnum.INPUT_SLOT.ordinal()] = null;
			}
		}
	}

	public static int getItemPurificationFuelTime(ItemStack itemstack)
	{
		int fuelTime = 0;

		if(itemstack == null)
		{
			return 0;
		}
		else
		{
			fuelTime = FuelsVerdantPurifier.instance().getVerdantPurifierFuelTime(itemstack);
		}
		/*
			if(item instanceof ItemBlock && Block.getBlockFromItem(item) != Blocks.air)
			{
				Block block = Block.getBlockFromItem(item);

				if(block == Blocks.pumpkin)
				{
					return 400;
				}
				else if(block == Blocks.melon_block)
				{
					return 400;
				}
				else if(block == Blocks.cactus)
				{
					return 100;
				}
				else if(block == Blocks.leaves || block == Blocks.leaves2 || block == Blocks.vine)
				{
					return 50;
				}
				else if(block == Blocks.waterlily)
				{
					return 800;
				}
				else if(block == Blocks.sapling)
				{
					return 200;
				}
				else
				{
					return GameRegistry.getFuelValue(itemstack);
				}
			}

			if(item == Items.reeds) return 100;
			if(item == Items.wheat) return 200;
			if(item == Items.wheat_seeds) return 50;
			if(item == Items.apple) return 400;
			if(item == Items.potato) return 200;
			if(item == Items.carrot) return 200;
			if(item == Items.melon) return 100;
			if(item == PokemonMDItems.colbertaBerry) return 400;
			if(item == PokemonMDItems.oranianBerry) return 100;
			if(item == PokemonMDItems.passhauraBerry) return 200;
			if(item == PokemonMDItems.pechitaBerry) return 200;
			if(item == PokemonMDItems.rawstettaBerry) return 200;

			//if(item instanceof ItemTool && ((ItemTool) item).getToolMaterialName().equals("EMERALD")) return 300;

		 */
		return fuelTime;
	}

	public static boolean isItemFuel(ItemStack itemstack)
	{
		return getItemPurificationFuelTime(itemstack) > 0;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer player) 
	{
		return worldObj.getTileEntity(pos) != this ? false : player.getDistanceSq(pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ()+0.5D) <= 64.0D;
	}

	@Override
	public void openInventory(EntityPlayer player) {}

	@Override
	public void closeInventory(EntityPlayer player) {}

	@Override
	public boolean isItemValidForSlot(int slotIndex, ItemStack itemStack) 
	{
		return slotIndex == 2 ? false : (slotIndex == 1 ? isItemFuel(itemStack) : true);
	}

	@Override
	public int[] getSlotsForFace(EnumFacing side)
	{
		return side == EnumFacing.DOWN ? slotsBottom : (side == EnumFacing.UP ? slotsTop : slotsSides);
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
		return "pokemonmd:verdantpurifier";
	}

	@Override
	public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
	{
		return new ContainerVerdantPurifier(playerInventory, this);
	}

	@Override
	public int getField(int id)
	{
		switch (id)
		{
		case 0:
			return purifierFuelTime;
		case 1:
			return currentFuelTime;
		case 2:
			return purifierDurationTime;
		case 3:
			return ticksPerItem;
		case 4:
			return ticksPerFuel;
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
			purifierFuelTime = value;
			break;
		case 1:
			currentFuelTime = value;
			break;
		case 2:
			purifierDurationTime = value;
			break;
		case 3:
			ticksPerItem = value;
			break;
		case 4:
			ticksPerFuel = value;
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
		for (int i = 0; i < purifierItemStackArray.length; ++i)
		{
			purifierItemStackArray[i] = null;
		}
	}

	/************************************
	 * Animation dependent code follows.*
	 ************************************/
	public IdleAnimationClock getIdleAnimationClockPetals() 
	{
		return petalsIdleAnimationClock;
	}

	public IdleAnimationClock getIdleAnimationClockChamber() 
	{

		return chamberIdleAnimationClock;
	}

	public IdleAnimationClock getIdleAnimationClockVerticalShift(int partNumber) 
	{
		return verticalShiftIdleAnimationClock[partNumber];
	}

	public void incrementPartClocks()
	{
		for(int i = 0; i < verticalShiftIdleAnimationClock.length; i++)
		{
			verticalShiftIdleAnimationClock[i].incrementClocks();
		}

		chamberIdleAnimationClock.incrementClocks();
		petalsIdleAnimationClock.incrementClocks();
	}

	public void setClockDefaults()
	{
		setVerticalShiftDefaults();
		setChamberDefaults();
		setPetalsClockDefaults();
	}

	public void setVerticalShiftDefaults()
	{
		Random rand = new Random();

		int randomInt = rand.nextInt(100);

		for(int i = 0; i < verticalShiftIdleAnimationClock.length; i++)
		{
			verticalShiftIdleAnimationClock[i] = new IdleAnimationClock(1, 1, 0);

			verticalShiftIdleAnimationClock[i].setPhaseDurationX(0, 80);
			verticalShiftIdleAnimationClock[i].setPhaseDurationY(0, 80);

			float frequencyY = 0.15F;

			int startingClockX = (int)(((float)(verticalShiftIdleAnimationClock.length - i) / (float)verticalShiftIdleAnimationClock.length) * (float)verticalShiftIdleAnimationClock[i].getTotalDurationLengthX() * frequencyY) + randomInt;
			int startingClockY = (int)(((float)(verticalShiftIdleAnimationClock.length - i) / (float)verticalShiftIdleAnimationClock.length) * (float)verticalShiftIdleAnimationClock[i].getTotalDurationLengthY() * frequencyY) + randomInt;

			while(startingClockX > verticalShiftIdleAnimationClock[i].getTotalDurationLengthX())
			{
				startingClockX -= verticalShiftIdleAnimationClock[i].getTotalDurationLengthX();
			}

			while(startingClockY > verticalShiftIdleAnimationClock[i].getTotalDurationLengthY())
			{
				startingClockY -= verticalShiftIdleAnimationClock[i].getTotalDurationLengthY();
			}

			verticalShiftIdleAnimationClock[i].setClockX(startingClockX);
			verticalShiftIdleAnimationClock[i].setClockY(startingClockY);
		}
	}

	public void setChamberDefaults()
	{
		Random rand = new Random();

		int startingClockX = rand.nextInt(100);
		int startingClockY = rand.nextInt(100);
		int startingClockZ = rand.nextInt(100);

		chamberIdleAnimationClock = new IdleAnimationClock(1, 1, 1);

		chamberIdleAnimationClock.setPhaseDurationX(0, 200);
		chamberIdleAnimationClock.setPhaseDurationY(0, 350);
		chamberIdleAnimationClock.setPhaseDurationZ(0, 230);

		while(startingClockX > chamberIdleAnimationClock.getTotalDurationLengthX())
		{
			startingClockX -= chamberIdleAnimationClock.getTotalDurationLengthX();
		}

		while(startingClockY > chamberIdleAnimationClock.getTotalDurationLengthY())
		{
			startingClockY -= chamberIdleAnimationClock.getTotalDurationLengthY();
		}

		while(startingClockZ > chamberIdleAnimationClock.getTotalDurationLengthZ())
		{
			startingClockZ -= chamberIdleAnimationClock.getTotalDurationLengthZ();
		}

		chamberIdleAnimationClock.setClockX(startingClockX);
		chamberIdleAnimationClock.setClockY(startingClockY);
		chamberIdleAnimationClock.setClockZ(startingClockZ);
	}

	public void setPetalsClockDefaults()
	{
		Random rand = new Random();

		int startingClockX = rand.nextInt(100);
		int startingClockY = rand.nextInt(100);

		petalsIdleAnimationClock = new IdleAnimationClock(4, 1, 0);

		petalsIdleAnimationClock.setPhaseDurationX(0, 110);
		petalsIdleAnimationClock.setPhaseDurationX(1, 80);
		petalsIdleAnimationClock.setPhaseDurationX(2, 40);
		petalsIdleAnimationClock.setPhaseDurationX(3, 100);

		petalsIdleAnimationClock.setPhaseDurationY(0, 500);

		while(startingClockX > petalsIdleAnimationClock.getTotalDurationLengthX())
		{
			startingClockX -= petalsIdleAnimationClock.getTotalDurationLengthX();
		}

		while(startingClockY > petalsIdleAnimationClock.getTotalDurationLengthY())
		{
			startingClockY -= petalsIdleAnimationClock.getTotalDurationLengthY();
		}

		//petalsIdleAnimationClock.setClockX(startingClockX);
		petalsIdleAnimationClock.setClockY(startingClockY);
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
package com.fuzzyacornindustries.pokemonmd.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.fuzzyacornindustries.pokemonmd.recipes.RecipesVerdantPurifier;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityVerdantPurifier;

public class ContainerVerdantPurifier extends Container 
{
	private final IInventory tileVerdantPurifier;
	private final int sizeInventory;
	//private TileEntityVerdantPurifier tileVerdantPurifier;

	private int lastPurifyingTime;
	private int lastBurnTime;
	private int lastItemBurnTime;
	private int ticksPerItem;

	public ContainerVerdantPurifier(InventoryPlayer parInventoryPlayer, IInventory parIInventory)
	{
		tileVerdantPurifier = parIInventory;
		sizeInventory = tileVerdantPurifier.getSizeInventory();
		this.addSlotToContainer(new Slot(tileVerdantPurifier, TileEntityVerdantPurifier.slotEnum.INPUT_SLOT.ordinal(), 56, 17));
		this.addSlotToContainer(new Slot(tileVerdantPurifier, TileEntityVerdantPurifier.slotEnum.FUEL_SLOT.ordinal(), 56, 53));
		this.addSlotToContainer(new SlotVerdantPurifierOutput(parInventoryPlayer.player, tileVerdantPurifier, TileEntityVerdantPurifier.slotEnum.OUTPUT_SLOT.ordinal(), 116, 35));

		int i;

		for(i = 0; i < 3; ++i)
		{
			for(int j = 0; j < 9; ++j)
			{
				addSlotToContainer(new Slot(parInventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for(i = 0; i < 9; ++i)
		{
			addSlotToContainer(new Slot(parInventoryPlayer, i , 8 + i * 18 , 142));
		}
	}

	@Override
    public void onCraftGuiOpened(ICrafting listener)
    {
        super.onCraftGuiOpened(listener);
        listener.sendAllWindowProperties(this, tileVerdantPurifier);
	}

	@Override
	public void detectAndSendChanges()
	{
		super.detectAndSendChanges();

		for(int i = 0; i < crafters.size(); ++i)
		{
			ICrafting craft = (ICrafting)crafters.get(i);

			if(lastPurifyingTime != tileVerdantPurifier.getField(0))
			{
				craft.sendProgressBarUpdate(this, 0, tileVerdantPurifier.getField(0));
			}

			if(lastBurnTime != tileVerdantPurifier.getField(1))
			{
				craft.sendProgressBarUpdate(this, 1, tileVerdantPurifier.getField(1));
			}

			if(lastItemBurnTime != tileVerdantPurifier.getField(2))
			{
				craft.sendProgressBarUpdate(this, 2, tileVerdantPurifier.getField(2));
			}

			if(ticksPerItem != tileVerdantPurifier.getField(3))
			{
				craft.sendProgressBarUpdate(this, 3, tileVerdantPurifier.getField(3));
			}
		}

		lastBurnTime = tileVerdantPurifier.getField(0);
		lastPurifyingTime = tileVerdantPurifier.getField(1);
		lastItemBurnTime = tileVerdantPurifier.getField(2);
		ticksPerItem = tileVerdantPurifier.getField(3);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int id, int data)
	{
		tileVerdantPurifier.setField(id, data);
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) 
	{
		return tileVerdantPurifier.isUseableByPlayer(player);
	}

	public ItemStack transferStackInSlot(EntityPlayer player, int slotIndex)
	{
		ItemStack itemstack1 = null;
		Slot slot = (Slot) this.inventorySlots.get(slotIndex);

		if(slot != null && slot.getHasStack())
		{
			ItemStack itemstack2 = slot.getStack();
			itemstack1 = itemstack2.copy();

			if(slotIndex == TileEntityVerdantPurifier.slotEnum.OUTPUT_SLOT.ordinal())
			{
				if(!this.mergeItemStack(itemstack2, 3, 39, true))
				{
					return null;
				}

				slot.onSlotChange(itemstack2, itemstack1);
			}
			else if(slotIndex != TileEntityVerdantPurifier.slotEnum.FUEL_SLOT.ordinal() 
					&& slotIndex != TileEntityVerdantPurifier.slotEnum.INPUT_SLOT.ordinal())
			{
				if(RecipesVerdantPurifier.instance().getPurifyingResult(itemstack2) != null)
				{
					if(!this.mergeItemStack(itemstack2, 0, 1, false))
					{
						return null;
					}
				}
				else if(TileEntityVerdantPurifier.isItemFuel(itemstack2))
				{
					if(!this.mergeItemStack(itemstack2, 1, 2, false))
					{
						return null;
					}
				}
				else if(slotIndex >=3 && slotIndex < 30)
				{
					if(!this.mergeItemStack(itemstack2, 30, 39, false))
					{
						return null;
					}
				}
				else if(slotIndex >= 30 && slotIndex < 39 && !this.mergeItemStack(itemstack2, 3, 30, false))
				{
					return null;
				}
			}
			else if(!this.mergeItemStack(itemstack2, 3, 39, false))
			{
				return null;
			}

			if(itemstack2.stackSize == 0)
			{
				slot.putStack((ItemStack)null);
			}
			else
			{
				slot.onSlotChanged();
			}

			if(itemstack2.stackSize == itemstack1.stackSize)
			{
				return null;
			}

			slot.onPickupFromSlot(player, itemstack2);
		}

		return itemstack1;
	}
}
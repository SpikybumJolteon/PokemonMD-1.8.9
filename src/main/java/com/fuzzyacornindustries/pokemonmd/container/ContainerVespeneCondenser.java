package com.fuzzyacornindustries.pokemonmd.container;

import com.fuzzyacornindustries.pokemonmd.recipes.RecipesVespeneCondenser;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityVespeneCondenser;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ContainerVespeneCondenser extends Container
{
    private final IInventory tileVespeneCondenser;
    private final int sizeInventory;
    private int ticksCondensingItemSoFar;
    private int ticksPerItem;
    private int timeCanCondense;

	/* Smelt Item Slot */
	public static final int smeltItemSlotX = 55;
	public static final int smeltItemSlotY = 37;

	/* Smelt Item Slot */
	public static final int productItemSlotX = 105;
	public static final int productItemSlotY = 37;
	
    public ContainerVespeneCondenser(InventoryPlayer parInventoryPlayer, IInventory parIInventory)
    {
        tileVespeneCondenser = parIInventory;
        sizeInventory = tileVespeneCondenser.getSizeInventory();
        addSlotToContainer(new Slot(tileVespeneCondenser, TileEntityVespeneCondenser.slotEnum.INPUT_SLOT.ordinal(), smeltItemSlotX, smeltItemSlotY));
        addSlotToContainer(new SlotVespeneCondenserOutput(parInventoryPlayer.player, tileVespeneCondenser, 
        		TileEntityVespeneCondenser.slotEnum.OUTPUT_SLOT.ordinal(), productItemSlotX, productItemSlotY));
        
        // add player inventory slots
        // note that the slot numbers are within the player inventory so can 
        // be same as the tile entity inventory
        int i;
        
        for (i = 0; i < 3; ++i)
        {
            for (int j = 0; j < 9; ++j)
            {
                addSlotToContainer(new Slot(parInventoryPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        // add hotbar slots
        for (i = 0; i < 9; ++i)
        {
            addSlotToContainer(new Slot(parInventoryPlayer, i, 8 + i * 18, 
            142));
        }
    }

	@Override
    public void onCraftGuiOpened(ICrafting listener)
    {
        super.onCraftGuiOpened(listener);
        listener.sendAllWindowProperties(this, tileVespeneCondenser);
	}

    /**
     * Looks for changes made in the container, sends them to every listener.
     */
    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for (int i = 0; i < crafters.size(); ++i)
        {
            ICrafting icrafting = (ICrafting)crafters.get(i);

            if (ticksCondensingItemSoFar != tileVespeneCondenser.getField(2))
            {
                icrafting.sendProgressBarUpdate(this, 2, tileVespeneCondenser.getField(2));
            }

            if (timeCanCondense != tileVespeneCondenser.getField(0))
            {
                icrafting.sendProgressBarUpdate(this, 0, tileVespeneCondenser.getField(0));
            }

            if (ticksPerItem != tileVespeneCondenser.getField(3))
            {
                icrafting.sendProgressBarUpdate(this, 3, tileVespeneCondenser.getField(3));
            }
        }

        ticksCondensingItemSoFar = tileVespeneCondenser.getField(2);
        timeCanCondense = tileVespeneCondenser.getField(0); 
        ticksPerItem = tileVespeneCondenser.getField(3); 
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data)
    {
        tileVespeneCondenser.setField(id, data);
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return tileVespeneCondenser.isUseableByPlayer(playerIn);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int slotIndex)
    {
        ItemStack itemStack1 = null;
        Slot slot = (Slot)inventorySlots.get(slotIndex);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemStack2 = slot.getStack();
            itemStack1 = itemStack2.copy();

            if (slotIndex == TileEntityVespeneCondenser.slotEnum.OUTPUT_SLOT.ordinal())
            {
                if (!mergeItemStack(itemStack2, sizeInventory, sizeInventory+36, true))
                {
                    return null;
                }

                slot.onSlotChange(itemStack2, itemStack1);
            }
            else if (slotIndex != TileEntityVespeneCondenser.slotEnum.INPUT_SLOT.ordinal())
            {
                // check if there is a grinding recipe for the stack
                if (RecipesVespeneCondenser.instance().getCondensingResult(itemStack2) != null)
                {
                    if (!mergeItemStack(itemStack2, 0, 1, false))
                    {
                        return null;
                    }
                }
                else if (slotIndex >= sizeInventory && slotIndex < sizeInventory+27) // player inventory slots
                {
                    if (!mergeItemStack(itemStack2, sizeInventory+27, sizeInventory + 36, false))
                    {
                        return null;
                    }
                }
                else if (slotIndex >= sizeInventory + 27 && slotIndex < sizeInventory + 36 && !mergeItemStack(itemStack2, sizeInventory + 1, sizeInventory+27, false)) // hotbar slots
                {
                    return null;
                }
            }
            else if (!mergeItemStack(itemStack2, sizeInventory, sizeInventory + 36, false))
            {
                return null;
            }

            if (itemStack2.stackSize == 0)
            {
                slot.putStack((ItemStack)null);
            }
            else
            {
                slot.onSlotChanged();
            }

            if (itemStack2.stackSize == itemStack1.stackSize)
            {
                return null;
            }

            slot.onPickupFromSlot(playerIn, itemStack2);
        }

        return itemStack1;
    }
}
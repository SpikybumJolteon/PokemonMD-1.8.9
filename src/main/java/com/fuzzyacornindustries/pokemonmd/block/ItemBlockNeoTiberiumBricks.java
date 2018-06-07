package com.fuzzyacornindustries.pokemonmd.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBlockNeoTiberiumBricks extends ItemBlock 
{
	public ItemBlockNeoTiberiumBricks(Block block) 
	{
		super(block);
	}

	@Override
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List parList, boolean parBoolean) 
	{
		parList.add("Bricks with high");
		parList.add("blast resistance.");
	}
}
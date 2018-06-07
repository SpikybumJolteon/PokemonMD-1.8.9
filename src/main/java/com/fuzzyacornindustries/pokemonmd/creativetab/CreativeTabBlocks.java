package com.fuzzyacornindustries.pokemonmd.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.fuzzyacornindustries.pokemonmd.block.PokemonMDBlocks;

public class CreativeTabBlocks extends CreativeTabs 
{
	public CreativeTabBlocks(String par2Str)
	{
		super(par2Str);
	}

	@Override
	public Item getTabIconItem()
	{
		return Item.getItemFromBlock(PokemonMDBlocks.xelNagaTechBlock);
	}
}
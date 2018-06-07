package com.fuzzyacornindustries.pokemonmd.creativetab;

import com.fuzzyacornindustries.pokemonmd.block.PokemonMDBlocks;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabMobs extends CreativeTabs 
{
	public CreativeTabMobs(String par2Str)
	{
		super(par2Str);
	}

	@Override
	public Item getTabIconItem()
	{
		return PokemonMDItems.blessingOfArceus;
	}
}
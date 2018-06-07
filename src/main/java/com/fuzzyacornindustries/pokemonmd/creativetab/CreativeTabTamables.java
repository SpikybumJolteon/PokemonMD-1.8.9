package com.fuzzyacornindustries.pokemonmd.creativetab;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItems;

public class CreativeTabTamables extends CreativeTabs 
{
	public CreativeTabTamables(String lable)
	{
		super(lable);
	}

	@Override
	public Item getTabIconItem()
	{
		return PokemonMDItems.blessingOfArceus;
	}
}
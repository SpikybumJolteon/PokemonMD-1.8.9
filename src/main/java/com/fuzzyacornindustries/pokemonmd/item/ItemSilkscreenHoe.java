package com.fuzzyacornindustries.pokemonmd.item;

import net.minecraft.item.ItemHoe;

import com.fuzzyacornindustries.pokemonmd.creativetab.PokemonMDCreativeTabs;

public class ItemSilkscreenHoe extends ItemHoe
{
	public static String itemName = "silkscreenhoe";

	protected ItemSilkscreenHoe() 
	{
		super(PokemonMDItems.SILKSCREEN_TOOL);
		this.setUnlocalizedName(itemName);
		this.setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDItems);
	}

	static public String getItemName()
	{
		return itemName;
	}
}
package com.fuzzyacornindustries.pokemonmd.item;

import net.minecraft.item.ItemSpade;

import com.fuzzyacornindustries.pokemonmd.creativetab.PokemonMDCreativeTabs;

public class ItemSilkscreenShovel extends ItemSpade
{
	public static String itemName = "silkscreenshovel";

	protected ItemSilkscreenShovel() 
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
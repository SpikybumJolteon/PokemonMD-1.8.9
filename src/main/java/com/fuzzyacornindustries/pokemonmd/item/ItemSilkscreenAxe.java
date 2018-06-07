package com.fuzzyacornindustries.pokemonmd.item;

import net.minecraft.item.ItemAxe;

import com.fuzzyacornindustries.pokemonmd.creativetab.PokemonMDCreativeTabs;

public class ItemSilkscreenAxe extends ItemAxe
{
	public static String itemName = "silkscreenaxe";

	protected ItemSilkscreenAxe() 
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
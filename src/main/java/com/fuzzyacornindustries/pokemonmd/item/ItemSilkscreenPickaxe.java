package com.fuzzyacornindustries.pokemonmd.item;

import net.minecraft.item.ItemPickaxe;

import com.fuzzyacornindustries.pokemonmd.creativetab.PokemonMDCreativeTabs;

public class ItemSilkscreenPickaxe extends ItemPickaxe
{
	public static String itemName = "silkscreenpickaxe";

	protected ItemSilkscreenPickaxe() 
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
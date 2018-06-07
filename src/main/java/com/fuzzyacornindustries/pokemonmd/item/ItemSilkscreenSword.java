package com.fuzzyacornindustries.pokemonmd.item;

import net.minecraft.item.ItemSword;

import com.fuzzyacornindustries.pokemonmd.creativetab.PokemonMDCreativeTabs;

public class ItemSilkscreenSword extends ItemSword
{
	public static String itemName = "silkscreensword";

	protected ItemSilkscreenSword() 
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
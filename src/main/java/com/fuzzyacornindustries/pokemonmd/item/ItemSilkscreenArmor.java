package com.fuzzyacornindustries.pokemonmd.item;

import com.fuzzyacornindustries.pokemonmd.creativetab.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.main.PokemonMD;
import com.fuzzyacornindustries.pokemonmd.reference.ModStrings;

import net.minecraft.item.ItemArmor;

public class ItemSilkscreenArmor extends ItemArmor
{
	public ItemSilkscreenArmor(ArmorMaterial material, int renderIndex, int armorType) {
        
		super(material, renderIndex, armorType);
		
		String pieceName;
		
		if(armorType == 0)
		{
			pieceName = "silkscreenhelmet";
			this.setUnlocalizedName(pieceName);
		}
		else if(armorType == 1)
		{
			pieceName = "silkscreenchestplate";
			this.setUnlocalizedName(pieceName);
		}
		else if(armorType == 2)
		{
			pieceName = "silkscreenleggings";
			this.setUnlocalizedName(pieceName);
		}
		else
		{
			pieceName = "silkscreenboots";
			this.setUnlocalizedName(pieceName);
		}

		this.setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDItems);
	}
}
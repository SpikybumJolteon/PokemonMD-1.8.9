package com.fuzzyacornindustries.pokemonmd.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.fuzzyacornindustries.pokemonmd.creativetab.PokemonMDCreativeTabs;

public class ItemBlessingOfArceus extends Item
{
	public static String itemName = "blessingofarceus";

	public ItemBlessingOfArceus()
	{
		this.maxStackSize = 1;
		this.setUnlocalizedName(itemName);
		this.setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDTamables);
	}

	static public String getItemName()
	{
		return itemName;
	}

	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List parList, boolean parBoolean) 
	{
		parList.add("A charished relic from the divine");
		parList.add("Pokemon, Arceus, showing one who");
		parList.add("has proven themselves in battle.");
	}
}
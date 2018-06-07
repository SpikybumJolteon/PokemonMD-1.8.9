package com.fuzzyacornindustries.pokemonmd.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.fuzzyacornindustries.pokemonmd.creativetab.PokemonMDCreativeTabs;

public class ItemRichTiberiumShard extends Item
{
	public static String itemName = "richtiberiumshard";

	public ItemRichTiberiumShard()
	{
		this.maxStackSize = 64;
		this.setUnlocalizedName(itemName);
		this.setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDItems);
	}

	static public String getItemName()
	{
		return itemName;
	}
	
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List parList, boolean parBoolean) 
	{
		parList.add("A more potent form of tiberium,");
		parList.add("it allows for greater technology.");
		parList.add("It's more toxic to terran creatures.");
	}
}
package com.fuzzyacornindustries.pokemonmd.item;

import java.util.List;

import com.fuzzyacornindustries.pokemonmd.creativetab.PokemonMDCreativeTabs;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemDreamFeather extends Item
{
	public static String itemName = "dreamfeather";

	public ItemDreamFeather()
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
		parList.add("A feather imbuled with a");
		parList.add("mystic essence.");
	}
}
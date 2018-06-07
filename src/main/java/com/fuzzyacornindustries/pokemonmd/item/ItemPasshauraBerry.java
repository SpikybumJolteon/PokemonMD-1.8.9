package com.fuzzyacornindustries.pokemonmd.item;

import java.util.List;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.fuzzyacornindustries.pokemonmd.block.PokemonMDBlocks;
import com.fuzzyacornindustries.pokemonmd.creativetab.PokemonMDCreativeTabs;

public class ItemPasshauraBerry extends BerryItem
{
	String itemName = "passhauraberry";

	private boolean alwaysEdible;

	public ItemPasshauraBerry(int healAmount, float saturation)
	{
		super(healAmount, saturation, PokemonMDBlocks.passhauraBerryPlant, Blocks.farmland, 2F);
		this.setUnlocalizedName(itemName);
		this.setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDItems);
	}

	public String getItemName()
	{
		return itemName;
	}

	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack itemStack, EntityPlayer player, List parList, boolean parBoolean) 
	{
		parList.add("A berry food item that grants");
		parList.add("a quick potion of water breathing.");
	}

	@Override
    public ItemStack onItemUseFinish(ItemStack heldItemStack, World world, EntityPlayer player)
    {
		--heldItemStack.stackSize;
		player.getFoodStats().addStats(this, heldItemStack);
		this.onFoodEaten(heldItemStack, world, player);
		return heldItemStack;
	}

	@Override
	protected void onFoodEaten(ItemStack heldItemStack, World world, EntityPlayer player)
	{
		int numberOfSeconds = 30;

		player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, numberOfSeconds * 20, 0));
	}

	/**
	 * How long it takes to use or consume an item
	 */
	@Override
	public int getMaxItemUseDuration(ItemStack par1ItemStack)
	{
		return 16;
	}

	/**
	 * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
	 */
	@Override
	public ItemStack onItemRightClick(ItemStack heldItemStack, World world, EntityPlayer player)
	{
		player.setItemInUse(heldItemStack, this.getMaxItemUseDuration(heldItemStack));	
		return heldItemStack;
	}

	@Override
	public ItemFood setAlwaysEdible()
	{
		this.alwaysEdible = true;
		return this;
	}
}
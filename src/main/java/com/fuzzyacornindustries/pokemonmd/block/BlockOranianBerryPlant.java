package com.fuzzyacornindustries.pokemonmd.block;

import java.util.Random;

import net.minecraft.item.Item;

import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItems;

public class BlockOranianBerryPlant extends CropBlock
{
	String blockName = "oranianberryplant";
	
	public static final float growthSpeed = 2.0F;

	public BlockOranianBerryPlant()
	{
		super(growthSpeed);

		this.setUnlocalizedName(getBlockName());
	}
	
	public String getBlockName()
	{
		return blockName;
	}

	// this is seed item for the crop
	@Override
	protected Item getSeed()
	{
		return PokemonMDItems.oranianBerry;
	}

	// this is item harvested from crop
	@Override
	protected Item getCrop()
	{
		return PokemonMDItems.oranianBerry;
	}

	/**
	 * Returns the quantity of items to drop on block destruction.
	 */
	@Override
	public int quantityDropped(Random randomVal)
	{
		return 1;
	}
}
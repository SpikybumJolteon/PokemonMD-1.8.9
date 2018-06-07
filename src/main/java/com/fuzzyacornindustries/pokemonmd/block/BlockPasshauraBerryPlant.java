package com.fuzzyacornindustries.pokemonmd.block;

import java.util.Random;

import net.minecraft.item.Item;

import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItems;

public class BlockPasshauraBerryPlant extends CropBlock
{
	String blockName = "passhauraberryplant";
	
	public static final float growthSpeed = 0.7F;

	BlockPasshauraBerryPlant()
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
		return PokemonMDItems.passhauraBerry;
	}

	// this is item harvested from crop
	@Override
	protected Item getCrop()
	{
		return PokemonMDItems.passhauraBerry;
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
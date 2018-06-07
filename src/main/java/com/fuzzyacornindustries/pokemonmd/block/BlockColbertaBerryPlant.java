package com.fuzzyacornindustries.pokemonmd.block;

import java.util.Random;

import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItems;
import com.fuzzyacornindustries.pokemonmd.reference.ModStrings;

public class BlockColbertaBerryPlant extends CropBlock
{
	String blockName = "colbertaberryplant";
	
	public static final float growthSpeed = 0.3F;

	public BlockColbertaBerryPlant()
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
		return PokemonMDItems.colbertaBerry;
	}

	// this is item harvested from crop
	@Override
	protected Item getCrop()
	{
		return PokemonMDItems.colbertaBerry;
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
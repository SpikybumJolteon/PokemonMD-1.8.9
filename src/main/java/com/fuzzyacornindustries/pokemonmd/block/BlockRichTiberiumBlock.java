package com.fuzzyacornindustries.pokemonmd.block;

import com.fuzzyacornindustries.pokemonmd.creativetab.PokemonMDCreativeTabs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockRichTiberiumBlock extends Block
{
    private final static String blockName = "richtiberiumblock";

    public BlockRichTiberiumBlock()
    {
        super(Material.rock);
		this.setUnlocalizedName(getBlockName());
        this.setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDBlocks);
		
		this.setHardness(2.0F); // Equivalent to cobblestone
		this.setResistance(10.0F);
		this.setLightLevel(0.5F); // Lightstone would be 1.0F
    }

	static public String getBlockName()
	{
		return blockName;
	}
}
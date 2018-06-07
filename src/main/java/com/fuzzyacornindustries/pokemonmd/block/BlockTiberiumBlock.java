package com.fuzzyacornindustries.pokemonmd.block;

import java.util.List;

import com.fuzzyacornindustries.pokemonmd.creativetab.PokemonMDCreativeTabs;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumWorldBlockLayer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockTiberiumBlock extends Block
{
    private final static String blockName = "tiberiumblock";

    public BlockTiberiumBlock()
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
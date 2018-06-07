package com.fuzzyacornindustries.pokemonmd.item;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import net.minecraftforge.common.IPlantable;

public class BerryItem extends SeedFood implements IPlantable
{
	private Block berryBlock;
	/**
	 * Block ID of the soil this seed food should be planted on.
	 */
	private Block soilId;
	
	float healValue;
	
	public BerryItem(int healAmount, float saturation, Block berryBlock, Block soilBlock, float pokemonHealAmount)
	{
		super(healAmount, saturation, berryBlock, soilBlock);
		this.berryBlock = berryBlock;
		this.soilId = soilBlock;
		
		healValue = pokemonHealAmount;
	}
	
	public float getPokemonHealAmount()
	{
		return healValue;
	}

	/**
	 * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
	 * True if something happen and false if it don't. This is for ITEMS, not BLOCKS
	 */
	@Override
    public boolean onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (side != EnumFacing.UP)
        {
            return false;
        }
        else if (!playerIn.canPlayerEdit(pos.offset(side), side, stack))
        {
            return false;
        }
        else if (worldIn.getBlockState(pos).getBlock().canSustainPlant(worldIn, pos, EnumFacing.UP, this) && worldIn.isAirBlock(pos.up()))
        {
            worldIn.setBlockState(pos.up(), this.berryBlock.getDefaultState());
            --stack.stackSize;
            return true;
        }
        else
        {
            return false;
        }
	}

    @Override
    public net.minecraftforge.common.EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos)
    {
		return net.minecraftforge.common.EnumPlantType.Crop;
	}

    @Override
    public net.minecraft.block.state.IBlockState getPlant(net.minecraft.world.IBlockAccess world, BlockPos pos)
    {
        return this.berryBlock.getDefaultState();
    }
}
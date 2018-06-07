package com.fuzzyacornindustries.pokemonmd.block;

import java.util.Random;

import com.fuzzyacornindustries.pokemonmd.creativetab.PokemonMDCreativeTabs;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockXelNagaTechBlock extends Block
{
	public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);

	private final static String blockName = "xelnagatechblock";

	public BlockXelNagaTechBlock()
	{
		super(Material.rock);
		this.setUnlocalizedName(getBlockName());
		this.setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDBlocks);

		this.setHardness(2.0F); // Equivalent to cobblestone
		this.setResistance(10.0F);
		this.setLightLevel(1.0F); // Lightstone would be 1.0F

		setDefaultState(blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
		blockParticleGravity = 1.0F;
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
		setTickRandomly(false);
	}

	static public String getBlockName()
	{
		return blockName;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random rand, int fortune)
	{
		return Item.getItemFromBlock(PokemonMDBlocks.xelNagaTechBlock);
	}

	@Override
	public void onBlockAdded(World parWorld, BlockPos parBlockPos, IBlockState parIBlockState)
	{
		if (!parWorld.isRemote)
		{
			// Rotate block if the front side is blocked
			Block blockToNorth = parWorld.getBlockState(
					parBlockPos.north()).getBlock();
			Block blockToSouth = parWorld.getBlockState(
					parBlockPos.south()).getBlock();
			Block blockToWest = parWorld.getBlockState(
					parBlockPos.west()).getBlock();
			Block blockToEast = parWorld.getBlockState(
					parBlockPos.east()).getBlock();
			EnumFacing enumfacing = (EnumFacing)parIBlockState
					.getValue(FACING);

			if (enumfacing == EnumFacing.NORTH 
					&& blockToNorth.isFullBlock() 
					&& !blockToSouth.isFullBlock())
			{
				enumfacing = EnumFacing.SOUTH;
			}
			else if (enumfacing == EnumFacing.SOUTH 
					&& blockToSouth.isFullBlock() 
					&& !blockToNorth.isFullBlock())
			{
				enumfacing = EnumFacing.NORTH;
			}
			else if (enumfacing == EnumFacing.WEST 
					&& blockToWest.isFullBlock() 
					&& !blockToEast.isFullBlock())
			{
				enumfacing = EnumFacing.EAST;
			}
			else if (enumfacing == EnumFacing.EAST 
					&& blockToEast.isFullBlock() 
					&& !blockToWest.isFullBlock())
			{
				enumfacing = EnumFacing.WEST;
			}

			parWorld.setBlockState(parBlockPos, parIBlockState
					.withProperty(FACING, enumfacing), 2);
		}
	}

	@Override
	public IBlockState onBlockPlaced(World worldIn, BlockPos pos, EnumFacing facing, 
			float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer)
	{
		return getDefaultState().withProperty(FACING, placer.getHorizontalFacing().getOpposite());
	}

	@Override
	public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, 
			EntityLivingBase placer, ItemStack stack)
	{
		worldIn.setBlockState(pos, state.withProperty(FACING, placer.getHorizontalFacing().getOpposite()), 2);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World worldIn, BlockPos pos)
	{
		return Item.getItemFromBlock(PokemonMDBlocks.xelNagaTechBlock);
	}

	@Override
	public int getRenderType()
	{
		return 3;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IBlockState getStateForEntityRender(IBlockState state)
	{
		return getDefaultState().withProperty(FACING, EnumFacing.SOUTH);
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		EnumFacing enumfacing = EnumFacing.getFront(meta);

		if (enumfacing.getAxis() == EnumFacing.Axis.Y)
		{
			enumfacing = EnumFacing.NORTH;
		}

		return getDefaultState().withProperty(FACING, enumfacing);
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((EnumFacing)state.getValue(FACING)).getIndex();
	}

	@Override
	protected BlockState createBlockState()
	{
		return new BlockState(this, new IProperty[] {FACING});
	}

	@SideOnly(Side.CLIENT)
	static final class SwitchEnumFacing
	{
		static final int[] enumFacingArray = new int[EnumFacing.values().length];

		static
		{
			try
			{
				enumFacingArray[EnumFacing.WEST.ordinal()] = 1;
			}
			catch (NoSuchFieldError var4)
			{
				;
			}

			try
			{
				enumFacingArray[EnumFacing.EAST.ordinal()] = 2;
			}
			catch (NoSuchFieldError var3)
			{
				;
			}

			try
			{
				enumFacingArray[EnumFacing.NORTH.ordinal()] = 3;
			}
			catch (NoSuchFieldError var2)
			{
				;
			}

			try
			{
				enumFacingArray[EnumFacing.SOUTH.ordinal()] = 4;
			}
			catch (NoSuchFieldError var1)
			{
				// You should improve the error handling here
			}
		}
	}
}
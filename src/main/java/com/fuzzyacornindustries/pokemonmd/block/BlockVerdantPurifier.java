package com.fuzzyacornindustries.pokemonmd.block;

import java.util.Iterator;
import java.util.Random;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import com.fuzzyacornindustries.pokemonmd.creativetab.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.main.PokemonMD;
import com.fuzzyacornindustries.pokemonmd.tileentity.IPylonPowered;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityVerdantPurifier;

public class BlockVerdantPurifier extends BlockContainer implements IPylonPowered
{
    private static boolean hasTileEntity;
	
	public static boolean isPowered;

	private static final String blockName = "verdantpurifier";

    public BlockVerdantPurifier()
    {
        super(Material.rock);
        setUnlocalizedName(blockName);
        setCreativeTab(PokemonMDCreativeTabs.tabPokemonMDBlocks);
        stepSound = soundTypeStone;
        blockParticleGravity = 1.0F;
        setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        lightOpacity = 20; // cast a light shadow
        setTickRandomly(false);
        useNeighborBrightness = false;
		this.setResistance(10.0F);
		this.setLightLevel(0.2F); // Lightstone would be 1.0F
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return Item.getItemFromBlock(PokemonMDBlocks.verdantPurifier);
    }

    @Override
    public boolean onBlockActivated(World parWorld, BlockPos parBlockPos, IBlockState parIBlockState, 
          EntityPlayer parPlayer, EnumFacing parSide, float hitX, float hitY, float hitZ)
    {
        if (!parWorld.isRemote)
        {
            parPlayer.openGui(PokemonMD.instance, PokemonMD.GUI_ENUM.VERDANT_PURIFIER.ordinal(), parWorld, 
            		parBlockPos.getX(), parBlockPos.getY(), parBlockPos.getZ()); 
        }
        
        return true;
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityVerdantPurifier();
    }

    @Override
    public void breakBlock(World worldIn, BlockPos pos, IBlockState state)
    {
        if (!hasTileEntity)
        {
            TileEntity tileentity = worldIn.getTileEntity(pos);

            if (tileentity instanceof TileEntityVerdantPurifier)
            {
                InventoryHelper.dropInventoryItems(worldIn, pos, (TileEntityVerdantPurifier)tileentity);
                worldIn.updateComparatorOutputLevel(pos, this);
            }
        }

        super.breakBlock(worldIn, pos, state);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public Item getItem(World worldIn, BlockPos pos)
    {
        return Item.getItemFromBlock(PokemonMDBlocks.verdantPurifier);
    }

    @Override
    public int getRenderType()
    {
        return -1;
    }

    @Override
	public boolean isOpaqueCube()
	{
		return false;
	}

	public static boolean isPylonNearby(World world, BlockPos pos)
    {
		Iterator iterator = BlockPos.getAllInBoxMutable(pos.add(-4, -4, -4), pos.add(4, 4, 4)).iterator();
        BlockPos.MutableBlockPos mutableblockpos;

        do
        {
            if (!iterator.hasNext())
            {
                return false;
            }

            mutableblockpos = (BlockPos.MutableBlockPos)iterator.next();
        }
        while (world.getBlockState(mutableblockpos).getBlock() != PokemonMDBlocks.xelNagaPylon);

        return true;
		/*
        for (int l = pos.getX() - 4; l <= pos.getX() + 4; ++l)
        {
            for (int i1 = pos.getY(); i1 <= pos.getY() + 8; ++i1)
            {
                for (int j1 = pos.getZ() - 4; j1 <= pos.getZ() + 4; ++j1)
                {
                    if (world.(l, i1 - 4, j1) == PokemonMDBlocks.xelNagaPylon)
                    {
                        return true;
                    }
                }
            }
        }

        return false;*/
    }

	@Override
	public void setPylonPoweredState(Boolean isPylonPowered)
	{
		isPowered = isPylonPowered;
	}

	@Override
	public Boolean getPylonPoweredState() 
	{
		return isPowered;
	}
}    
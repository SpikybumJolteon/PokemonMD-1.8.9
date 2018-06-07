package com.fuzzyacornindustries.pokemonmd.gui;

import com.fuzzyacornindustries.pokemonmd.container.ContainerVerdantPurifier;
import com.fuzzyacornindustries.pokemonmd.container.ContainerVespeneCondenser;
import com.fuzzyacornindustries.pokemonmd.main.PokemonMD;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityVerdantPurifier;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityVespeneCondenser;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiHandler implements IGuiHandler
{
	public static final int guiIDVerdantPurifier = 0;
	public static final int guiIDVespeneCondenser = 1;
	public static final int guiIDMicroFilter = 2;
	public static final int guiIDPrototurret = 3;
	public static final int guiIDTabletManufactory = 3;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));

		switch(ID)
		{
		case guiIDVerdantPurifier:
		{
			if(tileEntity instanceof TileEntityVerdantPurifier)
			{
				return new ContainerVerdantPurifier(player.inventory, (TileEntityVerdantPurifier)tileEntity);
			}
		}
		case guiIDVespeneCondenser:
		{
			if(tileEntity instanceof TileEntityVespeneCondenser)
			{
				return new ContainerVespeneCondenser(player.inventory, (TileEntityVespeneCondenser)tileEntity);
			}
		}
		}
		/*
			case guiIDMicroFilter:
			{
				if(tileEntity instanceof TileEntityMicroFilter)
				{
					return new ContainerMicroFilter(player.inventory, (TileEntityMicroFilter)tileEntity);
				}
			}
			case guiIDTabletManufactory:
			{
				if(tileEntity instanceof TileEntityTabletManufactory)
				{
					return new ContainerTabletManufactory(player.inventory, (TileEntityTabletManufactory)tileEntity);
				}
			}*/

		// int x is used to pass on the EntityID if it is not a TileEntity.
		//int entityID = x;
		/*
		if(ID == guiIDPrototurret)
		{
				return new ContainerPrototurret(player.inventory, (EntityPrototurret)world.getEntityByID(entityID));
		}
		 */
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
	{
		TileEntity tileEntity = world.getTileEntity(new BlockPos(x, y, z));

		if(tileEntity != null)
		{
			switch(ID)
			{
			case guiIDVerdantPurifier:
			{
				if(tileEntity instanceof TileEntityVerdantPurifier)
				{
					return new GuiVerdantPurifier(player.inventory, (TileEntityVerdantPurifier)tileEntity);
				}
			}
			case guiIDVespeneCondenser:
			{
				if(tileEntity instanceof TileEntityVespeneCondenser)
				{
					return new GuiVespeneCondenser(player.inventory, (TileEntityVespeneCondenser)tileEntity);
				}
			}
			/*
			case guiIDMicroFilter:
			{
				if(tileEntity instanceof TileEntityMicroFilter)
				{
					return new GuiMicroFilter(player.inventory, (TileEntityMicroFilter)tileEntity);
				}
			}
			case guiIDTabletManufactory:
			{
				if(tileEntity instanceof TileEntityTabletManufactory)
				{
					return new GuiTabletManufactory(player.inventory, (TileEntityTabletManufactory)tileEntity);
				}
			}*/
			/*
		// int x is used to pass on the EntityID if it is not a TileEntity.
		int entityID = x;

		if(ID == guiIDPrototurret)
		{
			return new GuiPrototurret(player.inventory, (EntityPrototurret)world.getEntityByID(entityID));
		}
			 */
			}
		}

		return null;
	}
}
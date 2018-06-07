package com.fuzzyacornindustries.pokemonmd.proxy;

import com.fuzzyacornindustries.pokemonmd.gui.GuiHandler;
import com.fuzzyacornindustries.pokemonmd.main.PokemonMD;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityVerdantPurifier;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityVespeneCondenser;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityXelNagaDynamo;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityXelNagaPylon;

import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CommonProxy 
{
	public void preInitRenders()
	{

	}

	public void initRenderRegisters()
	{
		GameRegistry.registerTileEntity(TileEntityVerdantPurifier.class, "TileEntityVerdantPurifier");
		GameRegistry.registerTileEntity(TileEntityVespeneCondenser.class, "TileEntityVespeneCondenser");
		GameRegistry.registerTileEntity(TileEntityXelNagaDynamo.class, "TileEntityXelNagaDynamo");
		GameRegistry.registerTileEntity(TileEntityXelNagaPylon.class, "TileEntityXelNagaPylon");

		NetworkRegistry.INSTANCE.registerGuiHandler(PokemonMD.instance, new GuiHandler()); 
		/*
		GameRegistry.registerTileEntity(TileEntityMicroFilter.class, "TileEntityMicroFilter");
		GameRegistry.registerTileEntity(TileEntityTabletManufactory.class, "TileEntityTabletManufactory");
		GameRegistry.registerTileEntity(TileEntityPrototurret.class, "TileEntityPrototurret");
		GameRegistry.registerTileEntity(TileEntityVespeneCondenser.class, "TileEntityVespeneCondenser");
		 */
	}
	
	public void initTimer() {}

	public float getPartialTick() 
	{
		return 1F;
	}

	public World getWorldClient() 
	{
		return null;
	}
}
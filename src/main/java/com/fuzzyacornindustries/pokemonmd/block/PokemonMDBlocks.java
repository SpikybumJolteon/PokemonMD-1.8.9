package com.fuzzyacornindustries.pokemonmd.block;

import com.fuzzyacornindustries.pokemonmd.reference.ModStrings;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class PokemonMDBlocks 
{
	public static Block colbertaBerryPlant;
	public static Block neoTiberiumBlock;
	public static Block neoTiberiumBricks;
	public static Block oranianBerryPlant;
	public static Block passhauraBerryPlant;
	public static Block pechitaBerryPlant;
	public static Block rawstettaBerryPlant;
	public static Block richTiberiumBlock;
	public static Block richTiberiumBricks;
	public static Block tiberiumBlock;
	public static Block tiberiumBricks;
	public static Block verdantPurifier;
	public static Block vespeneCondenser;
	public static Block voidGlass;
	public static Block xelNagaDynamo;
	public static Block xelNagaPylon;
	public static Block xelNagaTechBlock;

	public static void init()
	{
		colbertaBerryPlant = new BlockColbertaBerryPlant();
		neoTiberiumBlock = new BlockNeoTiberiumBlock();
		neoTiberiumBricks = new BlockNeoTiberiumBricks();
		oranianBerryPlant = new BlockOranianBerryPlant();
		passhauraBerryPlant = new BlockPasshauraBerryPlant();
		pechitaBerryPlant = new BlockPechitaBerryPlant();
		rawstettaBerryPlant = new BlockRawstettaBerryPlant();
		richTiberiumBlock = new BlockRichTiberiumBlock();
		richTiberiumBricks = new BlockRichTiberiumBricks();
		tiberiumBlock = new BlockTiberiumBlock();
		tiberiumBricks = new BlockTiberiumBricks();
		verdantPurifier = new BlockVerdantPurifier();
		vespeneCondenser = new BlockVespeneCondenser();
		voidGlass = new BlockVoidGlass();
		xelNagaDynamo = new BlockXelNagaDynamo();
		xelNagaPylon = new BlockXelNagaPylon();
		xelNagaTechBlock = new BlockXelNagaTechBlock();
	}

	public static void register()
	{
		GameRegistry.registerBlock(colbertaBerryPlant, colbertaBerryPlant.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(neoTiberiumBlock, neoTiberiumBlock.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(neoTiberiumBricks, ItemBlockNeoTiberiumBricks.class, neoTiberiumBricks.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(oranianBerryPlant, oranianBerryPlant.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(passhauraBerryPlant, passhauraBerryPlant.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(pechitaBerryPlant, pechitaBerryPlant.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(rawstettaBerryPlant, rawstettaBerryPlant.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(richTiberiumBlock, richTiberiumBlock.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(richTiberiumBricks, richTiberiumBricks.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(tiberiumBlock, tiberiumBlock.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(tiberiumBricks, tiberiumBricks.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(verdantPurifier, verdantPurifier.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(vespeneCondenser, vespeneCondenser.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(voidGlass, voidGlass.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(xelNagaDynamo, xelNagaDynamo.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(xelNagaPylon, xelNagaPylon.getUnlocalizedName().substring(5));
		GameRegistry.registerBlock(xelNagaTechBlock, xelNagaTechBlock.getUnlocalizedName().substring(5));
	}
	
	public static void registerRenders()
	{
		registerRender(colbertaBerryPlant);
		registerRender(neoTiberiumBlock);
		registerRender(neoTiberiumBricks);
		registerRender(oranianBerryPlant);
		registerRender(passhauraBerryPlant);
		registerRender(pechitaBerryPlant);
		registerRender(rawstettaBerryPlant);
		registerRender(richTiberiumBlock);
		registerRender(richTiberiumBricks);
		registerRender(tiberiumBlock);
		registerRender(tiberiumBricks);
		registerRender(verdantPurifier);
		registerRender(vespeneCondenser);
		registerRender(voidGlass);
		registerRender(xelNagaDynamo);
		registerRender(xelNagaPylon);
		registerRender(xelNagaTechBlock);
	}
	
	public static void registerRender(Block block)
	{
		Item item = Item.getItemFromBlock(block);
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(ModStrings.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
}
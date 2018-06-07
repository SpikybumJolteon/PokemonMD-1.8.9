package com.fuzzyacornindustries.pokemonmd.main;

import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.block.PokemonMDBlocks;
import com.fuzzyacornindustries.pokemonmd.creativetab.PokemonMDCreativeTabs;
import com.fuzzyacornindustries.pokemonmd.entity.mob.PokemonMDEntities;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItems;
import com.fuzzyacornindustries.pokemonmd.packet.PacketAnimation;
import com.fuzzyacornindustries.pokemonmd.proxy.CommonProxy;
import com.fuzzyacornindustries.pokemonmd.recipes.RecipesCrafting;
import com.fuzzyacornindustries.pokemonmd.reference.ModStrings;

@Mod(modid = ModStrings.MODID, name = ModStrings.name, version = ModStrings.version)
public class PokemonMD 
{
	@SidedProxy(clientSide = ModStrings.CLIENT_PROXY_CLASS, serverSide = ModStrings.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	public static SimpleNetworkWrapper network;
	
	@Instance(value = ModStrings.MODID)
	public static PokemonMD instance;

	public static final int packetIDActionAnimation = 0;
	
	public static final String[] fTimer;
	
	static 
	{
		fTimer = new String[] {"timer"};
	}
	
	public enum GUI_ENUM 
	{
	    VERDANT_PURIFIER,
	    VESPENE_CONDENSER
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		PokemonMDCreativeTabs.initializeTabs();
		
		PokemonMDBlocks.init();
		PokemonMDBlocks.register();
		
		PokemonMDItems.init();
		PokemonMDItems.register();
		
		proxy.preInitRenders();

		RecipesCrafting.mainRegistry();

		PokemonMDEntities.registerEntityMob();
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.initRenderRegisters();

		network = NetworkRegistry.INSTANCE.newSimpleChannel("PokemonMD");
		network.registerMessage(PacketAnimation.Handler.class, PacketAnimation.class, packetIDActionAnimation, Side.CLIENT);
	}

	@EventHandler
	public void postInt(FMLPostInitializationEvent event)
	{
		proxy.initTimer();
		
		PokemonMDEntities.addSpawnLocations();
	}
	
	public static boolean isClient() 
	{
		return FMLCommonHandler.instance().getSide().isClient();
	}
	
	public static boolean isEffectiveClient() 
	{
		return FMLCommonHandler.instance().getEffectiveSide().isClient();
	}
	
	public static void sendAnimationPacket(IAnimatedEntity entity, int animationID) 
	{
		if(isEffectiveClient()) 
			return;

		entity.setAnimationID(animationID);
		network.sendToAll(new PacketAnimation((byte)animationID, ((Entity)entity).getEntityId()));
	}
}
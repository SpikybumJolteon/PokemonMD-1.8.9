package com.fuzzyacornindustries.pokemonmd.entity.mob;

import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntitySwordieMienshao;
import com.fuzzyacornindustries.pokemonmd.main.PokemonMD;
import com.fuzzyacornindustries.pokemonmd.reference.LibraryEntityID;

import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class PokemonMDEntities
{
	public static void registerEntityMob()
	{
		createEntity(EntitySwordieMienshao.class, EntitySwordieMienshao.getMobName(), LibraryEntityID.SWORDIE_MIENSHAO, 0x2b2e3f, 0x096859);
	}
	
	public static void addSpawnLocations()
	{
		EntityRegistry.addSpawn(EntitySwordieMienshao.class, 100, 1, 1, EnumCreatureType.MONSTER, 
				BiomeGenBase.coldTaiga, 
				BiomeGenBase.coldTaigaHills, 
				BiomeGenBase.extremeHills, 
				BiomeGenBase.extremeHillsEdge, 
				BiomeGenBase.extremeHillsPlus, 
				BiomeGenBase.frozenOcean, 
				BiomeGenBase.frozenRiver, 
				BiomeGenBase.iceMountains, 
				BiomeGenBase.icePlains, 
				BiomeGenBase.megaTaiga, 
				BiomeGenBase.megaTaigaHills, 
				BiomeGenBase.stoneBeach, 
				BiomeGenBase.taiga, 
				BiomeGenBase.taigaHills 
				);
	}

	public static void createEntity(Class entityClass, String entityName, int entityID, int parPrimaryColor, int parSecondaryColor)
	{
		int trackingRange = 64;
		int updateFrequency = 1;
		boolean sendsVelocityUpdates = true;

		EntityRegistry.registerModEntity(entityClass, entityName, entityID, PokemonMD.instance, trackingRange, updateFrequency, sendsVelocityUpdates);
		EntityRegistry.registerEgg(entityClass, parPrimaryColor, parSecondaryColor);
	}
}
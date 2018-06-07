package com.fuzzyacornindustries.pokemonmd.item;

import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.common.util.EnumHelper;

import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntitySwordieMienshao;
import com.fuzzyacornindustries.pokemonmd.recipes.FuelsFurnace;
import com.fuzzyacornindustries.pokemonmd.reference.ModStrings;

public class PokemonMDItems 
{
	public static ToolMaterial SILKSCREEN_TOOL = EnumHelper.addToolMaterial("SILKSCREEN_TOOL", 2, 350, 4.0F, 2.0F, 18);
	public static ArmorMaterial SILKSCREEN_ARMOR = EnumHelper.addArmorMaterial("SILKSCREEN_ARMOR", ModStrings.MODID + ":silkscreenarmor", 15, new int[]{2, 6, 5, 2}, 18);

	public static Item abyssalLiquidCrystal;
	public static Item aurumDust;
	public static Item aurumRod;
	public static Item blessingOfArceus;
	public static Item colbertaBerry;
	public static Item dreamFeather;
	public static Item goldenChaff;
	public static Item infernoFuelRod;
	public static Item neoTiberiumShard;
	public static Item oranianBerry;
	public static Item passhauraBerry;
	public static Item pechitaBerry;
	public static Item rawstettaBerry;
	public static Item reviveSeed;
	public static Item richTiberiumShard;
	public static Item silkscreenAlloy;
	public static Item silkscreenAxe;
	public static Item silkscreenBoots;
	public static Item silkscreenChestplate;
	public static Item silkscreenHelmet;
	public static Item silkscreenHoe;
	public static Item silkscreenMesh;
	public static Item silkscreenLeggings;
	public static Item silkscreenPickaxe;
	public static Item silkscreenShovel;
	public static Item silkscreenSword;
	public static Item spiderkissSword;
	public static Item tiberiumShard;
	public static Item voidScissors;
	public static Item willOfTheAncients;
	public static Item xelNagaCircuit;
	public static Item xelNagaShard;

	//public static Item spawnSwordieMienshao;
	
	public static void init()
	{
		abyssalLiquidCrystal = new ItemAbyssalLiquidCrystal();
		aurumDust = new ItemAurumDust();
		aurumRod = new ItemAurumRod();
		blessingOfArceus = new ItemBlessingOfArceus();
		colbertaBerry = new ItemColbertaBerry(1, 0.1F);
		dreamFeather = new ItemDreamFeather();
		goldenChaff = new ItemGoldenChaff();
		infernoFuelRod = new ItemInfernoFuelRod();
		neoTiberiumShard = new ItemNeoTiberiumShard();
		oranianBerry = new ItemOranianBerry(1, 0.1F);
		passhauraBerry = new ItemPasshauraBerry(1, 0.1F);
		pechitaBerry = new ItemPechitaBerry(1, 0.1F);
		rawstettaBerry = new ItemRawstettaBerry(1, 0.1F);
		reviveSeed = new ItemReviveSeed();
		richTiberiumShard = new ItemRichTiberiumShard();
		silkscreenAlloy = new ItemSilkscreenAlloy();
		silkscreenAxe = new ItemSilkscreenAxe();
		silkscreenBoots = new ItemSilkscreenArmor(SILKSCREEN_ARMOR, 1, 3);
		silkscreenChestplate = new ItemSilkscreenArmor(SILKSCREEN_ARMOR, 1, 1);
		silkscreenHelmet = new ItemSilkscreenArmor(SILKSCREEN_ARMOR, 1, 0);
		silkscreenHoe = new ItemSilkscreenHoe();
		silkscreenMesh = new ItemSilkscreenMesh();
		silkscreenLeggings = new ItemSilkscreenArmor(SILKSCREEN_ARMOR, 2, 2);
		silkscreenPickaxe = new ItemSilkscreenPickaxe();
		silkscreenShovel = new ItemSilkscreenShovel();
		silkscreenSword = new ItemSilkscreenSword();
		spiderkissSword = new ItemSpiderkissSword();
		tiberiumShard = new ItemTiberiumShard();
		voidScissors = new ItemVoidScissors();
		willOfTheAncients = new ItemWillOfTheAncients();
		xelNagaCircuit = new ItemXelNagaCircuit();
		xelNagaShard = new ItemXelNagaShard();

		//spawnSwordieMienshao = new ItemPokemonPlacer(EntitySwordieMienshao.getMobName(), "Swordie Mienshao", 0x2b2e3f, 0x096859);
	}
	
	public static void register()
	{
		// getUnlocalizedName() normally returns the name: "tile.xelnagashard"; 
		// .substring(5) skips the first five characters in the string.

		GameRegistry.registerItem(abyssalLiquidCrystal, abyssalLiquidCrystal.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(aurumDust, aurumDust.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(aurumRod, aurumRod.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(blessingOfArceus, blessingOfArceus.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(colbertaBerry, colbertaBerry.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(dreamFeather, dreamFeather.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(goldenChaff, goldenChaff.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(infernoFuelRod, infernoFuelRod.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(neoTiberiumShard, neoTiberiumShard.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(oranianBerry, oranianBerry.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(passhauraBerry, passhauraBerry.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(pechitaBerry, pechitaBerry.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(rawstettaBerry, rawstettaBerry.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(reviveSeed, reviveSeed.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(richTiberiumShard, richTiberiumShard.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(silkscreenAlloy, silkscreenAlloy.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(silkscreenAxe, silkscreenAxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(silkscreenBoots, silkscreenBoots.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(silkscreenChestplate, silkscreenChestplate.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(silkscreenHelmet, silkscreenHelmet.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(silkscreenHoe, silkscreenHoe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(silkscreenMesh, silkscreenMesh.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(silkscreenLeggings, silkscreenLeggings.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(silkscreenPickaxe, silkscreenPickaxe.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(silkscreenShovel, silkscreenShovel.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(silkscreenSword, silkscreenSword.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(spiderkissSword, spiderkissSword.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(tiberiumShard, tiberiumShard.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(voidScissors, voidScissors.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(willOfTheAncients, willOfTheAncients.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(xelNagaCircuit, xelNagaCircuit.getUnlocalizedName().substring(5));
		GameRegistry.registerItem(xelNagaShard, xelNagaShard.getUnlocalizedName().substring(5));

		//GameRegistry.registerItem(spawnSwordieMienshao, spawnSwordieMienshao.getUnlocalizedName().substring(5));
		
		GameRegistry.registerFuelHandler(new FuelsFurnace());
	}
	
	public static void registerRenders()
	{
		registerRender(abyssalLiquidCrystal);
		registerRender(aurumDust);
		registerRender(aurumRod);
		registerRender(blessingOfArceus);
		registerRender(colbertaBerry);
		registerRender(dreamFeather);
		registerRender(goldenChaff);
		registerRender(infernoFuelRod);
		registerRender(neoTiberiumShard);
		registerRender(oranianBerry);
		registerRender(passhauraBerry);
		registerRender(pechitaBerry);
		registerRender(rawstettaBerry);
		registerRender(reviveSeed);
		registerRender(richTiberiumShard);
		registerRender(silkscreenAlloy);
		registerRender(silkscreenAxe);
		registerRender(silkscreenBoots);
		registerRender(silkscreenChestplate);
		registerRender(silkscreenHelmet);
		registerRender(silkscreenHoe);
		registerRender(silkscreenLeggings);
		registerRender(silkscreenMesh);
		registerRender(silkscreenPickaxe);
		registerRender(silkscreenShovel);
		registerRender(silkscreenSword);
		registerRender(spiderkissSword);
		registerRender(tiberiumShard);
		registerRender(voidScissors);
		registerRender(willOfTheAncients);
		registerRender(xelNagaCircuit);
		registerRender(xelNagaShard);

		//registerRender(spawnSwordieMienshao);
	}
	
	public static void registerRender(Item item)
	{
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(ModStrings.MODID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	}
/*
	public static void addMobSpawnItem(Item spawnItem, String mobName, String mobNameFull, int primaryColor, int secondaryColor)
	{
		spawnItem = createPokemonSpawnItem(mobName, mobNameFull, primaryColor, secondaryColor);
        
		registerPokemonSpawnItem(spawnItem, mobName);

	//System.out.println( "Spawn Item Name" );
	//System.out.println( spawnItem.getUnlocalizedName().substring(5) );
		 
		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(spawnItem, 0, new ModelResourceLocation(ModStrings.MODID + ":" + "pokemonplacer", "inventory"));
	}
	
	public static ItemPokemonPlacer createPokemonSpawnItem(String mobName, String mobNameFull, int primaryColor, int secondaryColor)
	{
		return (ItemPokemonPlacer) new ItemPokemonPlacer(mobName, mobNameFull, primaryColor, secondaryColor);
	}
	
	public static void registerPokemonSpawnItem(Item spawnItem, String mobName)
	{
		GameRegistry.registerItem(spawnItem, "spawnegg" + mobName);
	}*/
}
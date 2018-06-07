package com.fuzzyacornindustries.pokemonmd.recipes;

import com.fuzzyacornindustries.pokemonmd.block.PokemonMDBlocks;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.OreDictionary;

public class RecipesCrafting
{
	public static void mainRegistry()
	{
		addCraftingRecipes();
		addSmeltingRecipes();
	}

	public static void addCraftingRecipes()
	{
		/* *********** Void Scissors *********** */
		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.voidScissors, 1), new Object[]{"O O", "X X", " Q ", 'Q', Blocks.quartz_block, 'X', PokemonMDItems.xelNagaCircuit, 'O', Blocks.obsidian});

		GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, 2), new Object[]{new ItemStack(PokemonMDItems.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.diamond_helmet});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, 4), new Object[]{new ItemStack(PokemonMDItems.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.diamond_chestplate});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, 3), new Object[]{new ItemStack(PokemonMDItems.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.diamond_leggings});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, 1), new Object[]{new ItemStack(PokemonMDItems.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.diamond_boots});

		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 3), new Object[]{new ItemStack(PokemonMDItems.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.iron_helmet});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 5), new Object[]{new ItemStack(PokemonMDItems.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.iron_chestplate});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 4), new Object[]{new ItemStack(PokemonMDItems.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.iron_leggings});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 2), new Object[]{new ItemStack(PokemonMDItems.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.iron_boots});

		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 3), new Object[]{new ItemStack(PokemonMDItems.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.chainmail_helmet});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 5), new Object[]{new ItemStack(PokemonMDItems.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.chainmail_chestplate});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 4), new Object[]{new ItemStack(PokemonMDItems.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.chainmail_leggings});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 2), new Object[]{new ItemStack(PokemonMDItems.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.chainmail_boots});

		GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot, 3), new Object[]{new ItemStack(PokemonMDItems.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.golden_helmet});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot, 5), new Object[]{new ItemStack(PokemonMDItems.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.golden_chestplate});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot, 4), new Object[]{new ItemStack(PokemonMDItems.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.golden_leggings});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot, 2), new Object[]{new ItemStack(PokemonMDItems.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.golden_boots});

		GameRegistry.addShapelessRecipe(new ItemStack(Items.leather, 4), new Object[]{new ItemStack(PokemonMDItems.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.leather_helmet});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.leather, 6), new Object[]{new ItemStack(PokemonMDItems.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.leather_chestplate});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.leather, 5), new Object[]{new ItemStack(PokemonMDItems.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.leather_leggings});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.leather, 3), new Object[]{new ItemStack(PokemonMDItems.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.leather_boots});

		GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItems.silkscreenAlloy, 3), new Object[]{new ItemStack(PokemonMDItems.voidScissors, 1, OreDictionary.WILDCARD_VALUE), PokemonMDItems.silkscreenHelmet});
		GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItems.silkscreenAlloy, 5), new Object[]{new ItemStack(PokemonMDItems.voidScissors, 1, OreDictionary.WILDCARD_VALUE), PokemonMDItems.silkscreenChestplate});
		GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItems.silkscreenAlloy, 4), new Object[]{new ItemStack(PokemonMDItems.voidScissors, 1, OreDictionary.WILDCARD_VALUE), PokemonMDItems.silkscreenLeggings});
		GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItems.silkscreenAlloy, 2), new Object[]{new ItemStack(PokemonMDItems.voidScissors, 1, OreDictionary.WILDCARD_VALUE), PokemonMDItems.silkscreenBoots});

		GameRegistry.addShapelessRecipe(new ItemStack(Blocks.planks, 7), new Object[]{new ItemStack(PokemonMDItems.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Blocks.chest});

		GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, 7), new Object[]{new ItemStack(PokemonMDItems.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.diamond_horse_armor});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot, 7), new Object[]{new ItemStack(PokemonMDItems.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.golden_horse_armor});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 7), new Object[]{new ItemStack(PokemonMDItems.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.iron_horse_armor});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.leather, 7), new Object[]{new ItemStack(PokemonMDItems.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.saddle});

		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 2), new Object[]{new ItemStack(PokemonMDItems.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.bucket});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.iron_ingot, 3), new Object[]{new ItemStack(PokemonMDItems.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.compass});
		GameRegistry.addShapelessRecipe(new ItemStack(Items.gold_ingot, 3), new Object[]{new ItemStack(PokemonMDItems.voidScissors, 1, OreDictionary.WILDCARD_VALUE), Items.clock});


		/* *********** Mystic Tech *********** */
		GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItems.xelNagaShard, 8), new Object[]{PokemonMDBlocks.xelNagaTechBlock});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.xelNagaCircuit, 1), new Object[]{"QVQ", "#X#", "QVQ", '#', Items.glowstone_dust, 'V', PokemonMDBlocks.voidGlass, 'Q', Items.quartz, 'X', PokemonMDItems.xelNagaShard});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.xelNagaCircuit, 1), new Object[]{"Q#Q", "VXV", "Q#Q", '#', Items.glowstone_dust, 'V', PokemonMDBlocks.voidGlass, 'Q', Items.quartz, 'X', PokemonMDItems.xelNagaShard});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.xelNagaCircuit, 1), new Object[]{"QVQ", "#X#", "QVQ", '#', Items.glowstone_dust, 'V', PokemonMDBlocks.voidGlass, 'Q', PokemonMDItems.tiberiumShard, 'X', PokemonMDItems.xelNagaShard});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.xelNagaCircuit, 1), new Object[]{"Q#Q", "VXV", "Q#Q", '#', Items.glowstone_dust, 'V', PokemonMDBlocks.voidGlass, 'Q', PokemonMDItems.tiberiumShard, 'X', PokemonMDItems.xelNagaShard});

		GameRegistry.addRecipe(new ItemStack(PokemonMDBlocks.xelNagaTechBlock, 1), new Object[]{"###", "# #", "###", '#', PokemonMDItems.xelNagaShard});
		GameRegistry.addRecipe(new ItemStack(PokemonMDBlocks.voidGlass, 4), new Object[]{" # ", "#X#", " # ", '#', Blocks.glass, 'X', PokemonMDItems.xelNagaShard});
		GameRegistry.addRecipe(new ItemStack(PokemonMDBlocks.xelNagaDynamo, 1), new Object[]{"QOQ", "CTC", "QOQ", 'Q', Blocks.quartz_block, 'O', Blocks.obsidian, 'C', PokemonMDItems.xelNagaCircuit, 'T', PokemonMDBlocks.xelNagaTechBlock});
		//GameRegistry.addRecipe(new ItemStack(PokemonMDBlocks.xelNagaDynamo, 1), new Object[]{"TOT", "CXC", "TOT", 'T', PokemonMDBlocks.tiberiumBlock, 'O', Blocks.obsidian, 'C', PokemonMDItems.xelNagaCircuit, 'X', PokemonMDBlocks.xelNagaTechBlock});
		GameRegistry.addRecipe(new ItemStack(PokemonMDBlocks.xelNagaPylon, 1), new Object[]{"VVV", "ODO", "QCQ", 'Q', Blocks.quartz_block, 'O', Blocks.obsidian, 'C', PokemonMDItems.xelNagaCircuit, 'V', PokemonMDBlocks.voidGlass, 'D', PokemonMDBlocks.xelNagaDynamo});
		//GameRegistry.addRecipe(new ItemStack(PokemonMDBlocks.xelNagaPylon, 1), new Object[]{"VVV", "ODO", "TCT", 'T', PokemonMDBlocks.tiberiumBlock, 'O', Blocks.obsidian, 'C', PokemonMDItems.xelNagaCircuit, 'V', PokemonMDBlocks.voidGlass, 'D', PokemonMDBlocks.xelNagaDynamo});
		GameRegistry.addRecipe(new ItemStack(PokemonMDBlocks.verdantPurifier, 1), new Object[]{"VCV", "QTQ", "OOO", 'V', PokemonMDBlocks.voidGlass, 'C', PokemonMDItems.xelNagaCircuit, 'Q', Blocks.quartz_block, 'T', PokemonMDBlocks.xelNagaTechBlock, 'O', Blocks.obsidian});
		//GameRegistry.addRecipe(new ItemStack(PokemonMDBlocks.verdantPurifier, 1), new Object[]{"VCV", "TXT", "OOO", 'V', PokemonMDBlocks.voidGlass, 'C', PokemonMDItems.xelNagaCircuit, 'T', PokemonMDBlocks.tiberiumBlock, 'X', PokemonMDBlocks.xelNagaTechBlock, 'O', Blocks.obsidian});
		//GameRegistry.addRecipe(new ItemStack(PokemonMDBlocks.vespeneCondenser, 1), new Object[]{"CQC", "QEQ", "ODO", 'C', PokemonMDItems.xelNagaCircuit, 'Q', Blocks.quartz_block, 'E', Blocks.emerald_block, 'O', Blocks.obsidian, 'D', PokemonMDBlocks.xelNagaDynamo});
		//GameRegistry.addRecipe(new ItemStack(PokemonMDBlocks.vespeneCondenser, 1), new Object[]{"CTC", "TET", "ODO", 'C', PokemonMDItems.xelNagaCircuit, 'T', PokemonMDBlocks.tiberiumBlock, 'E', Blocks.emerald_block, 'O', Blocks.obsidian, 'D', PokemonMDBlocks.xelNagaDynamo});

		
		/* *********** Silkscreen Alloy *********** */
		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.silkscreenMesh, 1), new Object[]{"###", "#A#", "###", '#', Items.string, 'A', PokemonMDItems.aurumDust});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.silkscreenAxe, 1), new Object[]{"## ", "#S ", " S ", '#', PokemonMDItems.silkscreenAlloy, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.silkscreenHoe, 1), new Object[]{"## ", " S ", " S ", '#', PokemonMDItems.silkscreenAlloy, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.silkscreenPickaxe, 1), new Object[]{"###", " S ", " S ", '#', PokemonMDItems.silkscreenAlloy, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.silkscreenShovel, 1), new Object[]{" # ", " S ", " S ", '#', PokemonMDItems.silkscreenAlloy, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.silkscreenSword, 1), new Object[]{" # ", " # ", " S ", '#', PokemonMDItems.silkscreenAlloy, 'S', Items.stick});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.spiderkissSword, 1), new Object[]{" S", "S#", '#', PokemonMDItems.silkscreenSword, 'S', Items.spider_eye});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.spiderkissSword, 1), new Object[]{"E# ", "E# ", " S ", '#', PokemonMDItems.silkscreenAlloy, 'S', Items.stick, 'E', Items.spider_eye});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.silkscreenBoots, 1), new Object[]{"# #", "# #", '#', PokemonMDItems.silkscreenAlloy});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.silkscreenChestplate, 1), new Object[]{"# #", "###", "###", '#', PokemonMDItems.silkscreenAlloy});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.silkscreenHelmet, 1), new Object[]{"###", "# #", '#', PokemonMDItems.silkscreenAlloy});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.silkscreenLeggings, 1), new Object[]{"###", "# #", "# #", '#', PokemonMDItems.silkscreenAlloy});

		
		/* *********** Tiberium *********** */
		//GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItems.tiberiumShard, 9), new Object[]{PokemonMDBlocks.tiberiumBlock});
		//GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItems.richTiberiumShard, 9), new Object[]{PokemonMDBlocks.richTiberiumBlock});
		//GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItems.neoTiberiumShard, 9), new Object[]{PokemonMDBlocks.neoTiberiumBlock});

		//GameRegistry.addRecipe(new ItemStack(PokemonMDBlocks.tiberiumBlock, 1), new Object[]{"TTT", "TTT", "TTT", 'T', PokemonMDItems.tiberiumShard});
		//GameRegistry.addRecipe(new ItemStack(PokemonMDBlocks.richTiberiumBlock, 1), new Object[]{"TTT", "TTT", "TTT", 'T', PokemonMDItems.richTiberiumShard});
		//GameRegistry.addRecipe(new ItemStack(PokemonMDBlocks.neoTiberiumBlock, 1), new Object[]{"TTT", "TTT", "TTT", 'T', PokemonMDItems.neoTiberiumShard});

		//GameRegistry.addRecipe(new ItemStack(PokemonMDBlocks.tiberiumBricks, 2), new Object[]{"NTN", 'T', PokemonMDItems.tiberiumShard, 'N', Blocks.nether_brick});
		//GameRegistry.addRecipe(new ItemStack(PokemonMDBlocks.tiberiumBricks, 2), new Object[]{"N", "T", "N", 'T', PokemonMDItems.tiberiumShard, 'N', Blocks.nether_brick});
		//GameRegistry.addRecipe(new ItemStack(PokemonMDBlocks.richTiberiumBricks, 4), new Object[]{" N ", "NTN", " N ", 'T', PokemonMDItems.richTiberiumShard, 'N', Blocks.nether_brick});
		//GameRegistry.addRecipe(new ItemStack(PokemonMDBlocks.neoTiberiumBricks, 8), new Object[]{"NNN", "NTN", "NNN", 'T', PokemonMDItems.neoTiberiumShard, 'N', Blocks.nether_brick});

		
		/* *********** Tamable *********** */
		/*
		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.firecrackerLittenSummon, 1), new Object[]{"FEF", "GAG", "TBT", 'F', Items.fireworks, 'E', Items.ender_eye, 'B', Items.blaze_powder, 'T', Blocks.tnt, 'A', PokemonMDItems.blessingOfArceus, 'G', Blocks.gold_block});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.firecrackerLittenSummon, 1), new Object[]{"OOO", "OFO", "OOO", 'O', PokemonMDItems.oranianBerry, 'F', PokemonMDItems.firecrackerLittenKOd});
		GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItems.firecrackerLittenSummon, 1), new Object[]{PokemonMDItems.reviveSeed, PokemonMDItems.firecrackerLittenKOd});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.foxfireZoruaSummon, 1), new Object[]{"BRB", "RAR", "BWB", 'W', PokemonMDItems.willOfTheAncients, 'B', Items.blaze_powder, 'R', PokemonMDItems.rawstettaBerry, 'A', PokemonMDItems.blessingOfArceus});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.foxfireZoruaSummon, 1), new Object[]{"OOO", "OFO", "OOO", 'O', PokemonMDItems.oranianBerry, 'F', PokemonMDItems.foxfireZoruaKOd});
		GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItems.foxfireZoruaSummon, 1), new Object[]{PokemonMDItems.reviveSeed, PokemonMDItems.foxfireZoruaKOd});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.ionianNinetalesSummon, 1), new Object[]{"BBB", "EWE", "RAR", 'W', PokemonMDItems.willOfTheAncients, 'B', Items.blaze_powder, 'E', Items.ender_eye, 'R', PokemonMDItems.rawstettaBerry, 'A', PokemonMDItems.blessingOfArceus});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.ionianNinetalesSummon, 1), new Object[]{"OOO", "OIO", "OOO", 'O', PokemonMDItems.oranianBerry, 'I', PokemonMDItems.ionianNinetalesKOd});
		GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItems.ionianNinetalesSummon, 1), new Object[]{PokemonMDItems.reviveSeed, PokemonMDItems.ionianNinetalesKOd});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.okamiEspeonSummon, 1), new Object[]{"GBG", "DSD", "BAB", 'G', Items.gold_ingot, 'D', Items.diamond, 'S', Items.diamond_sword, 'B', Items.blaze_rod, 'A', PokemonMDItems.blessingOfArceus});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.okamiEspeonSummon, 1), new Object[]{"OOO", "OSO", "OOO", 'O', PokemonMDItems.oranianBerry, 'S', PokemonMDItems.okamiEspeonKOd});
		GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItems.okamiEspeonSummon, 1), new Object[]{PokemonMDItems.reviveSeed, PokemonMDItems.okamiEspeonKOd});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.okamiSylveonSummon, 1), new Object[]{"GOG", "DSD", "PAP", 'G', new ItemStack(Blocks.stained_hardened_clay, 1, LibraryClayColors.GREEN), 'O', Blocks.obsidian, 'D', Items.diamond, 'S', Items.diamond_sword, 'P', new ItemStack(Blocks.wool, 1, LibraryWoolColors.PINK), 'A', PokemonMDItems.blessingOfArceus});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.okamiSylveonSummon, 1), new Object[]{"OOO", "OSO", "OOO", 'O', PokemonMDItems.oranianBerry, 'S', PokemonMDItems.okamiSylveonKOd});
		GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItems.okamiSylveonSummon, 1), new Object[]{PokemonMDItems.reviveSeed, PokemonMDItems.okamiSylveonKOd});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.okamiUmbreonSummon, 1), new Object[]{"GGG", "ISI", "GAG", 'I', Items.iron_ingot, 'S', Items.iron_sword, 'G', Items.glowstone_dust, 'A', PokemonMDItems.blessingOfArceus});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.okamiUmbreonSummon, 1), new Object[]{"OOO", "OSO", "OOO", 'O', PokemonMDItems.oranianBerry, 'S', PokemonMDItems.okamiUmbreonKOd});
		GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItems.okamiUmbreonSummon, 1), new Object[]{PokemonMDItems.reviveSeed, PokemonMDItems.okamiUmbreonKOd});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.essenceRecaller, 1), new Object[]{" I ", "FEF", " I ", 'I', Items.iron_ingot, 'F', PokemonMDItems.dreamFeather, 'E', Items.ender_pearl});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.attackOrderer, 1), new Object[]{"ATA", " I ", " I ", 'I', Items.iron_ingot, 'A', PokemonMDItems.aurumDust, 'T', PokemonMDItems.tiberiumShard});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.attackOrderer, 1), new Object[]{"ATA", " I ", " I ", 'I', Items.iron_ingot, 'A', PokemonMDItems.aurumDust, 'T', PokemonMDItems.richTiberiumShard});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.attackOrderer, 1), new Object[]{"ATA", " I ", " I ", 'I', Items.iron_ingot, 'A', PokemonMDItems.aurumDust, 'T', PokemonMDItems.neoTiberiumShard});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.reviveSeed, 1), new Object[]{"AAA", "AOA", "AAA", 'A', PokemonMDItems.aurumDust, 'O', PokemonMDItems.oranianBerry});
*/

		/* *********** Miscellaneous *********** */
		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.goldenChaff, 1), new Object[]{" S ", "SAS", " S ", 'A', PokemonMDItems.aurumDust, 'S', Items.wheat_seeds});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.goldenChaff, 1), new Object[]{" S ", "SAS", " S ", 'A', PokemonMDItems.aurumDust, 'S', Items.pumpkin_seeds});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.goldenChaff, 1), new Object[]{" S ", "SAS", " S ", 'A', PokemonMDItems.aurumDust, 'S', Items.melon_seeds});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.aurumRod, 1), new Object[]{"#", "#", "#", '#', PokemonMDItems.aurumDust});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.aurumRod, 1), new Object[]{"###", '#', PokemonMDItems.aurumDust});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.infernoFuelRod, 1), new Object[]{"P", "G", "R", 'R', PokemonMDItems.aurumRod, 'P', Items.paper, 'G', Items.gunpowder});
		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.infernoFuelRod, 1), new Object[]{"PGR", 'R', PokemonMDItems.aurumRod, 'P', Items.paper, 'G', Items.gunpowder});

		GameRegistry.addRecipe(new ItemStack(PokemonMDItems.abyssalLiquidCrystal, 1), new Object[]{"GAG", "SES", " B ", 'A', PokemonMDItems.aurumRod, 'G', Items.glowstone_dust, 'S', Items.slime_ball, 'E', Items.ender_eye, 'B', new ItemStack(Items.potionitem, 1, 0)});

		//GameRegistry.addRecipe(new ItemStack(PokemonMDBlocks.packedAurumDust, 1), new Object[]{"AAA", "AAA", "AAA", 'A', PokemonMDItems.aurumDust});
		//GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItems.aurumDust, 9), new Object[]{PokemonMDBlocks.packedAurumDust});

		//GameRegistry.addRecipe(new ItemStack(PokemonMDItems.willOfTheAncients, 1), new Object[]{" S ", "DWD", "EBE", 'E', Items.ender_eye, 'W', Items.writable_book, 'D', PokemonMDItems.aurumDust, 'S', Items.spider_eye});
		
		GameRegistry.addShapelessRecipe(new ItemStack(PokemonMDItems.dreamFeather, 1), new Object[]{Items.feather, Items.glowstone_dust, PokemonMDItems.aurumDust});
		
	}

	public static void addSmeltingRecipes()
	{
		GameRegistry.addSmelting(PokemonMDItems.aurumDust, new ItemStack(Items.gold_nugget), 0.2F);
	}
}
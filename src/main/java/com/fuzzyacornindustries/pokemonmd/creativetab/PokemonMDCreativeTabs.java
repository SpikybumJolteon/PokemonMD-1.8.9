package com.fuzzyacornindustries.pokemonmd.creativetab;


public class PokemonMDCreativeTabs
{
	public static CreativeTabBlocks tabPokemonMDBlocks;
	public static CreativeTabItems tabPokemonMDItems;
	public static CreativeTabMobs tabPokemonMDMobs;
	public static CreativeTabTamables tabPokemonMDTamables;
	//public static CreativeTabs tabPokemonMDTurrets;

	public static void initializeTabs()
	{
		tabPokemonMDBlocks = new CreativeTabBlocks("pokemonmdTabBlocks");
		tabPokemonMDItems = new CreativeTabItems("pokemonmdTabItems");
		tabPokemonMDTamables = new CreativeTabTamables("pokemonmdTabTamables");
		tabPokemonMDMobs = new CreativeTabMobs("pokemonmdtabmobs");
		//tabPokemonMDTurrets = new CreativeTabTurrets("pokemonmdtabturrets");
	}
}
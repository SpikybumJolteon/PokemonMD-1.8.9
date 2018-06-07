package com.fuzzyacornindustries.pokemonmd.recipes;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItems;
import com.google.common.collect.Maps;

public class RecipesVerdantPurifier 
{
    private static final RecipesVerdantPurifier purifyingBase = new RecipesVerdantPurifier();
    /** The list of purifying results. */
    private final Map purifyingList = Maps.newHashMap();
    private final Map experienceList = Maps.newHashMap();

    public static RecipesVerdantPurifier instance()
    {
        return purifyingBase;
    }

    private RecipesVerdantPurifier()
    {
        addPurifyingRecipe(
                new ItemStack(Items.rotten_flesh), 
                new ItemStack(Items.porkchop), 0.3F);
        addPurifyingRecipe(
        		new ItemStack(Blocks.cobblestone), 
        		new ItemStack(Blocks.mossy_cobblestone), 0.1F);
        addPurifyingRecipe(
                new ItemStack(Blocks.mossy_cobblestone), 
                new ItemStack(Blocks.dirt), 0.1F);
        addPurifyingRecipe(
                new ItemStack(Blocks.soul_sand), 
                new ItemStack(Blocks.sand), 0.1F);
        addPurifyingRecipe(
                new ItemStack(Items.spider_eye), 
                new ItemStack(Items.nether_wart), 0.2F);
        addPurifyingRecipe(
                new ItemStack(Blocks.dirt), 
                new ItemStack(Blocks.grass), 0.1F);
        addPurifyingRecipe(
                new ItemStack(Items.poisonous_potato), 
                new ItemStack(PokemonMDItems.pechitaBerry), 1.0F);
        addPurifyingRecipe(
                new ItemStack(PokemonMDItems.silkscreenMesh), 
                new ItemStack(PokemonMDItems.silkscreenAlloy), 1.0F);
        addPurifyingRecipe(
                new ItemStack(Items.blaze_powder), 
                new ItemStack(PokemonMDItems.rawstettaBerry), 0.5F);
        addPurifyingRecipe(
                new ItemStack(Items.apple), 
                new ItemStack(PokemonMDItems.oranianBerry), 0.5F);
        addPurifyingRecipe(
                new ItemStack(Items.fish), 
                new ItemStack(PokemonMDItems.passhauraBerry), 1.0F);
        addPurifyingRecipe(
                new ItemStack(PokemonMDItems.goldenChaff), 
                new ItemStack(Items.wheat), 0.3F);
    }

    public void addPurifyingRecipe(ItemStack parItemStackIn, ItemStack parItemStackOut, float parExperience)
    {
    	purifyingList.put(parItemStackIn, parItemStackOut);
        experienceList.put(parItemStackOut, Float.valueOf(parExperience));
    }

    public ItemStack getPurifyingResult(ItemStack parItemStack)
    {
        Iterator iterator = purifyingList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return null;
            }

            entry = (Entry)iterator.next();
        }
        while (!areItemStacksEqual(parItemStack, (ItemStack)entry

              .getKey()));

        return (ItemStack)entry.getValue();
    }

    private boolean areItemStacksEqual(ItemStack parItemStack1, ItemStack parItemStack2)
    {
        return parItemStack2.getItem() == parItemStack1.getItem() 
              && (parItemStack2.getMetadata() == 32767 
              || parItemStack2.getMetadata() == parItemStack1.getMetadata());
    }

    public Map getPurifyingList()
    {
        return purifyingList;
    }

    public float getVerdantPurifierExperience(ItemStack parItemStack)
    {
        Iterator iterator = experienceList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 0.0F;
            }

            entry = (Entry)iterator.next();
        }
        while (!areItemStacksEqual(parItemStack, (ItemStack)entry.getKey()));

        return ((Float)entry.getValue()).floatValue();
    }
}
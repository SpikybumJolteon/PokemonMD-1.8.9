package com.fuzzyacornindustries.pokemonmd.recipes;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItems;
import com.google.common.collect.Maps;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class RecipesVespeneCondenser 
{
    private static final RecipesVespeneCondenser condenserBase = new RecipesVespeneCondenser();
    /** The list of purifying results. */
    private final Map condensingList = Maps.newHashMap();
    private final Map durationList = Maps.newHashMap();
    private final Map experienceList = Maps.newHashMap();

    public static RecipesVespeneCondenser instance()
    {
        return condenserBase;
    }

    private RecipesVespeneCondenser()
    {
    	/*
        addCondensingRecipe(
                new ItemStack(PokemonMDItem.aurumDust), 
                new ItemStack(PokemonMDItem.vespeneCrystal), 
                3000, 0.1F);
        addCondensingRecipe(
                new ItemStack(PokemonMDItem.aurumRod), 
                new ItemStack(PokemonMDItem.vespeneFuelRod), 
                8000, 0.3F);
        addCondensingRecipe(
                new ItemStack(Items.emerald), 
                new ItemStack(PokemonMDItem.emeraldOfChaos), 
                26000 * 5, 0.99F); // 26000 equals a day*/
        addCondensingRecipe(
                new ItemStack(Items.quartz), 
                new ItemStack(PokemonMDItems.tiberiumShard), 
                1500, 0.1F);
        addCondensingRecipe(
                new ItemStack(PokemonMDItems.tiberiumShard), 
                new ItemStack(PokemonMDItems.richTiberiumShard), 
                5000, 0.2F);
        addCondensingRecipe(
                new ItemStack(PokemonMDItems.richTiberiumShard), 
                new ItemStack(PokemonMDItems.neoTiberiumShard), 
                15000, 0.4F);
    }

    public void addCondensingRecipe(ItemStack parItemStackIn, ItemStack parItemStackOut, int parCondensationDuration, float parExperience)
    {
    	condensingList.put(parItemStackIn, parItemStackOut);
    	durationList.put(parItemStackIn, parCondensationDuration);
        experienceList.put(parItemStackOut, Float.valueOf(parExperience));
    }

    public ItemStack getCondensingResult(ItemStack parItemStack)
    {
        Iterator iterator = condensingList.entrySet().iterator();
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
              && (parItemStack2.getItemDamage() == 32767 
              || parItemStack2.getItemDamage() == parItemStack1.getItemDamage());
    }

    public Map getCondensingList()
    {
        return condensingList;
    }

    public int getVespeneCondenserItemDuration(ItemStack parItemStack)
    {
        Iterator iterator = durationList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 200; // Dummy value
            }

            entry = (Entry)iterator.next();
        }
        while (!areItemStacksEqual(parItemStack, (ItemStack)entry.getKey()));

        return ((Integer)entry.getValue()).intValue();
    }

    public float getVespeneCondenserExperience(ItemStack parItemStack)
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
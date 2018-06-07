package com.fuzzyacornindustries.pokemonmd.recipes;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItems;
import com.google.common.collect.Maps;

public class FuelsVerdantPurifier 
{
    private static final FuelsVerdantPurifier purifyingFuelBase = new FuelsVerdantPurifier();
    /** The list of fuel values. */
    private final Map fuelList = Maps.newHashMap();

    public static FuelsVerdantPurifier instance()
    {
        return purifyingFuelBase;
    }

    private FuelsVerdantPurifier()
    {
        addPurifyingRecipe(new ItemStack(Blocks.pumpkin), 400);
        addPurifyingRecipe(new ItemStack(Blocks.melon_block), 400);
        addPurifyingRecipe(new ItemStack(Blocks.cactus), 100);
        addPurifyingRecipe(new ItemStack(Blocks.leaves), 50);
        addPurifyingRecipe(new ItemStack(Blocks.leaves2), 50);
        addPurifyingRecipe(new ItemStack(Blocks.vine), 50);
        addPurifyingRecipe(new ItemStack(Blocks.waterlily), 800);
        addPurifyingRecipe(new ItemStack(Blocks.sapling), 200);
        addPurifyingRecipe(new ItemStack(Items.reeds), 100);
        addPurifyingRecipe(new ItemStack(Items.wheat), 200);
        addPurifyingRecipe(new ItemStack(Items.wheat_seeds), 50);
        addPurifyingRecipe(new ItemStack(Items.apple), 400);
        addPurifyingRecipe(new ItemStack(Items.potato), 200);
        addPurifyingRecipe(new ItemStack(Items.carrot), 200);
        addPurifyingRecipe(new ItemStack(Items.melon), 100);
        addPurifyingRecipe(new ItemStack(PokemonMDItems.colbertaBerry), 400);
        addPurifyingRecipe(new ItemStack(PokemonMDItems.oranianBerry), 100);
        addPurifyingRecipe(new ItemStack(PokemonMDItems.passhauraBerry), 200);
        addPurifyingRecipe(new ItemStack(PokemonMDItems.pechitaBerry), 200);
        addPurifyingRecipe(new ItemStack(PokemonMDItems.rawstettaBerry), 200);
    }

    public void addPurifyingRecipe(ItemStack parItemStackFuel, int parFuelDuration)
    {
    	fuelList.put(parItemStackFuel, parFuelDuration);
    }
    
    public Map getFuelList()
    {
        return fuelList;
    }

    private boolean areItemStacksEqual(ItemStack parItemStack1, ItemStack parItemStack2)
    {
        return parItemStack2.getItem() == parItemStack1.getItem() 
              && (parItemStack2.getMetadata() == 32767 
              || parItemStack2.getMetadata() == parItemStack1.getMetadata());
    }

    public int getVerdantPurifierFuelTime(ItemStack parItemStack)
    {
        Iterator iterator = fuelList.entrySet().iterator();
        Entry entry;

        do
        {
            if (!iterator.hasNext())
            {
                return 0;
            }

            entry = (Entry)iterator.next();
        }
        while (!areItemStacksEqual(parItemStack, (ItemStack)entry.getKey()));

        return ((Integer)entry.getValue()).intValue();
    }
}
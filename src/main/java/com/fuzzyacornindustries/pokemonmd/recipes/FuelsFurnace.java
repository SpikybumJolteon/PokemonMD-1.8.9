package com.fuzzyacornindustries.pokemonmd.recipes;

import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItems;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.fml.common.IFuelHandler;

public class FuelsFurnace implements IFuelHandler
{
	private static final ItemStack INFERNO_FUEL_ROD = new ItemStack(PokemonMDItems.infernoFuelRod);
	private static final ItemStack ABYSSAL_LIQUID_CRYSTAL = new ItemStack(PokemonMDItems.abyssalLiquidCrystal);

	@Override
	public int getBurnTime(ItemStack fuel)
	{
		if (fuel.isItemEqual(INFERNO_FUEL_ROD))
		{
			return TileEntityFurnace.getItemBurnTime(new ItemStack(Items.coal)) * 2;
		}
		else if (fuel.isItemEqual(ABYSSAL_LIQUID_CRYSTAL))
		{
			return TileEntityFurnace.getItemBurnTime(new ItemStack(Items.coal)) * 4;
		}

		return 0;
	}
}
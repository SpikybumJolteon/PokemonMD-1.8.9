package com.fuzzyacornindustries.pokemonmd.gui;

import com.fuzzyacornindustries.pokemonmd.container.ContainerVerdantPurifier;
import com.fuzzyacornindustries.pokemonmd.reference.ModStrings;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiVerdantPurifier  extends GuiContainer
{
	private static final ResourceLocation verdantPurifierGuiTextures = 
			new ResourceLocation(ModStrings.MODID +":textures/guis/container/verdantpurifiergui.png");
	private final InventoryPlayer inventoryPlayer;
	private final IInventory tileVerdantPurifier;

	public GuiVerdantPurifier(InventoryPlayer parInventoryPlayer, IInventory parInventoryVerdantPurifier)
	{
		super(new ContainerVerdantPurifier(parInventoryPlayer, parInventoryVerdantPurifier));
		inventoryPlayer = parInventoryPlayer;
		tileVerdantPurifier = parInventoryVerdantPurifier;
	}

	protected void drawGuiContainerForegroundLayer(int mouseX, int par2)
	{
		String s = tileVerdantPurifier.getDisplayName().getUnformattedText();
		this.fontRendererObj.drawString(s, xSize/2-fontRendererObj.getStringWidth(s)/2, 6, 4210752);
		this.fontRendererObj.drawString(inventoryPlayer.getDisplayName().getUnformattedText(), 8, this.ySize - 94, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) 
	{
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
		mc.getTextureManager().bindTexture(verdantPurifierGuiTextures);
		int marginHorizontal = (width - xSize) / 2;
		int marginVertical = (height - ySize) / 2;
		drawTexturedModalRect(marginHorizontal, marginVertical, 0, 0, xSize, ySize);

		int fuelLevel = getFuelLevel(14);
		this.drawTexturedModalRect(marginHorizontal + 56, marginVertical + 36 + 14 - fuelLevel, 176, 14 - fuelLevel, 14, fuelLevel + 2);

		int progressLevel = getProgressLevel(24);
		this.drawTexturedModalRect(marginHorizontal + 79, marginVertical + 34, 176, 14, progressLevel + 1, 16);
	}

	private int getFuelLevel(int fuelIndicatorPixelHeight)
	{
		int ticksFuelUsageSoFar = tileVerdantPurifier.getField(0); 
		int ticksPerFuel = tileVerdantPurifier.getField(1);
		return ticksPerFuel != 0 && ticksFuelUsageSoFar != 0 ? ticksFuelUsageSoFar * fuelIndicatorPixelHeight/ticksPerFuel : 0;
	}

	private int getProgressLevel(int progressIndicatorPixelWidth)
	{
		int ticksGrindingItemSoFar = tileVerdantPurifier.getField(2); 
		int ticksPerItem = tileVerdantPurifier.getField(3);
		return ticksPerItem != 0 && ticksGrindingItemSoFar != 0 ? ticksGrindingItemSoFar * progressIndicatorPixelWidth/ticksPerItem : 0;
	}
}
package com.fuzzyacornindustries.pokemonmd.renderer.tileentity;

import org.lwjgl.opengl.GL11;

import com.fuzzyacornindustries.pokemonmd.model.block.ModelVespeneCondenser;
import com.fuzzyacornindustries.pokemonmd.reference.ModStrings;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityVespeneCondenser;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RendererVespeneCondenser extends TileEntitySpecialRenderer
{
	private static final ResourceLocation texture = new ResourceLocation(ModStrings.MODID + ":" +"textures/blocks/vespenecondenser.png");
	private static final ResourceLocation textureGlow = new ResourceLocation(ModStrings.MODID + ":" +"textures/blocks/vespenecondenserglows.png");
	private ModelVespeneCondenser model;
	private ModelVespeneCondenser modelGlow;

	public RendererVespeneCondenser()
	{
		this.model = new ModelVespeneCondenser();
		this.modelGlow = new ModelVespeneCondenser();
	}

	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float f, int intPar) 
	{
		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);

		this.bindTexture(texture);

		GL11.glPushMatrix();
		this.model.renderModel(0.0625F, (TileEntityVespeneCondenser)tileEntity);
		GL11.glPopMatrix();
		GL11.glPopMatrix();

		/* ************ */

		GL11.glPushMatrix();
		GL11.glTranslatef((float)x + 0.5F, (float)y + 1.5F, (float)z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);

		this.bindTexture(textureGlow);

		float f1 = 1.0F;
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glDisable(GL11.GL_ALPHA_TEST);
		GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
		GL11.glDisable(GL11.GL_LIGHTING);
		char c0 = 61680;
		int j = c0 % 65536;
		int k = c0 / 65536;
		OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float)j / 1.0F, (float)k / 1.0F);
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glColor4f(1.0F, 1.0F, 1.0F, f1);

		GL11.glPushMatrix();
		this.modelGlow.renderModel(0.0625F, (TileEntityVespeneCondenser)tileEntity);
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
	}
}
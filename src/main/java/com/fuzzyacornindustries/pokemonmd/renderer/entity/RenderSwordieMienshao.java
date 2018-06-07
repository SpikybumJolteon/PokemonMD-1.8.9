package com.fuzzyacornindustries.pokemonmd.renderer.entity;

import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntitySwordieMienshao;
import com.fuzzyacornindustries.pokemonmd.model.mob.ModelSwordieMienshao;
import com.fuzzyacornindustries.pokemonmd.reference.ModStrings;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerWolfCollar;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSwordieMienshao extends RenderLiving<EntitySwordieMienshao>
{
	private static final ResourceLocation mainTexture = new ResourceLocation(ModStrings.MODID + ":" +"textures/mobs/swordiemienshao.png");

	public RenderSwordieMienshao(RenderManager renderManagerIn, ModelBase modelBaseIn, float shadowSizeIn)
    {
        super(renderManagerIn, modelBaseIn, shadowSizeIn);
    }
	
	@Override
    protected ResourceLocation getEntityTexture(EntitySwordieMienshao entity)
    {
        return mainTexture;
    }
}
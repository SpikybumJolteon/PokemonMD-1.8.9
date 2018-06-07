package com.fuzzyacornindustries.pokemonmd.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.Timer;
import net.minecraft.world.World;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.ReflectionHelper;

import com.fuzzyacornindustries.pokemonmd.block.PokemonMDBlocks;
import com.fuzzyacornindustries.pokemonmd.entity.mob.hostile.EntitySwordieMienshao;
import com.fuzzyacornindustries.pokemonmd.item.PokemonMDItems;
import com.fuzzyacornindustries.pokemonmd.main.PokemonMD;
import com.fuzzyacornindustries.pokemonmd.model.mob.ModelSwordieMienshao;
import com.fuzzyacornindustries.pokemonmd.renderer.entity.RenderSwordieMienshao;
import com.fuzzyacornindustries.pokemonmd.renderer.tileentity.RendererVerdantPurifier;
import com.fuzzyacornindustries.pokemonmd.renderer.tileentity.RendererVespeneCondenser;
import com.fuzzyacornindustries.pokemonmd.renderer.tileentity.RendererXelNagaDynamo;
import com.fuzzyacornindustries.pokemonmd.renderer.tileentity.RendererXelNagaPylon;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityVerdantPurifier;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityVespeneCondenser;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityXelNagaDynamo;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityXelNagaPylon;

public class ClientProxy extends CommonProxy
{
	private Timer mcTimer;
	
	@Override
	public void preInitRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(EntitySwordieMienshao.class, new IRenderFactory<EntitySwordieMienshao>()
        {
            @Override
            public Render<? super EntitySwordieMienshao> createRenderFor(RenderManager manager)
            {
                return new RenderSwordieMienshao(manager, new ModelSwordieMienshao(), 0.2F);
            }
        });

		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVerdantPurifier.class, new RendererVerdantPurifier());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityVespeneCondenser.class, new RendererVespeneCondenser());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityXelNagaDynamo.class, new RendererXelNagaDynamo());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityXelNagaPylon.class, new RendererXelNagaPylon());
	}
	
	@Override
	public void initRenderRegisters()
	{
		PokemonMDBlocks.registerRenders();
		PokemonMDItems.registerRenders();
	}
	
	public void initTimer() 
	{
		mcTimer = ReflectionHelper.getPrivateValue(Minecraft.class, Minecraft.getMinecraft(), PokemonMD.fTimer);
	}

	public float getPartialTick() 
	{
		return mcTimer.renderPartialTicks;
	}

	@Override
	public World getWorldClient() 
	{
		return FMLClientHandler.instance().getWorldClient();
	}
}
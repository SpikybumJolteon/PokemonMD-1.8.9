package com.fuzzyacornindustries.pokemonmd.entity.mob.hostile;

import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

public class HostilePokemonMD extends EntityMob implements IAnimatedEntity
{
	private int animationID;
	private int animationTick;

	public static final int actionIDNone = 0;

	/**
	 * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
	 *//*
	@Override
	public boolean interact(EntityPlayer par1EntityPlayer)
	{
		ItemStack itemstack = par1EntityPlayer.inventory.getCurrentItem();

		if(itemstack != null)
		{
			if(itemstack.getItem() == PokemonMDItem.deminizer)
			{
				for(int i = 0; i < 5; i++)
				{
					this.worldObj.spawnParticle("largeexplode", this.posX + this.rand.nextGaussian(), this.posY + this.height / 2D + this.rand.nextGaussian(), this.posZ + this.rand.nextGaussian(), 1.0D, 0.0D, 0.0D);
				}

				this.worldObj.playSoundAtEntity(this, ModStrings.MODID + ":effects.deminizer", 3.0F, 0.4F / (this.rand.nextFloat() * 0.4F + 0.8F));
			}
		}

		return super.interact(par1EntityPlayer);
	}

	public void playIgniteSound(EntityLivingBase targetEntity)
	{
		targetEntity.worldObj.playSoundAtEntity(targetEntity, ModStrings.MODID + ":mob.commonsounds.ignite", 1.5F, 0.4F / (targetEntity.worldObj.rand.nextFloat() * 0.4F + 0.8F));
	}

	public void playBioSound(EntityLivingBase targetEntity)
	{
		targetEntity.worldObj.playSoundAtEntity(targetEntity, ModStrings.MODID + ":mob.commonsounds.bio", 1.5F, 0.4F / (targetEntity.worldObj.rand.nextFloat() * 0.4F + 0.8F));
	}*/

	public HostilePokemonMD(World world)
	{
		super(world);

		animationID = actionIDNone;
		animationTick = 0;
	}

	@Override
	public void setAnimationID(int id) 
	{
		animationID = id;
	}

	@Override
	public void setAnimationTick(int tick) 
	{
		animationTick = tick;	
	}

	@Override
	public int getAnimationID() 
	{
		return animationID;
	}

	@Override
	public int getAnimationTick() 
	{
		return animationTick;
	}
}
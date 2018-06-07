package com.fuzzyacornindustries.pokemonmd.animation;

import com.fuzzyacornindustries.pokemonmd.main.PokemonMD;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;

public abstract class AIAnimation extends EntityAIBase 
{	
	private IAnimatedEntity animatedEntity;
	
	public AIAnimation(IAnimatedEntity entity, int mutexBits) 
	{
		animatedEntity = entity;
		setMutexBits(mutexBits);
	}
	
	public abstract int getAnimationID();
	
	public <T extends EntityLiving> T getEntity() 
	{
		return (T)animatedEntity;
	}
	
	public abstract boolean isAutomatic();
	
	public abstract int getDuration();
	
	public boolean shouldAnimate() 
	{
		return false;
	}
	
	public boolean shouldExecute() 
	{
		if(isAutomatic()) return animatedEntity.getAnimationID() == getAnimationID();
		return shouldAnimate();
	}
	
	public void startExecuting() 
	{
		if(!isAutomatic()) PokemonMD.sendAnimationPacket(animatedEntity, getAnimationID());
		animatedEntity.setAnimationTick(0);
	}
	
	public boolean continueExecuting() 
	{
		return animatedEntity.getAnimationTick() < getDuration();
	}

	public void resetTask() 
	{
		PokemonMD.sendAnimationPacket(animatedEntity, 0);
	}
}
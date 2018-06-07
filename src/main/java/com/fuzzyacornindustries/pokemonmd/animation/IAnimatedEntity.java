package com.fuzzyacornindustries.pokemonmd.animation;

public interface IAnimatedEntity 
{	
	void setAnimationID(int id);
	void setAnimationTick(int tick);
	int getAnimationID();
	int getAnimationTick();
}
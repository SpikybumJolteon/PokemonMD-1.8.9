package com.fuzzyacornindustries.pokemonmd.tileentity;

import java.util.Random;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;

import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;

public class TileEntityXelNagaDynamo extends TileEntity implements IAnimatedEntity, ITickable
{
	public IdleAnimationClock dynamoIdleAnimationClock[] = new IdleAnimationClock[3];

	public static final int actionIDNone = 0;

	private int animationID;
	private int animationTick;

    private String customName;

	public TileEntityXelNagaDynamo()
	{
		setClockDefaults();

		animationID = actionIDNone;
		animationTick = 0;
	}
	
    public void writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);

        if (this.hasCustomName())
        {
            compound.setString("CustomName", this.customName);
        }
    }

    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);

        if (compound.hasKey("CustomName", 8))
        {
            this.customName = compound.getString("CustomName");
        }
    }
    
    public String getName()
    {
        return this.hasCustomName() ? this.customName : "container.enchant";
    }

    public boolean hasCustomName()
    {
        return this.customName != null && this.customName.length() > 0;
    }

    public void setCustomName(String customNameIn)
    {
        this.customName = customNameIn;
    }

    @Override
	public void update()
	{
		incrementPartClocks();
	}

	/************************************
	 * Animation dependent code follows.*
	 ************************************/
	public IdleAnimationClock getDynamoAnimationClock(int partNumber) 
	{
		return dynamoIdleAnimationClock[partNumber];
	}
	
	public void incrementPartClocks()
	{
		for(int i = 0; i < dynamoIdleAnimationClock.length; i++)
		{
			dynamoIdleAnimationClock[i].incrementClocks();
		}
	}
	
	public void setClockDefaults()
	{
		setDynamoClockDefaults();
	}

	public void setDynamoClockDefaults()
	{
		for(int i = 0; i < dynamoIdleAnimationClock.length; i++)
		{
			dynamoIdleAnimationClock[i] = new IdleAnimationClock(1, 1, 1);	
		}
		
		setDynamoClockValues(dynamoIdleAnimationClock[0], 5, 10, 7);
		setDynamoClockValues(dynamoIdleAnimationClock[1], 50, 140, 260);
		setDynamoClockValues(dynamoIdleAnimationClock[2], 10, 25, 15);
	}
	
	public void setDynamoClockValues(IdleAnimationClock idleAnimationClock, int xTime, int yTime, int zTime)
	{
		Random rand = new Random();

		int startingClockX = rand.nextInt(100);
		int startingClockY = rand.nextInt(100);
		int startingClockZ = rand.nextInt(100);

		idleAnimationClock.setPhaseDurationX(0, xTime);
		idleAnimationClock.setPhaseDurationY(0, yTime);
		idleAnimationClock.setPhaseDurationZ(0, zTime);

		while(startingClockX > idleAnimationClock.getTotalDurationLengthX())
		{
			startingClockX -= idleAnimationClock.getTotalDurationLengthX();
		}

		while(startingClockY > idleAnimationClock.getTotalDurationLengthY())
		{
			startingClockY -= idleAnimationClock.getTotalDurationLengthY();
		}

		while(startingClockZ > idleAnimationClock.getTotalDurationLengthZ())
		{
			startingClockZ -= idleAnimationClock.getTotalDurationLengthZ();
		}

		idleAnimationClock.setClockX(startingClockX);
		idleAnimationClock.setClockY(startingClockY);
		idleAnimationClock.setClockZ(startingClockZ);
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
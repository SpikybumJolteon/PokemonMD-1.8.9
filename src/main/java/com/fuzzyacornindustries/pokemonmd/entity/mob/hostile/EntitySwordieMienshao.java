package com.fuzzyacornindustries.pokemonmd.entity.mob.hostile;

import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.entity.mob.ai.AISwordieMienshaoSlash;
import com.fuzzyacornindustries.pokemonmd.main.PokemonMD;
import com.fuzzyacornindustries.pokemonmd.reference.ModStrings;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;

public class EntitySwordieMienshao extends HostilePokemonMD implements IAnimatedEntity, IRangedAttackMob
{
	private IdleAnimationClock neckBobbleIdleAnimationClock;
	private IdleAnimationClock bodyIdleAnimationClock[] = new IdleAnimationClock[2];
	private IdleAnimationClock tailIdleAnimationClock[] = new IdleAnimationClock[12];
	private IdleAnimationClock armIdleAnimationClock;

	public static final int actionIDNone = 0;
	public static final int actionIDSlash = 1;

	private int animationID;
	private int animationTick;

	static String mobName = "swordiemienshao";

	public EntitySwordieMienshao(World par1World)
	{
		super(par1World);
		this.setSize(0.4F, 1.4F);
		this.tasks.addTask(0, new EntityAISwimming(this));
		this.tasks.addTask(1, new AISwordieMienshaoSlash(this));

		this.tasks.addTask(2, new EntityAIArrowAttack(this, 1.0D, 1, 1, 2.5F));
		this.tasks.addTask(3, new EntityAIWander(this, 0.75D));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(5, new EntityAILookIdle(this));
        this.targetTasks.addTask(1, new EntityAIHurtByTarget(this, false, new Class[0]));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntitySpider.class, true));
		
		setClockDefaults();

		animationID = actionIDNone;
		animationTick = 0;
	}

	public static String getMobName()
	{
		return mobName;
	}

	protected void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setBaseValue(4.0D);
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setBaseValue(20.0D);
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setBaseValue(22.0D);
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setBaseValue(0.30D);
	}

	protected void entityInit()
	{
		super.entityInit();
		this.getDataWatcher().addObject(12, Byte.valueOf((byte)0));
		this.getDataWatcher().addObject(13, Byte.valueOf((byte)0));
		this.getDataWatcher().addObject(14, Byte.valueOf((byte)0));
	}
	
	@Override
	public void onLivingUpdate()
	{
		super.onLivingUpdate();
	}

	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if(animationID != 0) animationTick++;

		incrementPartClocks();
	}

	@Override
    protected void collideWithEntity(Entity targetEntity)
    {
        if (targetEntity instanceof IMob && this.getRNG().nextInt(10) == 0  && !(targetEntity instanceof EntityCreeper))
        {
            this.setAttackTarget((EntityLivingBase)targetEntity);
        }

        super.collideWithEntity(targetEntity);
    }

	@Override
	public void attackEntityWithRangedAttack(EntityLivingBase targetEntity, float par2)
	{
		if(animationID == 0)
		{
			//System.out.println( "Test Entity Ticks" );
			//System.out.println( Integer.toString( animationTick ) );
			
			PokemonMD.sendAnimationPacket(this, actionIDSlash);
		}
	}
/*
	@Override
	public boolean attackEntityAsMob(Entity targetEntity)
	{
		if(animationID == 0)
		{
			PokemonMD.sendAnimationPacket(this, actionIDSlash);
		}
		
		return true;
	}
*/
	@Override
	protected String getLivingSound()
	{
		return ModStrings.MODID + ":mob." + getMobName() + ".living";
	}
	
	@Override
	protected String getHurtSound()
	{
		return ModStrings.MODID + ":mob." + getMobName() + ".hurt";
	}

	@Override
	protected String getDeathSound()
	{
		return ModStrings.MODID + ":mob." + getMobName() + ".death";
	}

	@Override
    protected void playStepSound(BlockPos pos, Block blockIn)
    {
        this.playSound("mob.wolf.step", 0.15F, 1.0F);
    }

	@Override
	protected void dropFewItems(boolean killedByPlayer, int lootingEnchantmentLevel)
	{
		if(killedByPlayer == true)
		{
			int j;
			int k;

			j = this.rand.nextInt(3 + lootingEnchantmentLevel);

			for (k = 0; k < j; ++k)
			{
				this.dropItem(Items.gold_nugget, 1);
			}
		}
	}

	@Override
    protected void addRandomDrop()
    {
		this.dropItem(Items.gold_nugget, 9);
	}
	
	/************************************
	 * Animation dependent code follows.*
	 ************************************/
	public IdleAnimationClock getIdleAnimationClockNeckBobble()
	{
		return neckBobbleIdleAnimationClock;
	}

	public IdleAnimationClock getIdleAnimationClockBody(int partNumber)
	{
		return bodyIdleAnimationClock[partNumber];
	}

	public IdleAnimationClock getIdleAnimationClockArm()
	{
		return armIdleAnimationClock;
	}

	public IdleAnimationClock getIdleAnimationClockTail(int partNumber)
	{
		return tailIdleAnimationClock[partNumber];
	}

	public void incrementPartClocks()
	{
		neckBobbleIdleAnimationClock.incrementClocks();

		for(int i = 0; i < bodyIdleAnimationClock.length; i++)
		{
			bodyIdleAnimationClock[i].incrementClocks();
		}
		
		armIdleAnimationClock.incrementClocks();
		
		for(int i = 0; i < tailIdleAnimationClock.length; i++)
		{
			tailIdleAnimationClock[i].incrementClocks();
		}
	}
	
	public void setClockDefaults()
	{
		setNeckBobbleClockDefaults();
		setBodyClockDefaults();
		setArmClockDefaults();
		setTailClockDefaults();
	}

	public void setNeckBobbleClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		neckBobbleIdleAnimationClock = new IdleAnimationClock(1, 0, 0);

		neckBobbleIdleAnimationClock.setPhaseDurationX(0, 75);

		int startingClockX = randomInt;

		while(startingClockX > neckBobbleIdleAnimationClock.getTotalDurationLengthX())
		{
			startingClockX -= neckBobbleIdleAnimationClock.getTotalDurationLengthX();
		}

		neckBobbleIdleAnimationClock.setClockX(startingClockX);
	}

	public void setBodyClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		for(int i = 0; i < bodyIdleAnimationClock.length; i++)
		{
			bodyIdleAnimationClock[i] = new IdleAnimationClock(0, 0, 1);

			bodyIdleAnimationClock[i].setPhaseDurationZ(0, 60);

			float frequencyZ = 0.35F;

			int startingClockZ = (int)(((float)(bodyIdleAnimationClock.length - i) / (float)bodyIdleAnimationClock.length) * (float)bodyIdleAnimationClock[i].getTotalDurationLengthZ() * frequencyZ) + randomInt;

			while(startingClockZ > bodyIdleAnimationClock[i].getTotalDurationLengthZ())
			{
				startingClockZ -= bodyIdleAnimationClock[i].getTotalDurationLengthZ();
			}

			bodyIdleAnimationClock[i].setClockZ(startingClockZ);
		}
	}

	public void setArmClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		armIdleAnimationClock = new IdleAnimationClock(1, 0, 0);

		armIdleAnimationClock.setPhaseDurationX(0, 80);

		int startingClockX = randomInt;

		while(startingClockX > armIdleAnimationClock.getTotalDurationLengthX())
		{
			startingClockX -= armIdleAnimationClock.getTotalDurationLengthX();
		}

		armIdleAnimationClock.setClockX(startingClockX);
	}

	public void setTailClockDefaults()
	{
		int randomInt = this.rand.nextInt(100);

		for(int i = 0; i < tailIdleAnimationClock.length; i++)
		{
			tailIdleAnimationClock[i] = new IdleAnimationClock(1, 1, 0);

			tailIdleAnimationClock[i].setPhaseDurationX(0, 80);
			tailIdleAnimationClock[i].setPhaseDurationY(0, 100);

			float frequencyX = 0.65F;
			float frequencyY = 0.60F;

			int startingClockX = (int)(((float)(tailIdleAnimationClock.length - i) / (float)tailIdleAnimationClock.length) * (float)tailIdleAnimationClock[i].getTotalDurationLengthX() * frequencyX) + randomInt;
			int startingClockY = (int)(((float)(tailIdleAnimationClock.length - i) / (float)tailIdleAnimationClock.length) * (float)tailIdleAnimationClock[i].getTotalDurationLengthY() * frequencyY) + randomInt;

			while(startingClockX > tailIdleAnimationClock[i].getTotalDurationLengthX())
			{
				startingClockX -= tailIdleAnimationClock[i].getTotalDurationLengthX();
			}

			while(startingClockY > tailIdleAnimationClock[i].getTotalDurationLengthY())
			{
				startingClockY -= tailIdleAnimationClock[i].getTotalDurationLengthY();
			}

			tailIdleAnimationClock[i].setClockX(startingClockX);
			tailIdleAnimationClock[i].setClockY(startingClockY);
		}
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
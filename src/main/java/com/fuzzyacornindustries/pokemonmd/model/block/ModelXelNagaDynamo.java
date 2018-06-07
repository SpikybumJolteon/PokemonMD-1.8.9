package com.fuzzyacornindustries.pokemonmd.model.block;

import com.fuzzyacornindustries.pokemonmd.animation.AnimationDeployer;
import com.fuzzyacornindustries.pokemonmd.animation.IAnimatedEntity;
import com.fuzzyacornindustries.pokemonmd.animation.IdleAnimationClock;
import com.fuzzyacornindustries.pokemonmd.animation.PartInfo;
import com.fuzzyacornindustries.pokemonmd.animation.Vector3f;
import com.fuzzyacornindustries.pokemonmd.tileentity.TileEntityXelNagaDynamo;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelXelNagaDynamo extends ModelBase 
{
	public final float PI = (float)Math.PI;

	private AnimationDeployer animationDeployer;

	public ModelRenderer core;
	PartInfo coreInfo;

	public ModelRenderer innerRingJoint;
	public ModelRenderer innerRing;
	PartInfo innerRingJointInfo;
	PartInfo innerRingInfo;

	public ModelRenderer midRingJoint;
	public ModelRenderer midRing;
	PartInfo midRingJointInfo;
	PartInfo midRingInfo;

	public ModelRenderer outerRingJoint;
	public ModelRenderer outerRing;
	PartInfo outerRingJointInfo;
	PartInfo outerRingInfo;

	public ModelXelNagaDynamo() 
	{
		this.textureWidth = 64;
		this.textureHeight = 32;

		this.core = new ModelRenderer(this, 0, 3);
		this.core.setRotationPoint(0.0F, 16.0F, 0.0F);
		this.core.addBox(-1.5F, -0.5F, -1.5F, 3, 1, 3, 0.0F);
		this.core.setTextureOffset(2, 0).addBox(-1.0F, -1.5F, -1.0F, 2, 1, 2, 0.0F); // coreTop
		this.core.setTextureOffset(2, 7).addBox(-1.0F, 0.5F, -1.0F, 2, 1, 2, 0.0F); // coreBot
		coreInfo = new PartInfo(core);

		this.innerRingJoint = new ModelRenderer(this, 4, 19);
		this.innerRingJoint.setRotationPoint(0.0F, 16.0F, 0.0F);
		this.innerRingJoint.addBox(-1.0F, -3.0F, -1.5F, 0, 0, 0, 0.0F);
		this.innerRing = new ModelRenderer(this, 4, 19); // innerRingN
		this.innerRing.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.innerRing.addBox(-1.0F, -3.0F, -1.5F, 2, 1, 3, 0.0F);
		this.innerRing.setTextureOffset(11, 23).addBox(-1.0F, -2.5F, 1.5F, 2, 1, 1, 0.0F); // innerRingNE
		this.innerRing.setTextureOffset(12, 25).addBox(-1.0F, -1.5F, 2.0F, 2, 3, 1, 0.0F); // innerRingE
		this.innerRing.setTextureOffset(11, 29).addBox(-1.0F, 1.5F, 1.5F, 2, 1, 1, 0.0F); // innerRingSE
		this.innerRing.setTextureOffset(4, 28).addBox(-1.0F, 2.0F, -1.5F, 2, 1, 3, 0.0F); // innerRingS
		this.innerRing.setTextureOffset(1, 29).addBox(-1.0F, 1.5F, -2.5F, 2, 1, 1, 0.0F); // innerRingSW
		this.innerRing.setTextureOffset(0, 25).addBox(-1.0F, -1.5F, -3.0F, 2, 3, 1, 0.0F); // innerRingW
		this.innerRing.setTextureOffset(1, 23).addBox(-1.0F, -2.5F, -2.5F, 2, 1, 1, 0.0F); // innerRingNW
		innerRingInfo = new PartInfo(innerRing);

		this.midRingJoint = new ModelRenderer(this, 22, 4);
		this.midRingJoint.setRotationPoint(0.0F, 16.0F, 0.0F);
		this.midRingJoint.addBox(-1.0F, -5.0F, -2.0F, 0, 0, 0, 0.0F);
		this.midRing = new ModelRenderer(this, 22, 4); // midRingN
		this.midRing.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.midRing.addBox(-1.0F, -5.0F, -2.0F, 2, 1, 4, 0.0F);
		this.midRing.setTextureOffset(30, 9).addBox(-1.0F, -4.5F, 2.0F, 2, 1, 1, 0.0F); // midRingNNE
		this.midRing.setTextureOffset(31, 11).addBox(-1.0F, -4.0F, 3.0F, 2, 1, 1, 0.0F); // midRingNE
		this.midRing.setTextureOffset(32, 13).addBox(-1.0F, -3.0F, 3.5F, 2, 1, 1, 0.0F); // midRingENE
		this.midRing.setTextureOffset(33, 15).addBox(-1.0F, -2.0F, 4.0F, 2, 4, 1, 0.0F); // midRingE
		this.midRing.setTextureOffset(32, 20).addBox(-1.0F, 2.0F, 3.5F, 2, 1, 1, 0.0F); // midRingESE
		this.midRing.setTextureOffset(31, 22).addBox(-1.0F, 3.0F, 3.0F, 2, 1, 1, 0.0F); // midRingSE
		this.midRing.setTextureOffset(30, 24).addBox(-1.0F, 3.5F, 2.0F, 2, 1, 1, 0.0F); // midRingSSE
		this.midRing.setTextureOffset(22, 22).addBox(-1.0F, 4.0F, -2.0F, 2, 1, 4, 0.0F); // midRingS
		this.midRing.setTextureOffset(20, 24).addBox(-1.0F, 3.5F, -3.0F, 2, 1, 1, 0.0F); // midRingSSW
		this.midRing.setTextureOffset(19, 22).addBox(-1.0F, 3.0F, -4.0F, 2, 1, 1, 0.0F); // midRingSW
		this.midRing.setTextureOffset(18, 20).addBox(-1.0F, 2.0F, -4.5F, 2, 1, 1, 0.0F); // midRingWSW
		this.midRing.setTextureOffset(17, 15).addBox(-1.0F, -2.0F, -5.0F, 2, 4, 1, 0.0F); // midRingW
		this.midRing.setTextureOffset(18, 13).addBox(-1.0F, -3.0F, -4.5F, 2, 1, 1, 0.0F); // midRingWNW
		this.midRing.setTextureOffset(19, 11).addBox(-1.0F, -4.0F, -4.0F, 2, 1, 1, 0.0F); // midRingNW
		this.midRing.setTextureOffset(20, 9).addBox(-1.0F, -4.5F, -3.0F, 2, 1, 1, 0.0F); // midRingNNW
		midRingInfo = new PartInfo(midRing);

		this.outerRingJoint = new ModelRenderer(this, 45, 2);
		this.outerRingJoint.setRotationPoint(0.0F, 16.0F, 0.0F);
		this.outerRingJoint.addBox(-1.0F, -7.5F, -2.5F, 0, 0, 0, 0.0F);
		this.outerRing = new ModelRenderer(this, 45, 2); // outerRingN
		this.outerRing.setRotationPoint(0.0F, 0.0F, 0.0F);
		this.outerRing.addBox(-1.0F, -7.5F, -2.5F, 2, 1, 5, 0.0F);
		this.outerRing.setTextureOffset(54, 4).addBox(-1.0F, -7.0F, 2.5F, 2, 1, 2, 0.0F); // outerRingNNE
		this.outerRing.setTextureOffset(55, 8).addBox(-1.0F, -6.5F, 4.5F, 2, 1, 1, 0.0F); // outerRingNEHi
		this.outerRing.setTextureOffset(56, 10).addBox(-1.0F, -5.5F, 5.3F, 2, 1, 1, 0.0F); // outerRingNELow
		this.outerRing.setTextureOffset(57, 12).addBox(-1.0F, -4.5F, 6.0F, 2, 2, 1, 0.0F); // outerRingENE
		this.outerRing.setTextureOffset(58, 15).addBox(-1.0F, -2.5F, 6.5F, 2, 5, 1, 0.0F); // outerRingE
		this.outerRing.setTextureOffset(57, 21).addBox(-1.0F, 2.5F, 6.0F, 2, 2, 1, 0.0F); // outerRingESE
		this.outerRing.setTextureOffset(56, 24).addBox(-1.0F, 4.5F, 5.3F, 2, 1, 1, 0.0F); // outerRingSEHi
		this.outerRing.setTextureOffset(55, 26).addBox(-1.0F, 5.5F, 4.5F, 2, 1, 1, 0.0F); // outerRingSELow
		this.outerRing.setTextureOffset(54, 28).addBox(-1.0F, 6.0F, 2.5F, 2, 1, 2, 0.0F); // outerRingSSE
		this.outerRing.setTextureOffset(45, 26).addBox(-1.0F, 6.5F, -2.5F, 2, 1, 5, 0.0F); // outerRingS
		this.outerRing.setTextureOffset(42, 28).addBox(-1.0F, 6.0F, -4.5F, 2, 1, 2, 0.0F); // outerRingSSW
		this.outerRing.setTextureOffset(43, 26).addBox(-1.0F, 5.5F, -5.5F, 2, 1, 1, 0.0F); // outerRingSWLow
		this.outerRing.setTextureOffset(42, 24).addBox(-1.0F, 4.5F, -6.3F, 2, 1, 1, 0.0F); // outerRingSWHi
		this.outerRing.setTextureOffset(41, 21).addBox(-1.0F, 2.5F, -7.0F, 2, 2, 1, 0.0F); // outerRingWSW
		this.outerRing.setTextureOffset(40, 15).addBox(-1.0F, -2.5F, -7.5F, 2, 5, 1, 0.0F); // outerRingW
		this.outerRing.setTextureOffset(41, 12).addBox(-1.0F, -4.5F, -7.0F, 2, 2, 1, 0.0F); // outerRingWNW
		this.outerRing.setTextureOffset(42, 10).addBox(-1.0F, -5.5F, -6.3F, 2, 1, 1, 0.0F); // outerRingNWLow
		this.outerRing.setTextureOffset(43, 8).addBox(-1.0F, -6.5F, -5.5F, 2, 1, 1, 0.0F); // outerRingNWHi
		this.outerRing.setTextureOffset(42, 4).addBox(-1.0F, -7.0F, -4.5F, 2, 1, 2, 0.0F); // outerRingNNW
		outerRingInfo = new PartInfo(outerRing);

		this.innerRingJoint.addChild(this.innerRing);
		this.midRingJoint.addChild(this.midRing);
		this.outerRingJoint.addChild(this.outerRing);

		animationDeployer = new AnimationDeployer(this);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) 
	{
		this.core.render(f5);
		this.innerRingJoint.render(f5);
		this.midRingJoint.render(f5);
		this.outerRingJoint.render(f5);
	}

	public void renderModel(float f, TileEntityXelNagaDynamo tileEntity)
	{
		animate(tileEntity);

		core.render(f);
		innerRingJoint.render(f);
		midRingJoint.render(f);
		outerRingJoint.render(f);
	}

	public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) 
	{
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void animate(TileEntityXelNagaDynamo tileEntity)
	{	
		/* Static references to array lengths in Entity class from Model class
		 * makes the glow/normal models not animate in sync. */
		this.animationDeployer.update((IAnimatedEntity)tileEntity);
		resetPartInfos();

		animateDynamo((TileEntityXelNagaDynamo)tileEntity);

		deployAnimations();
	}

	public void resetPartInfos()
	{
		innerRingInfo.resetNewAngles();
		midRingInfo.resetNewAngles();
		outerRingInfo.resetNewAngles();
	}

	public void animateDynamo(TileEntityXelNagaDynamo entity)
	{
		int i = 0;

		IdleAnimationClock currentIdleAnimationClock = entity.getDynamoAnimationClock(i);

		// + (float)Math.toRadians(45)
		float angleChangeX = 0;
		float angleChangeY = 0;
		float angleChangeZ = 0;

		angleChangeX += currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2;
		angleChangeY += currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2;
		angleChangeZ -= currentIdleAnimationClock.getPhaseDurationCoveredZ(0) * PI * 2;

		float newAngleX = innerRingInfo.getNewRotates().getX() + angleChangeX;
		float newAngleY = innerRingInfo.getNewRotates().getY() - angleChangeY;
		float newAngleZ = innerRingInfo.getNewRotates().getZ() + angleChangeZ;

		innerRingInfo.setNewRotatesWithVector(new Vector3f(newAngleX, newAngleY, newAngleZ));
		
		i++;

		currentIdleAnimationClock = entity.getDynamoAnimationClock(i);

		// + (float)Math.toRadians(45)
		angleChangeX = 0;
		angleChangeY = 0;
		angleChangeZ = 0;

		angleChangeX -= currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2;
		angleChangeY -= currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2;
		angleChangeZ += currentIdleAnimationClock.getPhaseDurationCoveredZ(0) * PI * 2;

		newAngleX = midRingInfo.getDefaultRotates().getX() + angleChangeX;
		newAngleY = midRingInfo.getDefaultRotates().getY() + angleChangeY;
		newAngleZ = midRingInfo.getDefaultRotates().getZ() + angleChangeZ;

		midRingInfo.setNewRotatesWithVector(new Vector3f(newAngleX, newAngleY, newAngleZ));

		i++;

		currentIdleAnimationClock = entity.getDynamoAnimationClock(i);

		// + (float)Math.toRadians(45)
		angleChangeX = 0;
		angleChangeY = 0;
		angleChangeZ = 0;

		angleChangeX += currentIdleAnimationClock.getPhaseDurationCoveredX(0) * PI * 2;
		angleChangeY -= currentIdleAnimationClock.getPhaseDurationCoveredY(0) * PI * 2;
		angleChangeZ += currentIdleAnimationClock.getPhaseDurationCoveredZ(0) * PI * 2;

		newAngleX = outerRingInfo.getDefaultRotates().getX() + angleChangeX;
		newAngleY = outerRingInfo.getDefaultRotates().getY() + angleChangeY;
		newAngleZ = outerRingInfo.getDefaultRotates().getZ() + angleChangeZ;

		outerRingInfo.setNewRotatesWithVector(new Vector3f(newAngleX, newAngleY, newAngleZ));
	}

	public void deployAnimations()
	{
		this.animationDeployer.rotate(innerRing, innerRingInfo.getNewRotates());
		this.animationDeployer.rotate(midRing, midRingInfo.getNewRotates());
		this.animationDeployer.rotate(outerRing, outerRingInfo.getNewRotates());

		this.animationDeployer.applyChanges();
	}
}
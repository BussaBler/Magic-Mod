package net.bussab.MagicMod.item.armour.model;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.decoration.ArmorStand;

public class BaseArmourModel extends HumanoidModel<LivingEntity> {

    private final EquipmentSlot slot;

    public BaseArmourModel(ModelPart pRoot, EquipmentSlot pSlot) {
        super(pRoot);
        this.slot = pSlot;
    }
    
    @Override
	public void setupAnim(LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		if (entity instanceof ArmorStand entityarmorstand) {
			this.head.xRot = 0.017453292F * entityarmorstand.getHeadPose().getX();
			this.head.yRot = 0.017453292F * entityarmorstand.getHeadPose().getY();
			this.head.zRot = 0.017453292F * entityarmorstand.getHeadPose().getZ();
			this.head.setPos(0.0F, 1.0F, 0.0F);
			this.body.xRot = 0.017453292F * entityarmorstand.getBodyPose().getX();
			this.body.yRot = 0.017453292F * entityarmorstand.getBodyPose().getY();
			this.body.zRot = 0.017453292F * entityarmorstand.getBodyPose().getZ();
			this.leftArm.xRot = 0.017453292F * entityarmorstand.getLeftArmPose().getX();
			this.leftArm.yRot = 0.017453292F * entityarmorstand.getLeftArmPose().getY();
			this.leftArm.zRot = 0.017453292F * entityarmorstand.getLeftArmPose().getZ();
			this.rightArm.xRot = 0.017453292F * entityarmorstand.getRightArmPose().getX();
			this.rightArm.yRot = 0.017453292F * entityarmorstand.getRightArmPose().getY();
			this.rightArm.zRot = 0.017453292F * entityarmorstand.getRightArmPose().getZ();
			this.leftLeg.xRot = 0.017453292F * entityarmorstand.getLeftLegPose().getX();
			this.leftLeg.yRot = 0.017453292F * entityarmorstand.getLeftLegPose().getY();
			this.leftLeg.zRot = 0.017453292F * entityarmorstand.getLeftLegPose().getZ();
			this.leftLeg.setPos(1.9F, 11.0F, 0.0F);
			this.rightLeg.xRot = 0.017453292F * entityarmorstand.getRightLegPose().getX();
			this.rightLeg.yRot = 0.017453292F * entityarmorstand.getRightLegPose().getY();
			this.rightLeg.zRot = 0.017453292F * entityarmorstand.getRightLegPose().getZ();
			this.rightLeg.setPos(-1.9F, 11.0F, 0.0F);
			this.hat.copyFrom(this.head);
		} else {
			super.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
		}
	}
	@Override
	public void renderToBuffer(PoseStack ms, VertexConsumer buffer, int light, int overlay, float r, float g, float b, float a) {
		setPartVisibility(slot);
		super.renderToBuffer(ms, buffer, light, overlay, r, g, b, a);
	}

	private void setPartVisibility(EquipmentSlot slot) {
		setAllVisible(false);
		switch (slot.getName()) {
			case "head" -> {
				head.visible = true;
				hat.visible = true;
			}
			case "chest" -> {
				body.visible = true;
				rightArm.visible = true;
				leftArm.visible = true;
			}
			case "legs" -> {
				body.visible = true;
				rightLeg.visible = true;
				leftLeg.visible = true;
			}
			case "feet" -> {
				rightLeg.visible = true;
				leftLeg.visible = true;
			}
		}
	}
}

package net.bussab.MagicMod.item.armour.model;

import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.world.entity.EquipmentSlot;

public class GogglesModel extends BaseArmourModel {

    public GogglesModel(ModelPart pRoot) {
        super(pRoot, EquipmentSlot.HEAD);
         
    }
    
    public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = HumanoidModel.createMesh(CubeDeformation.NONE, 0.0F);
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition head = partdefinition.addOrReplaceChild("head", CubeListBuilder.create().texOffs(0, 0).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.0F))
		.texOffs(0, 16).addBox(-7.0F, -8.0F, -4.5F, 14.0F, 8.0F, 1.0F, new CubeDeformation(-2.5f, -1f, 0)), PartPose.offset(0.0F, 24.0F, 0.0F));
        partdefinition.addOrReplaceChild("hat", CubeListBuilder.create(), PartPose.ZERO);

		return LayerDefinition.create(meshdefinition, 32, 32);
	}
}

package net.bussab.MagicMod.block.entities.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.bussab.MagicMod.MagicMod;
import net.bussab.MagicMod.block.entities.NitorEntity;
import net.bussab.MagicMod.particles.ModParticles;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LightLayer;

public class NitorBERenderer implements BlockEntityRenderer<NitorEntity> {

    ResourceLocation base = new ResourceLocation(MagicMod.MOD_ID, "block/fire_down");
    ResourceLocation swirl = new ResourceLocation(MagicMod.MOD_ID, "block/fire_swirl");




    public NitorBERenderer (BlockEntityRendererProvider.Context pContext){

    }

    


    @Override
    public void render(NitorEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer,
            int pPackedLight, int pPackedOverlay) {
        
        
        
        Level pLevel = pBlockEntity.getLevel();
        RandomSource pRandom = pLevel.getRandom();
        BlockPos pPos = pBlockEntity.getBlockPos();
        
        double rand = Math.random();
        pLevel.addParticle(ModParticles.NITOR_FLAMES.get(), pPos.getX()+0.5, pPos.getY()+0.5, pPos.getZ()+0.5, Math.sin(2*Math.PI*rand)*0.011, Math.abs(pRandom.nextGaussian()*0.019), Math.cos(2*Math.PI*rand)*0.011);
        
        
       

    }

    private int getLightLevel(Level pLevel, BlockPos pPos){
        int bLight = pLevel.getBrightness(LightLayer.BLOCK, pPos);
        int sLight = pLevel.getBrightness(LightLayer.SKY, pPos);
        return LightTexture.pack(bLight, sLight);
    }

    
    
}

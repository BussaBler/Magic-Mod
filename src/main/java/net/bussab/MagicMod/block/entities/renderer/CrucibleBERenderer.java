package net.bussab.MagicMod.block.entities.renderer;

import com.mojang.blaze3d.vertex.PoseStack;

import net.bussab.MagicMod.block.ModBlocks;
import net.bussab.MagicMod.block.entities.CrucibleEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.data.ModelData;

public class CrucibleBERenderer implements BlockEntityRenderer<CrucibleEntity> {


    
    

    public CrucibleBERenderer (BlockEntityRendererProvider.Context pContext){
       
       




    }

    
    



    @Override
    public void render(CrucibleEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer,
            int pPackedLight, int pPackedOverlay) {

        BlockRenderDispatcher blockRenderDispatcher = Minecraft.getInstance().getBlockRenderer();
        BlockState blockState = ModBlocks.CUSTOM_WATER.get().defaultBlockState();
        

        pPoseStack.pushPose();
        pPoseStack.scale(0.9375f, 0.9375f, 0.9375f);
        
        
        blockRenderDispatcher.renderSingleBlock(blockState, pPoseStack, pBuffer, pPackedLight, pPackedOverlay, ModelData.EMPTY, RenderType.translucent());
        pPoseStack.popPose();
        
    }






    
        

       

        




}   

    
     
    

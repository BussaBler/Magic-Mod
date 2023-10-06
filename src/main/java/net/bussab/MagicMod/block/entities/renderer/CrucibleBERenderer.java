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
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.RenderShape;
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
        int fluidHeight = pBlockEntity.getTank();
        double correctFluidHeight =  fluidHeight*0.0006875 - 0.6875;
        

        pPoseStack.pushPose();
        pPoseStack.scale(0.9375f, 0.9375f, 0.9375f);
        pPoseStack.translate(0, correctFluidHeight, 0);
       
        renderSingleBlock(blockRenderDispatcher, blockState, pPoseStack, pBuffer, pPackedLight, pPackedOverlay, ModelData.EMPTY, RenderType.translucent());
        pPoseStack.popPose();
        
        
    }

     public void renderSingleBlock(BlockRenderDispatcher pDispatcher,BlockState pState, PoseStack pPoseStack, MultiBufferSource pBufferSource, int pPackedLight, int pPackedOverlay, net.minecraftforge.client.model.data.ModelData modelData, net.minecraft.client.renderer.RenderType renderType) {
      RenderShape rendershape = pState.getRenderShape();
      
      if (rendershape != RenderShape.INVISIBLE) {
         switch (rendershape) {
            case MODEL:
               BakedModel bakedmodel = pDispatcher.getBlockModel(pState);
               int i = 0x3F76E4; //Shade of blue for minecraft's water
               float f = (float)(i >> 16 & 255) / 255.0F;
               float f1 = (float)(i >> 8 & 255) / 255.0F;
               float f2 = (float)(i & 255) / 255.0F;
               for (net.minecraft.client.renderer.RenderType rt : bakedmodel.getRenderTypes(pState, RandomSource.create(42), modelData))
                  pDispatcher.getModelRenderer().renderModel(pPoseStack.last(), pBufferSource.getBuffer(renderType != null ? renderType : net.minecraftforge.client.RenderTypeHelper.getEntityRenderType(rt, false)), pState, bakedmodel, f, f1, f2, pPackedLight, pPackedOverlay, modelData, rt);
               break;
            case ENTITYBLOCK_ANIMATED:
            ItemStack stack = new ItemStack(pState.getBlock());
            net.minecraftforge.client.extensions.common.IClientItemExtensions.of(stack).getCustomRenderer().renderByItem(stack, ItemDisplayContext.NONE, pPoseStack, pBufferSource, pPackedLight, pPackedOverlay);
        }

      }
   }





    
        

       

        




}   

    
     
    

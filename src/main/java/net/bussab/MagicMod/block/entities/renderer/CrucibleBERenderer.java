package net.bussab.MagicMod.block.entities.renderer;

import org.joml.Math;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;

import net.bussab.MagicMod.block.entities.CrucibleEntity;
import net.bussab.MagicMod.essentia.Essentia;
import net.bussab.MagicMod.gui.HoverTextRender;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.network.chat.Component;
import net.minecraft.util.RandomSource;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.client.extensions.common.IClientFluidTypeExtensions;

public class CrucibleBERenderer implements BlockEntityRenderer<CrucibleEntity> {
    
    
        
    

    public CrucibleBERenderer (BlockEntityRendererProvider.Context pContext){
        
    }
    
    
    @Override
    public void render(CrucibleEntity pBlockEntity, float pPartialTick, PoseStack pPoseStack, MultiBufferSource pBuffer,
            int pPackedLight, int pPackedOverlay) {
        
        
        if(pBlockEntity.getTank() > 0 ){
            int fluidHeight = pBlockEntity.getTank();
            double correctFluidHeight =  fluidHeight*0.0006875 - 0.6875;
            

            pPoseStack.pushPose();
            pPoseStack.scale(1, 0.9375f, 1);
            pPoseStack.translate(0, correctFluidHeight, 0);
        
            
            

            Fluid f = pBlockEntity.FLUID_TANK.getFluid().getFluid();
            if (f != Fluids.EMPTY){
                
                IClientFluidTypeExtensions fluidType = IClientFluidTypeExtensions.of(f);
                
                TextureAtlasSprite sprite = Minecraft.getInstance().getTextureAtlas(InventoryMenu.BLOCK_ATLAS).apply(fluidType.getStillTexture(f.defaultFluidState(), pBlockEntity.getLevel(), pBlockEntity.getBlockPos()));
                
                float minU = sprite.getU0();
                
                float minV = sprite.getV0();
               
                int waterColor = fluidType.getTintColor(f.defaultFluidState(), pBlockEntity.getLevel(), pBlockEntity.getBlockPos());
                float red = (waterColor >> 16 & 255) / 255F;
                float green = (waterColor >> 8 & 255) / 255F;
                float blue = (waterColor & 255) / 255F;

                VertexConsumer vertexConsumer = pBuffer.getBuffer(RenderType.translucent());
                
                Matrix4f m = pPoseStack.last().pose();
                vertexConsumer.vertex(m, (float)0, (float)1, (float)0).color(red, green, blue, 1f).uv(sprite.getU1(), minV).uv2(pPackedLight).normal(0, 1f, 0).endVertex();
                vertexConsumer.vertex(m, (float)0, (float)1, (float)(1)).color(red, green, blue, 1f).uv(minU, minV).uv2(pPackedLight).normal(0, 1f, 0).endVertex();
                vertexConsumer.vertex(m, (float)(1), (float)1, (float)(1)).color(red, green, blue, 1f).uv(minU, sprite.getV1()).uv2(pPackedLight).normal(0, 1f, 0).endVertex();
                vertexConsumer.vertex(m, (float)(1), (float)1, (float)0).color(red, green, blue, 1f).uv(sprite.getU1(), sprite.getV1()).uv2(pPackedLight).normal(0, 1f, 0).endVertex();
                pPoseStack.popPose();
            }
        }
        
        if (HoverTextRender.hovering == true && !pBlockEntity.getEssentiaList().isEmpty()){
            Font font = Minecraft.getInstance().font;
            
            Vec3 blockVec = new Vec3(pBlockEntity.getBlockPos().getX() + 0.5, 0.5, pBlockEntity.getBlockPos().getZ() + 0.5);
            Vec3 playerVec = new Vec3(Minecraft.getInstance().player.getX(), Minecraft.getInstance().player.getY(), Minecraft.getInstance().player.getZ());
            Vec3 toPlayer = playerVec.subtract(blockVec).normalize(); // Direction from block to player

            // Calculate the rotation angle based on the direction vector
            float yaw = (float) Math.atan2(-toPlayer.x, toPlayer.z);
            
            int length = pBlockEntity.getEssentiaList().getEssentias().length;
            float i = (float)-(Math.floor(length/2))*0.2f;
            if (length%2==0) {i+=0.1;}
            
            

            for (Essentia E : pBlockEntity.getEssentiaList().getEssentias()) {

                Component Comp = Component.literal(String.valueOf(pBlockEntity.getEssentiaList().getAmount(E)));
                //System.out.println(E.getName()+" "+pBlockEntity.getEssentiaList().getAmount(E));
                
                pPoseStack.pushPose();
                pPoseStack.translate(0.5 , 1.5, 0.5); // Adjust the translation as needed
                pPoseStack.translate(i*Math.cos(yaw), 0, (i)*Math.sin(yaw));
                pPoseStack.scale(0.2F, 0.2F, 0.2F);
                
                
                pPoseStack.mulPose(Axis.YP.rotation(-yaw)); // Rotate based on yaw
                
                
                ItemStack II = new ItemStack(Essentia.SymbolChart.get(E));
                

                ItemRenderer IR = Minecraft.getInstance().getItemRenderer();
                
                IR.renderStatic(II, ItemDisplayContext.GUI, pPackedLight, OverlayTexture.NO_OVERLAY, pPoseStack, pBuffer, pBlockEntity.getLevel(), 1);
                i+=0.2;

                pPoseStack.translate(0.1 , 1.5, 0.3); // Adjust the translation as needed
                
                pPoseStack.mulPose(new Quaternionf(1, 0, 0, 0));
                pPoseStack.scale(0.07F, 0.07F, 0.07F);

                
                float f1 = Minecraft.getInstance().options.getBackgroundOpacity(0.25F);
                float f2 = (float)(-font.width(Comp) / 2);
                Matrix4f matrix4f = pPoseStack.last().pose();

                font.drawInBatch(Comp, f2, 0f, 0xFFFFFF, false, matrix4f, pBuffer, Font.DisplayMode.NORMAL, (int)f1, pPackedLight);
                


                pPoseStack.popPose();
            }

            
        
        }
        
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
            case INVISIBLE:
        }

      }
   }





    
        

       

        




}   

    
     
    

package net.bussab.MagicMod.events;

import org.joml.Matrix4f;

import com.mojang.blaze3d.platform.Lighting;
import com.mojang.blaze3d.vertex.PoseStack;

import net.bussab.MagicMod.MagicMod;
import net.bussab.MagicMod.essentia.Essentia;
import net.bussab.MagicMod.essentia.EssentiaRegister;
import net.bussab.MagicMod.item.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.screens.inventory.tooltip.TooltipRenderUtil;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.level.Level;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MagicMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ForgeEvents {

    private static boolean rendered = false;

    @SubscribeEvent
    public static void onToolTipRender(RenderTooltipEvent pEvent){
        
            if (EssentiaRegister.getObjectTag(pEvent.getItemStack())!=null && !rendered && Minecraft.getInstance().player.getItemBySlot(EquipmentSlot.HEAD).getItem() == ModItems.GOGGLES.get()){
                
                PoseStack pStack = pEvent.getGraphics().pose();
                int X = pEvent.getX()-50;
                int Y = pEvent.getY()-10;
                

                for (Essentia E : EssentiaRegister.getObjectTag(pEvent.getItemStack()).getEssentias()){
                    BakedModel bakedmodel = Minecraft.getInstance().getItemRenderer().
                    getModel(Essentia.SymbolChart.get(E).getDefaultInstance(), ((Level)Minecraft.getInstance().level), ((LivingEntity)Minecraft.getInstance().player), 0);
                    pStack.pushPose();
                    pStack.translate((float)(X + 8), (float)(Y + 8), (float)(350));
                    pStack.mulPoseMatrix((new Matrix4f()).scaling(1.0F, -1.0F, 1.0F));
                    pStack.scale(16.0F, 16.0F, 16.0F);
                    Lighting.setupForFlatItems();
                    Minecraft.getInstance().getItemRenderer()
                    .render(Essentia.SymbolChart.get(E).getDefaultInstance(), ItemDisplayContext.GUI, false,  pStack, pEvent.getGraphics().bufferSource(), LightTexture.FULL_BRIGHT, OverlayTexture.NO_OVERLAY, bakedmodel);
                    X-=16;
                    pStack.popPose();

                    String Comp = String.valueOf(EssentiaRegister.getObjectTag(pEvent.getItemStack()).getAmount(E));
                    float width = Comp.length()*((float)(-2.5));
                    pStack.pushPose();
                    
                    pStack.translate(0, 0, 350f);
                    
                    Minecraft.getInstance().font.drawInBatch(Comp, ((float)X+8+width), ((float)Y+4), 0xFFFFFF, false, pStack.last().pose(), pEvent.getGraphics().bufferSource(), Font.DisplayMode.NORMAL, 0, 15728880);
                    
                    pStack.popPose();

                    X-=14-width;
                }
                rendered=true;
                TooltipRenderUtil.renderTooltipBackground(pEvent.getGraphics(), X+16, Y, pEvent.getX()-50-X, 16, 349);

            }
            else rendered=false;
        }

}

package net.bussab.MagicMod.particles;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class CrucibleBubble extends TextureSheetParticle {

    protected CrucibleBubble(ClientLevel pLevel, double pX, double pY, double pZ,SpriteSet pSpriteSet, double pXSpeed, double pYSpeed,double pZSpeed){
        super(pLevel, pX, pY, pZ);
      this.setSize(0.02F, 0.02F);
      this.quadSize *= this.random.nextFloat() * 0.6F + 0.2F;
      this.xd = pXSpeed * (double)0.2F + (Math.random() * 2.0D - 1.0D) * (double)0.02F;
      this.yd = pYSpeed * (double)0.2F + (Math.random() * 2.0D - 1.0D) * (double)0.02F;
      this.zd = pZSpeed * (double)0.2F + (Math.random() * 2.0D - 1.0D) * (double)0.02F;
      this.lifetime = (int)(20.0D);
      this.setSpriteFromAge(pSpriteSet);
   }

   public void tick() {
      this.xo = this.x;
      this.yo = this.y;
      this.zo = this.z;
      if (this.lifetime-- <= 0) {
         this.remove();
      } else {
         this.yd += 0.002D;
         this.move(this.xd, this.yd, this.zd);
         this.xd *= (double)0.85F;
         this.yd *= (double)0.85F;
         this.zd *= (double)0.85F;
         

      }
   }





    

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_TRANSLUCENT;
    }

    @OnlyIn(Dist.CLIENT)
   public static class Provider implements ParticleProvider<SimpleParticleType> {
      private final SpriteSet sprite;

      public Provider(SpriteSet pSprites) {
         this.sprite = pSprites;
      }

    @Override
    public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
       
        
        return new CrucibleBubble(pLevel, pX, pY, pZ, sprite, pXSpeed, pYSpeed, pZSpeed);
      }
    
    }
}

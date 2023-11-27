package net.bussab.MagicMod.particles;

import net.bussab.MagicMod.block.Nitor;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleProvider;
import net.minecraft.client.particle.ParticleRenderType;
import net.minecraft.client.particle.SpriteSet;
import net.minecraft.client.particle.TextureSheetParticle;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class NitorFlames extends TextureSheetParticle {
    private double redCorrection;
    private double greenCorrection;
    double blueCorrection;

    protected NitorFlames(ClientLevel pLevel, double pX, double pY, double pZ, SpriteSet pSprite, double pXSpeed, double pYSpeed, double pZSpeed) {
        super(pLevel, pX, pY, pZ);
        this.setSpriteFromAge(pSprite);
        this.setSize(0.4f, 0.4f);
        this.hasPhysics = false;
        this.friction = 0.96F;
        this.xd = this.xd * (double)0.01F + pXSpeed;
        this.yd = this.yd * (double)0.01F + pYSpeed;
        this.zd = this.zd * (double)0.01F + pZSpeed;
        this.x += (double)((this.random.nextFloat() - this.random.nextFloat()) * 0.05F);
        this.y += (double)((this.random.nextFloat() - this.random.nextFloat()) * 0.05F);
        this.z += (double)((this.random.nextFloat() - this.random.nextFloat()) * 0.05F);
        this.lifetime = (int)(8.0D / (Math.random() * 0.7D + 0.2D)) + 2;
        
        BlockPos pPos = new BlockPos((int)(pX-0.5), (int)pY, (int)(pZ-0.5));
        if (pLevel.getBlockEntity(pPos) != null){
        Nitor pNitor = ((Nitor)pLevel.getBlockEntity(pPos).getBlockState().getBlock());
        setColor(1f, 1f, 1f);
        float time = 1f/lifetime;
        redCorrection = Math.pow(pNitor.getRed()/255, time) ;
        greenCorrection = Math.pow(pNitor.getGreen()/255, time);
        blueCorrection = Math.pow(pNitor.getBlue()/255, time);
        }
        

    
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }
    
    @Override
    public void tick(){
        this.xo = this.x;
        this.yo = this.y;
        this.zo = this.z;
        if (this.lifetime-- <=0){
            remove();
        }
        
        else {
            double progress = 1.0 - (double) this.lifetime / (double) this.lifetime;

            // Adjust the trajectory to create a half water drop shape
            double yOffset = Math.sin(progress * Math.PI) * 0.4; // Adjust the multiplier for desired height
            move(xd, yd + yOffset, zd);
            this.gCol *=greenCorrection;
            this.bCol *=blueCorrection;
            this.rCol *=redCorrection;
            // Apply some damping to the horizontal movement
            this.xd *= 0.97;
            this.zd *= 0.97;
        }
        
    }

    

    @OnlyIn(Dist.CLIENT)
    public static class Provider implements ParticleProvider<SimpleParticleType> {
        private final SpriteSet sprite;

        public Provider(SpriteSet pSprites) {
            this.sprite = pSprites;
        }

    @Override
    public Particle createParticle(SimpleParticleType pType, ClientLevel pLevel, double pX, double pY, double pZ, double pXSpeed, double pYSpeed, double pZSpeed) {
        return new NitorFlames(pLevel, pX, pY, pZ,sprite, pXSpeed, pYSpeed, pZSpeed);
    }
        

    }
}

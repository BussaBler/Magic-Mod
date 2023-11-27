package net.bussab.MagicMod.particles;

import net.bussab.MagicMod.MagicMod;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticles {
    
    public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, MagicMod.MOD_ID);

    public static final RegistryObject<SimpleParticleType> CRUCIBLE_BUBBLE = PARTICLE_TYPES.register("crucible_bubble", ()-> new SimpleParticleType(true));
    
    public static final RegistryObject<SimpleParticleType> NITOR_FLAMES = PARTICLE_TYPES.register("nitor_flames", ()-> new SimpleParticleType(true));

    public static void register(IEventBus  pEventBus){
        PARTICLE_TYPES.register(pEventBus);
    }

}

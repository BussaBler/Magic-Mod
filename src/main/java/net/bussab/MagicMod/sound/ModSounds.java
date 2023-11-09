package net.bussab.MagicMod.sound;

import net.bussab.MagicMod.MagicMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, MagicMod.MOD_ID);


    public static final RegistryObject<SoundEvent> CRUCIBLE_BUBBLE = registerSoundEvent("crucible_bubbles");
    public static final RegistryObject<SoundEvent> POOF_SOUND = registerSoundEvent("poof_sound");


    public static void register(IEventBus pEventBus){
        SOUND_EVENTS.register(pEventBus);
    }


    private static RegistryObject<SoundEvent> registerSoundEvent(String pName) {
        ResourceLocation ID = new ResourceLocation(MagicMod.MOD_ID, pName);
        return SOUND_EVENTS.register(pName, ()-> SoundEvent.createVariableRangeEvent(ID));
    }


}

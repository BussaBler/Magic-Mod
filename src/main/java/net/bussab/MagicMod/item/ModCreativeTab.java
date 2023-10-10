package net.bussab.MagicMod.item;

import net.bussab.MagicMod.MagicMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTab {
    
    public static final DeferredRegister<CreativeModeTab> CREATIVE_TAB = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MagicMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MAGIC_MOD_TAB = CREATIVE_TAB.register("magic_mod_tab", ()-> CreativeModeTab.builder()
    .icon(()-> new ItemStack(ModItems.FIRE_CRYSTAL.get())).title(Component.translatable("creativetab.magic_mod")).displayItems((pParameters, pOutput)-> {


        pOutput.accept(ModItems.FIRE_CRYSTAL.get());
        pOutput.accept(ModItems.WATER_CRYSTAL.get());
        pOutput.accept(ModItems.EARTH_CRYSTAL.get());
        pOutput.accept(ModItems.AIR_CRYSTAL.get());
        pOutput.accept(ModItems.DARK_CRYSTAL.get());
        pOutput.accept(ModItems.LIGHT_CRYSTAL.get());
        pOutput.accept(ModItems.MANA_CRYSTAL.get());
        pOutput.accept(ModItems.BLANK_SHARD.get());
        pOutput.accept(ModItems.FIRE_SHARD.get());
        pOutput.accept(ModItems.WATER_SHARD.get());
        pOutput.accept(ModItems.EARTH_SHARD.get());
        pOutput.accept(ModItems.AIR_SHARD.get());
        pOutput.accept(ModItems.ENTROPY_SHARD.get());
        pOutput.accept(ModItems.ORDER_SHARD.get());
        pOutput.accept(ModItems.MANA_SHARD.get());
        pOutput.accept(ModItems.VOID_SHARD.get());
        pOutput.accept(ModItems.LIGHT_SHARD.get());
        pOutput.accept(ModItems.MOTION_SHARD.get());
        pOutput.accept(ModItems.COLD_SHARD.get());
        pOutput.accept(ModItems.CRYSTAL_SHARD.get());
        pOutput.accept(ModItems.METAL_SHARD.get());
        pOutput.accept(ModItems.LIFE_SHARD.get());
        pOutput.accept(ModItems.DEATH_SHARD.get());
        pOutput.accept(ModItems.ENERGY_SHARD.get());
        pOutput.accept(ModItems.EXCHANGE_SHARD.get());
        pOutput.accept(ModItems.MAGIC_SHARD.get());
        pOutput.accept(ModItems.AURA_SHARD.get());
        pOutput.accept(ModItems.ALCHEMY_SHARD.get());
        pOutput.accept(ModItems.FLUX_SHARD.get());
        pOutput.accept(ModItems.DARKNESS_SHARD.get());
        pOutput.accept(ModItems.ELDRITCH_SHARD.get());
        pOutput.accept(ModItems.FLIGHT_SHARD.get());
        pOutput.accept(ModItems.PLANT_SHARD.get());
        pOutput.accept(ModItems.TOOL_SHARD.get());
        pOutput.accept(ModItems.CRAFT_SHARD.get());
        pOutput.accept(ModItems.MECHANISM_SHARD.get());
        pOutput.accept(ModItems.TRAP_SHARD.get());
        pOutput.accept(ModItems.SOUL_SHARD.get());
        pOutput.accept(ModItems.MIND_SHARD.get());
        pOutput.accept(ModItems.SENSES_SHARD.get());
        pOutput.accept(ModItems.AVERSION_SHARD.get());
        pOutput.accept(ModItems.PROTECT_SHARD.get());
        pOutput.accept(ModItems.DESIRE_SHARD.get());
        pOutput.accept(ModItems.UNDEAD_SHARD.get());
        pOutput.accept(ModItems.BEAST_SHARD.get());
        pOutput.accept(ModItems.MAN_SHARD.get());

        
        pOutput.accept(ModItems.GOGGLES.get());



        pOutput.accept(ModItems.SALIS_MUNDUS.get());



    })
    .build());

    public static void register(IEventBus pEventBus){
        CREATIVE_TAB.register(pEventBus);
    }
}

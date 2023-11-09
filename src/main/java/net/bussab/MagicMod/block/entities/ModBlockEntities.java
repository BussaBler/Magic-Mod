package net.bussab.MagicMod.block.entities;

import net.bussab.MagicMod.MagicMod;
import net.bussab.MagicMod.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    

    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, MagicMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<CrucibleEntity>> CRUCIBLE_BE = BLOCK_ENTITIES.register("crucible_block_entity", ()-> BlockEntityType.Builder.of(CrucibleEntity::new, ModBlocks.CRUCIBLE.get()).build(null));
    public static final RegistryObject<BlockEntityType<NitorEntity>> NITOR_BE = BLOCK_ENTITIES.register("nitor_block_entity", ()-> BlockEntityType.Builder.of(NitorEntity::new, ModBlocks.NITOR.get()).build(null));

    public static void register(IEventBus pEventBus){
        BLOCK_ENTITIES.register(pEventBus);
    }
}

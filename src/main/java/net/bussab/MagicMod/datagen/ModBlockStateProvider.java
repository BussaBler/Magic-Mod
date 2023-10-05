package net.bussab.MagicMod.datagen;

import net.bussab.MagicMod.MagicMod;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MagicMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        
      
    }

    private void blockWithItem(RegistryObject<Block> pBlock){
        simpleBlockWithItem(pBlock.get(), cubeAll(pBlock.get()));
    }
    
}

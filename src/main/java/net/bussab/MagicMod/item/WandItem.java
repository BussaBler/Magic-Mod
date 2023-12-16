package net.bussab.MagicMod.item;

import net.bussab.MagicMod.spells.Spell;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

public class WandItem extends Item {

    public WandItem(Properties pProperties) {
        super(pProperties);
    }


    public void setSpeel(ItemStack pStack, Spell pSpell){
        
        CompoundTag spell = new CompoundTag();
        spell.putString("wand.spell", pSpell.name);
        pStack.setTag(spell);
    }

    
}

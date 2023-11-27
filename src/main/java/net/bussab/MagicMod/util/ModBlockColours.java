package net.bussab.MagicMod.util;

import net.minecraft.client.color.item.ItemColor;
import net.minecraft.world.item.ItemStack;

public class ModBlockColours implements ItemColor {

    @Override
    public int getColor(ItemStack pStack, int pTint) {
       
        switch (pStack.getItem().toString()) {
            case "nitor":
                return 0xFF7800;
                
            case "purple_nitor":
                return 0x6F00FF;

            case "green_nitor":
                return 0x2bff39;
        
            case "blue_nitor":
                return 0x0900FF;

            case "pink_nitor":
                return 0xFF47E5;
            
            case "red_nitor":
                return 0xFF0000;
            
            case "black_nitor":
                return 0x13002B;

            case "white_nitor":
                return 0xFFFFFF;

            default:
                return 0xFFFFFF;
        }
        
    }
    
}

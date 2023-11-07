package net.bussab.MagicMod.essentia;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;

public class ConfigEssentia {
    
    public static void postInit(){
        registerItemEssentia();
    }


    private static void registerItemEssentia(){
        
        //BLOCKS
        EssentiaRegister.registerObjectTag("logs", new EssentiaList().add(Essentia.PLANT, 10));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.ACTIVATOR_RAIL), new EssentiaList().add(Essentia.METAL, 15).add(Essentia.ENERGY, 10).add(Essentia.DESIRE, 2));
        EssentiaRegister.registerObjectTag("flowers", new EssentiaList().add(Essentia.PLANT, 5));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.AMETHYST_BLOCK), new EssentiaList().add(Essentia.EARTH, 10).add(Essentia.CRYSTAL, 10));
        EssentiaRegister.registerObjectTag("stone", new EssentiaList().add(Essentia.EARTH, 5).add(Essentia.ENTROPY, 5));
        EssentiaRegister.registerObjectTag("anvil", new EssentiaList().add(Essentia.METAL, 60));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.BAMBOO), new EssentiaList().add(Essentia.PLANT, 7));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.BARREL), new EssentiaList().add(Essentia.PLANT, 20));
        EssentiaRegister.registerObjectTag("netherrack", new EssentiaList().add(Essentia.FIRE, 5).add(Essentia.ENTROPY, 5));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.BLACKSTONE), new EssentiaList().add(Essentia.FIRE, 5).add(Essentia.ENTROPY, 5));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.BEACON), new EssentiaList().add(Essentia.AURA, 10).add(Essentia.MAGIC, 10).add(Essentia.EXCHANGE, 10));
        EssentiaRegister.registerObjectTag("beds", new EssentiaList().add(Essentia.MAN, 10));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.BEDROCK), new EssentiaList().add(Essentia.VOID, 25).add(Essentia.ENTROPY, 25).add(Essentia.EARTH, 25).add(Essentia.DARKNESS, 25));
        EssentiaRegister.registerObjectTag("beehives", new EssentiaList().add(Essentia.PLANT, 5).add(Essentia.BEAST, 10));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.BELL), new EssentiaList().add(Essentia.METAL, 15).add(Essentia.DESIRE, 5));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.BIG_DRIPLEAF), new EssentiaList().add(Essentia.PLANT, 10));
        EssentiaRegister.registerObjectTag("ice", new EssentiaList().add(Essentia.COLD, 15));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.BONE_BLOCK), new EssentiaList().add(Essentia.UNDEAD, 10).add(Essentia.DEATH, 10));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.BOOKSHELF), new EssentiaList().add(Essentia.MIND, 15));
        EssentiaRegister.registerObjectTag("coral_plants", new EssentiaList().add(Essentia.WATER, 5).add(Essentia.EARTH, 5));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.BREWING_STAND), new EssentiaList().add(Essentia.CRAFT, 15).add(Essentia.ALCHEMY, 20));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.BRICKS), new EssentiaList().add(Essentia.FIRE, 2));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.BROWN_MUSHROOM_BLOCK), new EssentiaList().add(Essentia.DARKNESS, 5).add(Essentia.PLANT, 2).add(Essentia.EARTH, 2));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.RED_MUSHROOM_BLOCK), new EssentiaList().add(Essentia.DARKNESS, 5).add(Essentia.PLANT, 2).add(Essentia.FIRE, 2));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.BROWN_MUSHROOM), new EssentiaList().add(Essentia.DARKNESS, 5).add(Essentia.PLANT, 2).add(Essentia.EARTH, 2));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.RED_MUSHROOM), new EssentiaList().add(Essentia.DARKNESS, 5).add(Essentia.PLANT, 2).add(Essentia.FIRE, 2));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.CACTUS), new EssentiaList().add(Essentia.PLANT, 5).add(Essentia.WATER, 4).add(Essentia.AVERSION, 1));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.CAMPFIRE), new EssentiaList().add(Essentia.FIRE, 10).add(Essentia.LIGHT, 5));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.SOUL_CAMPFIRE), new EssentiaList().add(Essentia.FIRE, 10).add(Essentia.LIGHT, 5).add(Essentia.SOUL, 5));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.CARVED_PUMPKIN), new EssentiaList().add(Essentia.PLANT, 5).add(Essentia.DARKNESS, 2));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.CAULDRON), new EssentiaList().add(Essentia.METAL, 20).add(Essentia.VOID, 30));
        EssentiaRegister.registerObjectTag("chests/wooden", new EssentiaList().add(Essentia.PLANT, 5).add(Essentia.EXCHANGE, 10).add(Essentia.VOID, 15));
        EssentiaRegister.registerObjectTag("chest/ender", new EssentiaList().add(Essentia.ELDRITCH, 10).add(Essentia.EXCHANGE, 10).add(Essentia.VOID, 15));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.CHORUS_FLOWER), new EssentiaList().add(Essentia.PLANT, 5).add(Essentia.ELDRITCH, 5).add(Essentia.SENSES, 5));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.CHORUS_PLANT), new EssentiaList().add(Essentia.PLANT, 5).add(Essentia.ELDRITCH, 5));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.CLAY), new EssentiaList().add(Essentia.WATER, 4).add(Essentia.EARTH, 4));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.CRAFTING_TABLE), new EssentiaList().add(Essentia.PLANT, 5).add(Essentia.CRAFT, 15));
        EssentiaRegister.registerObjectTag("ores/coal", new EssentiaList().add(Essentia.EARTH, 5).add(Essentia.ENERGY, 2));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.COAL_BLOCK), new EssentiaList().add(Essentia.FIRE, 20).add(Essentia.ENERGY, 25));
        EssentiaRegister.registerObjectTag("cobblestone", new EssentiaList().add(Essentia.EARTH, 2).add(Essentia.ENTROPY, 2));
        EssentiaRegister.registerObjectTag("ores/copper", new EssentiaList().add(Essentia.EARTH, 5).add(Essentia.METAL, 2));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.COPPER_BLOCK), new EssentiaList().add(Essentia.METAL, 20));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.CRYING_OBSIDIAN), new EssentiaList().add(Essentia.DARKNESS, 5).add(Essentia.FIRE, 5).add(Essentia.MAGIC, 5));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.CUT_COPPER), new EssentiaList().add(Essentia.METAL, 20));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.DETECTOR_RAIL), new EssentiaList().add(Essentia.MECHANISM, 5).add(Essentia.METAL, 5));
        EssentiaRegister.registerObjectTag("ores/diamond", new EssentiaList().add(Essentia.EARTH, 5).add(Essentia.CRYSTAL, 5).add(Essentia.DESIRE, 2));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.DIAMOND_BLOCK), new EssentiaList().add(Essentia.CRYSTAL, 30).add(Essentia.DESIRE, 20));
        EssentiaRegister.registerObjectTag("dirt", new EssentiaList().add(Essentia.EARTH, 1));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.DISPENSER), new EssentiaList().add(Essentia.MECHANISM, 10).add(Essentia.EXCHANGE, 5).add(Essentia.VOID, 2));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.DROPPER), new EssentiaList().add(Essentia.MECHANISM, 10).add(Essentia.EXCHANGE, 5).add(Essentia.VOID, 2));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.DRAGON_EGG), new EssentiaList().add(Essentia.ELDRITCH, 15).add(Essentia.BEAST, 15).add(Essentia.DARKNESS, 15).add(Essentia.MOTION, 15).add(Essentia.MAGIC, 5));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.DRIPSTONE_BLOCK), new EssentiaList().add(Essentia.EARTH, 5).add(Essentia.FIRE, 2));
        EssentiaRegister.registerObjectTag("ores/emerald", new EssentiaList().add(Essentia.EARTH, 5).add(Essentia.DESIRE, 5).add(Essentia.CRYSTAL, 10));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.EMERALD_BLOCK), new EssentiaList().add(Essentia.DESIRE, 20).add(Essentia.CRYSTAL, 50));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.END_ROD), new EssentiaList().add(Essentia.ELDRITCH, 5).add(Essentia.MOTION, 2));
        EssentiaRegister.registerObjectTag("end_stones", new EssentiaList().add(Essentia.ELDRITCH, 1).add(Essentia.EARTH, 1));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.FERN), new EssentiaList().add(Essentia.PLANT, 10));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.FURNACE), new EssentiaList().add(Essentia.FIRE, 10).add(Essentia.EARTH, 10).add(Essentia.ENERGY, 10));
        EssentiaRegister.registerObjectTag("fences/wooden", new EssentiaList().add(Essentia.PLANT, 10));
        EssentiaRegister.registerObjectTag("impermeable", new EssentiaList().add(Essentia.CRYSTAL, 5));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.GLOWSTONE), new EssentiaList().add(Essentia.LIGHT, 10));
        EssentiaRegister.registerObjectTag("ores/gold", new EssentiaList().add(Essentia.EARTH, 5).add(Essentia.METAL, 2).add(Essentia.DESIRE, 5));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.GOLD_BLOCK), new EssentiaList().add(Essentia.METAL, 10).add(Essentia.DESIRE, 50));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.HONEYCOMB_BLOCK), new EssentiaList().add(Essentia.LIFE, 10));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.HONEY_BLOCK), new EssentiaList().add(Essentia.LIFE, 10));
        EssentiaRegister.registerObjectTag("iron_ores", new EssentiaList().add(Essentia.EARTH, 5).add(Essentia.METAL, 2));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.IRON_BLOCK), new EssentiaList().add(Essentia.METAL, 90));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.JUKEBOX), new EssentiaList().add(Essentia.MECHANISM, 10));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.LADDER), new EssentiaList().add(Essentia.PLANT, 5).add(Essentia.MOTION, 2));
        EssentiaRegister.registerObjectTag("leaves", new EssentiaList().add(Essentia.PLANT, 2));
        EssentiaRegister.registerObjectTag("ores/lapis", new EssentiaList().add(Essentia.EARTH, 5).add(Essentia.SENSES, 10));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.LAPIS_BLOCK), new EssentiaList().add(Essentia.SENSES, 30));
        EssentiaRegister.registerObjectTag("ores/lead", new EssentiaList().add(Essentia.EARTH, 5).add(Essentia.METAL, 5).add(Essentia.ORDER, 5));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.LANTERN), new EssentiaList().add(Essentia.LIGHT, 10).add(Essentia.METAL, 2));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.MAGMA_BLOCK), new EssentiaList().add(Essentia.FIRE, 5).add(Essentia.EARTH, 2));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.MELON), new EssentiaList().add(Essentia.PLANT, 1).add(Essentia.LIFE, 1));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.NETHER_BRICKS), new EssentiaList().add(Essentia.FIRE, 2));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.OBSIDIAN), new EssentiaList().add(Essentia.EARTH, 5).add(Essentia.FIRE, 5).add(Essentia.DARKNESS, 5));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.OBSERVER), new EssentiaList().add(Essentia.MECHANISM, 10).add(Essentia.ENERGY, 5).add(Essentia.SENSES, 5));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.PRISMARINE), new EssentiaList().add(Essentia.WATER, 5));
        EssentiaRegister.registerObjectTag("planks", new EssentiaList().add(Essentia.PLANT, 1));
        EssentiaRegister.registerObjectTag("ores/quartz", new EssentiaList().add(Essentia.EARTH, 5).add(Essentia.CRYSTAL, 5));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.QUARTZ_BLOCK), new EssentiaList().add(Essentia.CRYSTAL, 20));
        EssentiaRegister.registerObjectTag("redstone_ores", new EssentiaList().add(Essentia.EARTH, 5).add(Essentia.ENERGY, 4));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.REDSTONE_BLOCK), new EssentiaList().add(Essentia.ENERGY, 30));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.REDSTONE_LAMP), new EssentiaList().add(Essentia.LIGHT, 10).add(Essentia.ENERGY, 5));
        EssentiaRegister.registerObjectTag("sand", new EssentiaList().add(Essentia.EARTH, 2));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.SANDSTONE), new EssentiaList().add(Essentia.EARTH, 4));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.SEA_LANTERN), new EssentiaList().add(Essentia.WATER, 5).add(Essentia.LIFE, 5));
        EssentiaRegister.registerObjectTag("ores/silver", new EssentiaList().add(Essentia.EARTH, 5).add(Essentia.METAL, 2).add(Essentia.DESIRE, 1));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.SHROOMLIGHT), new EssentiaList().add(Essentia.PLANT, 2).add(Essentia.LIGHT, 2));
        EssentiaRegister.registerObjectTag("shulker_boxes", new EssentiaList().add(Essentia.VOID, 10).add(Essentia.ELDRITCH, 5));
        EssentiaRegister.registerObjectTag("snow", new EssentiaList().add(Essentia.COLD, 5));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.SOUL_SAND), new EssentiaList().add(Essentia.EARTH, 3).add(Essentia.TRAP, 1).add(Essentia.SOUL, 3));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.SPONGE), new EssentiaList().add(Essentia.TRAP, 5).add(Essentia.VOID, 2));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.WET_SPONGE), new EssentiaList().add(Essentia.TRAP, 5).add(Essentia.WATER, 2));
        EssentiaRegister.registerObjectTag("terracota", new EssentiaList().add(Essentia.SENSES, 1).add(Essentia.FIRE, 1));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.SKELETON_SKULL), new EssentiaList().add(Essentia.UNDEAD, 10));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.ZOMBIE_HEAD), new EssentiaList().add(Essentia.UNDEAD, 10));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.PLAYER_HEAD), new EssentiaList().add(Essentia.MAN, 10));
        EssentiaRegister.registerObjectTag("wooden_trapdoors", new EssentiaList().add(Essentia.PLANT, 2).add(Essentia.TRAP, 5));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.IRON_TRAPDOOR), new EssentiaList().add(Essentia.PLANT, 2).add(Essentia.TRAP, 5).add(Essentia.METAL, 5));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.TNT), new EssentiaList().add(Essentia.FIRE, 10).add(Essentia.DEATH, 5));
        EssentiaRegister.registerObjectTag("ores/tin", new EssentiaList().add(Essentia.EARTH, 5).add(Essentia.METAL, 2));
        EssentiaRegister.registerObjectTag("ores/uranium", new EssentiaList().add(Essentia.EARTH, 5).add(Essentia.ENERGY, 2).add(Essentia.DEATH, 2));
        EssentiaRegister.registerObjectTag(new ItemStack(Blocks.WHEAT), new EssentiaList().add(Essentia.LIFE, 10).add(Essentia.PLANT, 5));
        EssentiaRegister.registerObjectTag("wool", new EssentiaList().add(Essentia.BEAST, 10).add(Essentia.CRAFT, 5));
        
        //ITEMS


    }



    




}

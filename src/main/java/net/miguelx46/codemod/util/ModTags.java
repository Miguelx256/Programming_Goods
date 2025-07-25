package net.miguelx46.codemod.util;

import net.miguelx46.codemod.CodeMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {


       private static TagKey<Block> tag(String name) {
           return BlockTags.create(new ResourceLocation(CodeMod.MOD_ID, name));
       }
    }

    public static class Items {

    }
}

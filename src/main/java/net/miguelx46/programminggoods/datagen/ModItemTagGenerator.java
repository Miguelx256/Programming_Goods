package net.miguelx46.programminggoods.datagen;

import net.miguelx46.programminggoods.ProgrammingGoods;
import net.miguelx46.programminggoods.item.ModItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {

    public ModItemTagGenerator(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, String modId, @Nullable ExistingFileHelper existingFileHelper) {
        super(pOutput, pLookupProvider, pBlockTags, ProgrammingGoods.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        // añade un tag a alguna armadura del mod para que se pueda trimmear
        this.tag(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.JAVA_HELMET.get(),
                        ModItems.JAVA_CHESTPLATE.get(),
                        ModItems.JAVA_LEGGINGS.get(),
                        ModItems.JAVA_BOOTS.get());
    }
}

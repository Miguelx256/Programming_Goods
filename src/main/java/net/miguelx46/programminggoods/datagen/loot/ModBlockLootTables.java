package net.miguelx46.programminggoods.datagen.loot;

import net.miguelx46.programminggoods.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockLootTables extends BlockStateProvider {
    public ModBlockLootTables(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
        super(output, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
         blockWithItem(ModBlocks.JAVA_COFFEE_BLOCK);
         blockWithItem(ModBlocks.JAVA_OBJECT_ORE);

    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}

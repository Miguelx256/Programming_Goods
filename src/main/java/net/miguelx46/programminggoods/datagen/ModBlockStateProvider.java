package net.miguelx46.programminggoods.datagen;

import net.miguelx46.programminggoods.ProgrammingGoods;
import net.miguelx46.programminggoods.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(PackOutput output, String modid, ExistingFileHelper exFileHelper) {
        super(output, ProgrammingGoods.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
          blockWithItem(ModBlocks.ARRAY_FUEL_BLOCK);
          blockWithItem(ModBlocks.JAVA_COFFEE_BLOCK);
          blockWithItem(ModBlocks.JAVA_COFFEE_BLOCK);
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}

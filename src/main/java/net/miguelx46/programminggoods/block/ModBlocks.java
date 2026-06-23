package net.miguelx46.programminggoods.block;

import net.miguelx46.programminggoods.ProgrammingGoods;
import net.miguelx46.programminggoods.block.custom.FuelBlock;
import net.miguelx46.programminggoods.block.custom.JavaCompilerTableBlock;
import net.miguelx46.programminggoods.item.ModItems;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    // lista de bloques para ser registrados
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ProgrammingGoods.MOD_ID);

    // registro de bloques con las propiedades y sonido de un bloque en especifico
    public static final RegistryObject<Block> JAVA_OBJECT_ORE = registerBlock("java_object_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_ORE).sound(SoundType.STONE)));

    public static final RegistryObject<Block> JAVA_COFFEE_BLOCK = registerBlock("java_coffee_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).sound(SoundType.METAL)));

    // tienen que ir 2 registry para un bloque que sea combustible, uno para registrarlo como bloque y otro para item, en ese orden
    public static final RegistryObject<Block> ARRAY_FUEL_BLOCK = BLOCKS.register("array_fuel_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COAL_BLOCK)));

    public static final RegistryObject<Item> ARRAY_FUEL_BLOCK_ITEM = ModItems.ITEMS.register("array_fuel_block",
            () -> new FuelBlock(ARRAY_FUEL_BLOCK.get(), new Item.Properties(), 30000));

    public static final RegistryObject<Block> JAVA_COMPILER_TABLE =
            registerBlock("java_compiler_table",
                    () -> new JavaCompilerTableBlock(
                            BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)
                                    .requiresCorrectToolForDrops()
                                    .strength(50.0f, 1200.0f)
                    ));

    public static final RegistryObject<Block> JAVA_STONE = registerBlock("java_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).sound(SoundType.STONE)));

    public static final RegistryObject<Block> JAVA_SMOOTH_STONE = registerBlock("java_smooth_stone",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.SMOOTH_STONE).sound(SoundType.STONE)));

    public static final RegistryObject<Block> JAVA_STONE_BRICKS = registerBlock("java_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE_BRICKS).sound(SoundType.STONE)));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem (String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}

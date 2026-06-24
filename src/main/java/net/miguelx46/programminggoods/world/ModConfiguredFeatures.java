package net.miguelx46.programminggoods.world;

import net.miguelx46.programminggoods.ProgrammingGoods;
import net.miguelx46.programminggoods.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>>
            JAVA_OBJECT_ORE_KEY =
            registerKey("java_object_ore");

    public static final ResourceKey<ConfiguredFeature<?, ?>>
            JAVA_HYPER_STONE_KEY =
            registerKey("java_hyper_stone");

    public static void bootstrap(
            BootstapContext<ConfiguredFeature<?, ?>> context) {

        List<OreConfiguration.TargetBlockState>
                overworldJavaOres = List.of(

                OreConfiguration.target(
                        new TagMatchTest(
                                BlockTags.STONE_ORE_REPLACEABLES),
                        ModBlocks.JAVA_OBJECT_ORE.get()
                                .defaultBlockState()),

                OreConfiguration.target(
                        new TagMatchTest(
                                BlockTags.DEEPSLATE_ORE_REPLACEABLES),
                        ModBlocks.JAVA_OBJECT_ORE.get()
                                .defaultBlockState())
        );

        register(
                context,
                JAVA_OBJECT_ORE_KEY,
                Feature.ORE,
                new OreConfiguration(
                        overworldJavaOres,
                        7
                )
        );

        List<OreConfiguration.TargetBlockState>
                overworldJavaHyperStone = List.of(

                OreConfiguration.target(
                        new TagMatchTest(
                                BlockTags.STONE_ORE_REPLACEABLES),
                        ModBlocks.JAVA_HYPER_STONE.get()
                                .defaultBlockState()),

                OreConfiguration.target(
                        new TagMatchTest(
                                BlockTags.DEEPSLATE_ORE_REPLACEABLES),
                        ModBlocks.JAVA_HYPER_STONE.get()
                                .defaultBlockState())
        );

        register(
                context,
                JAVA_HYPER_STONE_KEY,
                Feature.ORE,
                new OreConfiguration(
                        overworldJavaHyperStone,
                        1
                )
        );
    }

    public static ResourceKey<ConfiguredFeature<?, ?>>
    registerKey(String name) {

        return ResourceKey.create(
                Registries.CONFIGURED_FEATURE,
                new ResourceLocation(
                        ProgrammingGoods.MOD_ID,
                        name
                )
        );
    }

    private static <
            FC extends net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration,
            F extends Feature<FC>>
    void register(
            BootstapContext<ConfiguredFeature<?, ?>> context,
            ResourceKey<ConfiguredFeature<?, ?>> key,
            F feature,
            FC configuration) {

        context.register(
                key,
                new ConfiguredFeature<>(
                        feature,
                        configuration
                )
        );
    }
}
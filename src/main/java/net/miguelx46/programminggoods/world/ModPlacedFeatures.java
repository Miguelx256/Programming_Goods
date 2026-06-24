package net.miguelx46.programminggoods.world;

import net.miguelx46.programminggoods.ProgrammingGoods;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {

    public static final ResourceKey<PlacedFeature>
            JAVA_OBJECT_ORE_PLACED_KEY =
            registerKey("java_object_ore_placed");

    public static final ResourceKey<PlacedFeature>
            JAVA_LAB_PLACED_KEY =
            registerKey("java_lab_placed");

    public static void bootstrap(
            BootstapContext<PlacedFeature> context) {

        Holder<ConfiguredFeature<?, ?>> javaOre =
                context.lookup(Registries.CONFIGURED_FEATURE)
                        .getOrThrow(
                                ModConfiguredFeatures.JAVA_OBJECT_ORE_KEY);

        context.register(
                JAVA_OBJECT_ORE_PLACED_KEY,

                new PlacedFeature(
                        javaOre,

                        commonOrePlacement(
                                2,

                                HeightRangePlacement.uniform(
                                        VerticalAnchor.absolute(-60),
                                        VerticalAnchor.absolute(-30)
                                )
                        )
                )
        );

        Holder<ConfiguredFeature<?, ?>> javaLab =
                context.lookup(Registries.CONFIGURED_FEATURE)
                        .getOrThrow(
                                ModConfiguredFeatures.JAVA_LAB_KEY);

        context.register(
                JAVA_LAB_PLACED_KEY,

                new PlacedFeature(
                        javaLab,

                        List.of(
                                RarityFilter.onAverageOnceEvery(40),

                                InSquarePlacement.spread(),

                                HeightRangePlacement.uniform(
                                        VerticalAnchor.absolute(-60),
                                        VerticalAnchor.absolute(-40)
                                ),

                                BiomeFilter.biome()
                        )
                )
        );
    }

    public static ResourceKey<PlacedFeature>
    registerKey(String name) {

        return ResourceKey.create(
                Registries.PLACED_FEATURE,

                new ResourceLocation(
                        ProgrammingGoods.MOD_ID,
                        name));
    }

    private static List<PlacementModifier>
    commonOrePlacement(
            int count,
            PlacementModifier height) {

        return List.of(
                CountPlacement.of(count),
                InSquarePlacement.spread(),
                height,
                BiomeFilter.biome()
        );
    }
}
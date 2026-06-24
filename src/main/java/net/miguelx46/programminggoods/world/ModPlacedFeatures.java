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
            JAVA_HYPER_STONE_PLACED_KEY =
            registerKey("java_hyper_stone_placed");

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
                                        VerticalAnchor.absolute(-40)
                                )
                        )
                )
        );

        Holder<ConfiguredFeature<?, ?>> javaHyperStone =
                context.lookup(Registries.CONFIGURED_FEATURE)
                        .getOrThrow(
                                ModConfiguredFeatures.JAVA_HYPER_STONE_KEY);

        context.register(
                JAVA_HYPER_STONE_PLACED_KEY,

                new PlacedFeature(
                        javaHyperStone,

                        commonOrePlacement(
                                1,

                                HeightRangePlacement.uniform(
                                        VerticalAnchor.absolute(-50),
                                        VerticalAnchor.absolute(-15)
                                )
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
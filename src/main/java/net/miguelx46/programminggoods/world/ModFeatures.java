package net.miguelx46.programminggoods.world;

import net.miguelx46.programminggoods.ProgrammingGoods;
import net.miguelx46.programminggoods.world.feature.JavaDeepslateFeature;
import net.miguelx46.programminggoods.world.feature.JavaLabFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModFeatures {

    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(
                    ForgeRegistries.FEATURES,
                    ProgrammingGoods.MOD_ID
            );

    public static final RegistryObject<Feature<NoneFeatureConfiguration>>
            JAVA_LAB =
            FEATURES.register(
                    "java_lab",
                    () -> new JavaLabFeature(
                            NoneFeatureConfiguration.CODEC
                    )
            );

    public static final RegistryObject<Feature<NoneFeatureConfiguration>>
            JAVA_DEEPSLATE =
            FEATURES.register(
                    "java_deepslate",
                    () -> new JavaDeepslateFeature(
                            NoneFeatureConfiguration.CODEC
                    )
            );
}
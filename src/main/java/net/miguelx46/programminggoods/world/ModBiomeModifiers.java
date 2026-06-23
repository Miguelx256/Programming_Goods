package net.miguelx46.programminggoods.world;

import net.miguelx46.programminggoods.ProgrammingGoods;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBiomeModifiers {

    public static final DeferredRegister<BiomeModifier> BIOME_MODIFIERS =
            DeferredRegister.create(
                    ForgeRegistries.Keys.BIOME_MODIFIERS,
                    ProgrammingGoods.MOD_ID);

    public static final RegistryObject<BiomeModifier>
            ADD_JAVA_OBJECT_ORE = BIOME_MODIFIERS.register(
            "add_java_object_ore",

            () -> new ForgeBiomeModifiers.AddFeaturesBiomeModifier(

                    HolderSet.direct(),

                    HolderSet.direct(),

                    GenerationStep.Decoration.UNDERGROUND_ORES
            )
    );
}

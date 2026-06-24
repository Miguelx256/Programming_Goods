package net.miguelx46.programminggoods.world;

import net.miguelx46.programminggoods.ProgrammingGoods;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModBiomeModifiers {

    public static final DeferredRegister<BiomeModifier> BIOME_MODIFIERS =
            DeferredRegister.create(
                    ForgeRegistries.Keys.BIOME_MODIFIERS,
                    ProgrammingGoods.MOD_ID);
}
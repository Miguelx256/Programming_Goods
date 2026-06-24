package net.miguelx46.programminggoods.world.feature;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class JavaLabFeature
        extends Feature<NoneFeatureConfiguration> {

    public JavaLabFeature(
            Codec<NoneFeatureConfiguration> codec) {

        super(codec);
    }

    @Override
    public boolean place(
            FeaturePlaceContext<NoneFeatureConfiguration> context) {

        if (!(context.level() instanceof ServerLevel level)) {
            return false;
        }

        BlockPos pos = context.origin();

        System.out.println(
                "JAVA LAB FEATURE CALLED AT " + pos
        );

        level.setBlock(
                pos,
                Blocks.DIAMOND_BLOCK.defaultBlockState(),
                3
        );

        return true;
    }
}
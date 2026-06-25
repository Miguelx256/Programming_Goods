package net.miguelx46.programminggoods.world.feature;

import com.mojang.serialization.Codec;
import net.miguelx46.programminggoods.ProgrammingGoods;
import net.miguelx46.programminggoods.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class JavaDeepslateFeature extends Feature<NoneFeatureConfiguration> {

    public JavaDeepslateFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        ProgrammingGoods.LOGGER.info("Generating Java Deepslate Region");
        generateMass(context);

        return true;
    }

    private void generateMass(FeaturePlaceContext<NoneFeatureConfiguration> context) {

        WorldGenLevel level = context.level();
        BlockPos origin = context.origin();
        RandomSource random = context.random();

        int radiusX = 50 + random.nextInt(20);
        int radiusY = 25 + random.nextInt(10);
        int radiusZ = 50 + random.nextInt(20);

        for (int x = -radiusX; x <= radiusX; x++) {

            for (int y = -radiusY; y <= radiusY; y++) {

                for (int z = -radiusZ; z <= radiusZ; z++) {

                    double dx = (double)x / radiusX;
                    double dy = (double)y / radiusY;
                    double dz = (double)z / radiusZ;

                    if ((dx * dx + dy * dy + dz * dz) <= 1.0D) {

                        BlockPos pos = origin.offset(x, y, z);

                        if (level.getBlockState(pos).is(Blocks.STONE)
                                || level.getBlockState(pos).is(Blocks.DEEPSLATE)
                                || level.getBlockState(pos).is(Blocks.TUFF))

                            level.setBlock(
                                    pos,
                                    ModBlocks.JAVA_DEEPSLATE.get().defaultBlockState(),
                                    2
                            );
                        }
                    }
                }
            }
        }
    }
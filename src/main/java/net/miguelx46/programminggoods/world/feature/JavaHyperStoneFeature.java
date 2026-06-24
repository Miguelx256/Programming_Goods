package net.miguelx46.programminggoods.world.feature;

import com.mojang.serialization.Codec;
import net.miguelx46.programminggoods.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public class JavaHyperStoneFeature extends Feature<NoneFeatureConfiguration> {

    public JavaHyperStoneFeature(
            Codec<NoneFeatureConfiguration> codec) {

        super(codec);
    }

    @Override
    public boolean place(
            FeaturePlaceContext<NoneFeatureConfiguration> context) {

        if (!(context.level() instanceof ServerLevel level))
            return false;

        BlockPos origin = context.origin();

        // Busca muchas posiciones dentro del chunk
        for (int i = 0; i < 128; i++) {

            BlockPos pos = new BlockPos(
                    origin.getX() + level.random.nextInt(16),
                    -50 + level.random.nextInt(36),
                    origin.getZ() + level.random.nextInt(16)
            );

            BlockState state = level.getBlockState(pos);

            // Solo reemplazar piedra o deepslate
            if (!state.is(Blocks.STONE)
                    && !state.is(Blocks.DEEPSLATE)) {
                continue;
            }

            // Debe tener una cara expuesta al aire
            if (!hasAdjacentAir(level, pos)) {
                continue;
            }

            // No generar junto a lava
            if (touchingLava(level, pos)) {
                continue;
            }

            // No generar otra demasiado cerca
            if (existsNearby(level, pos, 48)) {
                continue;
            }

            level.setBlock(
                    pos,
                    ModBlocks.JAVA_HYPER_STONE.get().defaultBlockState(),
                    3
            );

            return true;
        }

        return false;
    }

    private boolean hasAdjacentAir(
            LevelAccessor level,
            BlockPos pos) {

        return level.isEmptyBlock(pos.north())
                || level.isEmptyBlock(pos.south())
                || level.isEmptyBlock(pos.east())
                || level.isEmptyBlock(pos.west())
                || level.isEmptyBlock(pos.above())
                || level.isEmptyBlock(pos.below());
    }

    private boolean touchingLava(
            LevelAccessor level,
            BlockPos pos) {

        return level.getBlockState(pos.north()).is(Blocks.LAVA)
                || level.getBlockState(pos.south()).is(Blocks.LAVA)
                || level.getBlockState(pos.east()).is(Blocks.LAVA)
                || level.getBlockState(pos.west()).is(Blocks.LAVA)
                || level.getBlockState(pos.above()).is(Blocks.LAVA)
                || level.getBlockState(pos.below()).is(Blocks.LAVA);
    }

    private boolean existsNearby(
            LevelAccessor level,
            BlockPos center,
            int radius) {

        for (int x = -radius; x <= radius; x++) {

            for (int y = -8; y <= 8; y++) {

                for (int z = -radius; z <= radius; z++) {

                    if (level.getBlockState(
                                    center.offset(x, y, z))
                            .is(ModBlocks.JAVA_HYPER_STONE.get())) {

                        return true;
                    }
                }
            }
        }

        return false;
    }
}
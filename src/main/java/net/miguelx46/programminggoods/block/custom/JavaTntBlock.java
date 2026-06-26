package net.miguelx46.programminggoods.block.custom;

import net.miguelx46.programminggoods.entity.ModEntities;
import net.miguelx46.programminggoods.entity.custom.JavaPrimedTnt;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Explosion;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.TntBlock;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nullable;

public class JavaTntBlock extends TntBlock {

    public JavaTntBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void onCaughtFire(BlockState state,
                             Level level,
                             BlockPos pos,
                             @Nullable Direction face,
                             @Nullable LivingEntity igniter) {

        if (!level.isClientSide) {

            JavaPrimedTnt tnt =
                    new JavaPrimedTnt(
                            ModEntities.JAVA_PRIMED_TNT.get(),
                            level
                    );

            tnt.setPos(
                    pos.getX() + 0.5D,
                    pos.getY(),
                    pos.getZ() + 0.5D
            );

            tnt.setExplosionPower(15.0F);

            level.addFreshEntity(tnt);

            level.playSound(
                    null,
                    tnt.getX(),
                    tnt.getY(),
                    tnt.getZ(),
                    SoundEvents.TNT_PRIMED,
                    SoundSource.BLOCKS,
                    1.0F,
                    1.0F
            );

            level.removeBlock(pos, false);
        }
    }

    @Override
    public void wasExploded(Level level,
                            BlockPos pos,
                            Explosion explosion) {

        if (!level.isClientSide) {

            JavaPrimedTnt tnt =
                    new JavaPrimedTnt(
                            ModEntities.JAVA_PRIMED_TNT.get(),
                            level
                    );

            tnt.setPos(
                    pos.getX() + 0.5D,
                    pos.getY(),
                    pos.getZ() + 0.5D
            );

            tnt.setExplosionPower(15.0F);

            tnt.setFuse(
                    level.random.nextInt(20) + 10
            );

            level.addFreshEntity(tnt);
        }
    }
}
package net.miguelx46.programminggoods.event;

import net.miguelx46.programminggoods.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.living.MobSpawnEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.miguelx46.programminggoods.entity.ModEntities;
import net.miguelx46.programminggoods.entity.custom.JavaCreeperEntity;
import net.miguelx46.programminggoods.entity.custom.JavaSkeletonEntity;
import net.miguelx46.programminggoods.entity.custom.JavaSpiderEntity;
import net.miguelx46.programminggoods.entity.custom.JavaZombieEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;

public class JavaMobSpawner {

    @SubscribeEvent
    public void onMobSpawn(MobSpawnEvent.FinalizeSpawn event) {

        if (event.getLevel().isClientSide())
            return;

        Mob mob = event.getEntity();

        if (mob.getBlockY() > 0)
            return;

        if (!(mob instanceof Zombie)
                && !(mob instanceof Skeleton)
                && !(mob instanceof Creeper)
                && !(mob instanceof Spider))
            return;

        if (!hasJavaDeepslateNearby(
                mob.level(),
                mob.blockPosition())) {

            return;
        }
        replaceMob(mob);
    }

    private boolean hasJavaDeepslateNearby(Level level, BlockPos center) {

        int radius = 5;

        for (int x = -radius; x <= radius; x++) {

            for (int y = -radius; y <= radius; y++) {

                for (int z = -radius; z <= radius; z++) {

                    BlockPos pos = center.offset(x, y, z);

                    if (level.getBlockState(pos)
                            .is(ModBlocks.JAVA_DEEPSLATE.get())) {

                        return true;
                    }
                }
            }
        }

        return false;
    }

    private void replaceMob(Mob mob) {

        Level level = (Level) mob.level();

        Entity replacement = null;

        if (mob instanceof Zombie) {

            replacement = new JavaZombieEntity(
                    ModEntities.JAVA_ZOMBIE.get(),
                    level);

        } else if (mob instanceof Skeleton) {

            replacement = new JavaSkeletonEntity(
                    ModEntities.JAVA_SKELETON.get(),
                    level);

        } else if (mob instanceof Creeper) {

            replacement = new JavaCreeperEntity(
                    ModEntities.JAVA_CREEPER.get(),
                    level);

        } else if (mob instanceof Spider) {

            replacement = new JavaSpiderEntity(
                    ModEntities.JAVA_SPIDER.get(),
                    level);
        }

        if (replacement == null)
            return;

        replacement.moveTo(
                mob.getX(),
                mob.getY(),
                mob.getZ(),
                mob.getYRot(),
                mob.getXRot()
        );

        level.addFreshEntity(replacement);

        mob.discard();
    }
}
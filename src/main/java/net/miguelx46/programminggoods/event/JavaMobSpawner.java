package net.miguelx46.programminggoods.event;

import net.miguelx46.programminggoods.block.ModBlocks;
import net.miguelx46.programminggoods.entity.ModEntities;
import net.miguelx46.programminggoods.entity.custom.JavaCreeperEntity;
import net.miguelx46.programminggoods.entity.custom.JavaSkeletonEntity;
import net.miguelx46.programminggoods.entity.custom.JavaZombieEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class JavaMobSpawner {

    @SubscribeEvent
    public void onEntitySpawn(EntityJoinLevelEvent event) {

        if (event.getLevel().isClientSide())
            return;

        Entity entity = event.getEntity();

        if (!(entity instanceof Zombie)
                && !(entity instanceof Skeleton)
                && !(entity instanceof Creeper))
            return;

        // Evita reemplazar nuestros propios mobs
        if (entity instanceof JavaZombieEntity
                || entity instanceof JavaSkeletonEntity
                || entity instanceof JavaCreeperEntity)
            return;

        // Solo bajo tierra
        if (entity.getBlockY() > 0)
            return;

        if (!hasJavaDeepslateNearby(entity.level(), entity.blockPosition()))
            return;

        replaceMob(entity);
    }

    private boolean hasJavaDeepslateNearby(Level level, BlockPos center) {

        int radius = 3;

        for (int x = -radius; x <= radius; x++) {
            for (int y = -radius; y <= radius; y++) {
                for (int z = -radius; z <= radius; z++) {

                    if (level.getBlockState(center.offset(x, y, z))
                            .is(ModBlocks.JAVA_DEEPSLATE.get())) {

                        return true;
                    }
                }
            }
        }

        return false;
    }

    private void replaceMob(Entity entity) {

        Level level = (Level) entity.level();

        Entity replacement = null;

        if (entity instanceof Zombie) {

            replacement = new JavaZombieEntity(
                    ModEntities.JAVA_ZOMBIE.get(),
                    level);

        } else if (entity instanceof Skeleton) {

            replacement = new JavaSkeletonEntity(
                    ModEntities.JAVA_SKELETON.get(),
                    level);

        } else if (entity instanceof Creeper) {

            replacement = new JavaCreeperEntity(
                    ModEntities.JAVA_CREEPER.get(),
                    level);
        }

        if (replacement == null)
            return;

        replacement.moveTo(
                entity.getX(),
                entity.getY(),
                entity.getZ(),
                entity.getYRot(),
                entity.getXRot());

        level.addFreshEntity(replacement);

        entity.discard();
    }
}
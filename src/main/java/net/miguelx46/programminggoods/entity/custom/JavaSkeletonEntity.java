package net.miguelx46.programminggoods.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.level.Level;

public class JavaSkeletonEntity extends Skeleton {

    public JavaSkeletonEntity(EntityType<? extends Skeleton> entityType, Level level) {
        super(entityType, level);

        this.xpReward = 10;
    }
}
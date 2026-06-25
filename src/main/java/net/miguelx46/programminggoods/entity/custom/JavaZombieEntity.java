package net.miguelx46.programminggoods.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;

public class JavaZombieEntity extends Zombie {

    public JavaZombieEntity(EntityType<? extends Zombie> entityType, Level level) {
        super(entityType, level);
        this.xpReward = 15;
    }
}

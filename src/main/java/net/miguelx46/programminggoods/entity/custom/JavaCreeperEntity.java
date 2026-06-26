package net.miguelx46.programminggoods.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.Level;

public class JavaCreeperEntity extends Creeper {

    public JavaCreeperEntity(EntityType<? extends Creeper> entityType, Level level) {
        super(entityType, level);

        this.xpReward = 12;
    }
}
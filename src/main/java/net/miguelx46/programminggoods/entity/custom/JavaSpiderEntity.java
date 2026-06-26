package net.miguelx46.programminggoods.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.level.Level;

public class JavaSpiderEntity extends Spider {

    public JavaSpiderEntity(EntityType<? extends Spider> entityType,
                            Level level) {

        super(entityType, level);

        this.xpReward = 8;
    }
}
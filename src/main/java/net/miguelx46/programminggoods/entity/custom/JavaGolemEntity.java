package net.miguelx46.programminggoods.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.level.Level;

public class JavaGolemEntity extends IronGolem {

    public JavaGolemEntity(EntityType<? extends IronGolem> entityType,
                           Level level) {

        super(entityType, level);
    }
}
package net.miguelx46.programminggoods.entity;

import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.IronGolem;

public class ModEntityAttributes {

    public static AttributeSupplier.Builder createJavaGolemAttributes() {

        return IronGolem.createAttributes()
                .add(Attributes.MAX_HEALTH, 150.0D)
                .add(Attributes.ATTACK_DAMAGE, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.25D);
    }
}

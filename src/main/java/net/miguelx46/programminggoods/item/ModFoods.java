package net.miguelx46.programminggoods.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    // items de comidas
    public static final FoodProperties JAVA_JUICE = new FoodProperties.Builder().nutrition(9)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 6500), 10f).build();

    public static final FoodProperties JAVA_APPLE = new FoodProperties.Builder().nutrition(7)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 4300), 10f).build();
}

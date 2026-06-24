package net.miguelx46.programminggoods.entity.custom;

import net.miguelx46.programminggoods.item.ModItems;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class JavaGolemEntity extends IronGolem {

    private boolean guardian = false;

    public JavaGolemEntity(EntityType<? extends IronGolem> entityType,
                           Level level) {

        super(entityType, level);

        this.xpReward = 80;
    }

    @Override
    protected void registerGoals() {

        super.registerGoals();

        this.targetSelector.addGoal(
                2,
                new NearestAttackableTargetGoal<>(
                        this,
                        Player.class,
                        true,
                        entity -> guardian
                )
        );
    }

    public void setGuardian(boolean guardian) {
        this.guardian = guardian;
    }

    public boolean isGuardian() {
        return guardian;
    }

    @Override
    protected void dropCustomDeathLoot(
            DamageSource damageSource,
            int looting,
            boolean recentlyHit) {

        super.dropCustomDeathLoot(
                damageSource,
                looting,
                recentlyHit);

        RandomSource random = this.getRandom();

        if (random.nextFloat() < 0.25F) {
            this.spawnAtLocation(
                    new ItemStack(
                            ModItems.JAVA_OBJECT.get(),
                            1
                    )
            );
        }
    }
}
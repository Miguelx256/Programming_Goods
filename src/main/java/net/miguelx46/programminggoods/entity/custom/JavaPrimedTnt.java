package net.miguelx46.programminggoods.entity.custom;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.material.PushReaction;

public class JavaPrimedTnt extends Entity {

    private static final EntityDataAccessor<Integer> DATA_FUSE =
            SynchedEntityData.defineId(
                    JavaPrimedTnt.class,
                    EntityDataSerializers.INT);

    private float explosionPower = 8.0F;

    public JavaPrimedTnt(
            EntityType<? extends JavaPrimedTnt> type,
            Level level) {

        super(type, level);

        this.blocksBuilding = true;
    }

    @Override
    protected void defineSynchedData() {

        this.entityData.define(DATA_FUSE, 80);
    }

    @Override
    protected void readAdditionalSaveData(CompoundTag tag) {

        setFuse(tag.getInt("Fuse"));
        explosionPower = tag.getFloat("Power");
    }

    @Override
    protected void addAdditionalSaveData(CompoundTag tag) {

        tag.putInt("Fuse", getFuse());
        tag.putFloat("Power", explosionPower);
    }

    @Override
    public void tick() {

        super.tick();

        if (!this.isNoGravity()) {

            this.setDeltaMovement(
                    this.getDeltaMovement().add(
                            0.0D,
                            -0.04D,
                            0.0D
                    )
            );
        }

        this.move(
                MoverType.SELF,
                this.getDeltaMovement()
        );

        this.setDeltaMovement(
                this.getDeltaMovement().scale(0.98D)
        );

        if (this.onGround()) {

            this.setDeltaMovement(
                    this.getDeltaMovement().multiply(
                            0.7D,
                            -0.5D,
                            0.7D
                    )
            );
        }

        setFuse(getFuse() - 1);

        if (getFuse() <= 0) {

            this.discard();

            if (!this.level().isClientSide) {

                explode();
            }

        } else {

            if (this.level().isClientSide) {

                this.level().addParticle(
                        ParticleTypes.SMOKE,
                        this.getX(),
                        this.getY() + 0.5D,
                        this.getZ(),
                        0,
                        0,
                        0
                );
            }
        }
    }

    private void explode() {

        this.level().explode(
                this,
                this.getX(),
                this.getY(),
                this.getZ(),
                explosionPower,
                Level.ExplosionInteraction.TNT
        );
    }

    public int getFuse() {

        return this.entityData.get(DATA_FUSE);
    }

    public void setFuse(int fuse) {

        this.entityData.set(DATA_FUSE, fuse);
    }

    public float getExplosionPower() {

        return explosionPower;
    }

    public void setExplosionPower(float explosionPower) {

        this.explosionPower = explosionPower;
    }

    @Override
    public PushReaction getPistonPushReaction() {

        return PushReaction.IGNORE;
    }
}
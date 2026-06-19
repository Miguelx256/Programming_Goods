package net.miguelx46.programminggoods.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class JavaCompilerBlockEntity extends BlockEntity {

    public JavaCompilerBlockEntity(BlockPos pos,
                                   BlockState state) {
        super(ModBlockEntities.JAVA_COMPILER_BE.get(),
                pos,
                state);
    }
}

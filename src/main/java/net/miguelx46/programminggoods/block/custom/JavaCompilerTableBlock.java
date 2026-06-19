package net.miguelx46.programminggoods.block.custom;

import net.miguelx46.programminggoods.block.entity.JavaCompilerBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class JavaCompilerTableBlock extends BaseEntityBlock
        implements EntityBlock {

    public JavaCompilerTableBlock(Properties properties) {
        super(properties);
    }

    @Override
    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.MODEL;
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos,
                                      BlockState state) {

        return new JavaCompilerBlockEntity(
                pos,
                state);
    }
}
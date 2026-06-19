package net.miguelx46.programminggoods.block.custom;

import net.miguelx46.programminggoods.block.entity.JavaCompilerBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

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

    @Override
    public InteractionResult use(BlockState state,
                                 Level level,
                                 BlockPos pos,
                                 Player player,
                                 InteractionHand hand,
                                 BlockHitResult hit) {

        if (!level.isClientSide()) {

            BlockEntity entity = level.getBlockEntity(pos);

            if(entity instanceof MenuProvider provider) {
                player.openMenu(provider);
            }
        }

        return InteractionResult.sidedSuccess(level.isClientSide());
    }
}
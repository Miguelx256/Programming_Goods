package net.miguelx46.programminggoods.block.entity;

import net.miguelx46.programminggoods.menu.JavaCompilerMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class JavaCompilerBlockEntity extends BlockEntity implements MenuProvider {

    public JavaCompilerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.JAVA_COMPILER_BE.get(), pos, state);
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Java Compiler Table");
    }

    @Override
    public AbstractContainerMenu createMenu(int id,
                                            Inventory inventory,
                                            Player player) {

        return new JavaCompilerMenu(
                id,
                inventory,
                null
        );
    }
}
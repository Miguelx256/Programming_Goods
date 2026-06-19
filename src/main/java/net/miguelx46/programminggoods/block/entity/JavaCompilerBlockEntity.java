package net.miguelx46.programminggoods.block.entity;

import net.miguelx46.programminggoods.menu.JavaCompilerMenu;
import net.miguelx46.programminggoods.recipe.JavaCompilerRecipes;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.ItemStackHandler;

public class JavaCompilerBlockEntity extends BlockEntity implements MenuProvider {

    private final ItemStackHandler itemHandler = new ItemStackHandler(10);

    private LazyOptional<ItemStackHandler> lazyItemHandler =
            LazyOptional.empty();

    public JavaCompilerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.JAVA_COMPILER_BE.get(), pos, state);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(() -> itemHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
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
                itemHandler
        );
    }

    @Override
    protected void saveAdditional(CompoundTag tag) {
        super.saveAdditional(tag);

        tag.put("inventory",
                itemHandler.serializeNBT());
    }

    @Override
    public void load(CompoundTag tag) {
        super.load(tag);

        itemHandler.deserializeNBT(
                tag.getCompound("inventory"));
    }

    public ItemStackHandler getItemHandler() {
        return itemHandler;
    }

    public static void tick(JavaCompilerBlockEntity entity) {

        ItemStack result =
                JavaCompilerRecipes.getResult(
                        entity.getItemHandler());

        entity.getItemHandler().setStackInSlot(
                9,
                result.copy());
    }
}
package net.miguelx46.programminggoods.client.screen;

import net.miguelx46.programminggoods.menu.JavaCompilerMenu;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

public class JavaCompilerScreen
        extends AbstractContainerScreen<JavaCompilerMenu> {

    public JavaCompilerScreen(JavaCompilerMenu menu,
                              Inventory inventory,
                              Component title) {

        super(menu, inventory, title);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics,
                            float partialTick,
                            int mouseX,
                            int mouseY) {

    }

    @Override
    public void render(GuiGraphics guiGraphics,
                       int mouseX,
                       int mouseY,
                       float partialTick) {

        renderBackground(guiGraphics);
        super.render(guiGraphics, mouseX, mouseY, partialTick);
        renderTooltip(guiGraphics, mouseX, mouseY);
    }
}

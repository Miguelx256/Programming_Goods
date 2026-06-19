package net.miguelx46.programminggoods.client.screen;

import net.miguelx46.programminggoods.ProgrammingGoods;
import net.miguelx46.programminggoods.menu.JavaCompilerMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;

public class JavaCompilerScreen
        extends AbstractContainerScreen<JavaCompilerMenu> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(
                    ProgrammingGoods.MOD_ID,
                    "textures/gui/java_compiler.png");

    public JavaCompilerScreen(JavaCompilerMenu menu,
                              Inventory inventory,
                              Component title) {

        super(menu, inventory, title);

        this.imageWidth = 176;
        this.imageHeight = 166;

        this.titleLabelX = 8;
        this.titleLabelY = 6;

        this.inventoryLabelX = 8;
        this.inventoryLabelY = 72;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics,
                            float partialTick,
                            int mouseX,
                            int mouseY) {

        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        guiGraphics.blit(
                TEXTURE,
                x,
                y,
                0,
                0,
                imageWidth,
                imageHeight
        );
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics,
                                int mouseX,
                                int mouseY) {

        guiGraphics.drawString(
                this.font,
                this.title,
                this.titleLabelX,
                this.titleLabelY,
                0xFFFFFF,
                false
        );

        guiGraphics.drawString(
                this.font,
                this.playerInventoryTitle,
                this.inventoryLabelX,
                this.inventoryLabelY,
                0xFFFFFF,
                false
        );
    }

    @Override
    public void render(GuiGraphics guiGraphics,
                       int mouseX,
                       int mouseY,
                       float partialTick) {

        renderBackground(guiGraphics);

        super.render(
                guiGraphics,
                mouseX,
                mouseY,
                partialTick
        );

        renderTooltip(
                guiGraphics,
                mouseX,
                mouseY
        );
    }
}
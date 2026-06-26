package net.miguelx46.programminggoods.client.renderer;

import net.miguelx46.programminggoods.ProgrammingGoods;
import net.minecraft.client.renderer.entity.CreeperRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Creeper;

public class JavaCreeperRenderer extends CreeperRenderer {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(
                    ProgrammingGoods.MOD_ID,
                    "textures/entity/java_creeper.png");

    public JavaCreeperRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(Creeper entity) {
        return TEXTURE;
    }
}
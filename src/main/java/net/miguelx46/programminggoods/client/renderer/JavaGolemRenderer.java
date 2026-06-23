package net.miguelx46.programminggoods.client.renderer;

import net.miguelx46.programminggoods.ProgrammingGoods;
import net.miguelx46.programminggoods.entity.custom.JavaGolemEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.IronGolemRenderer;
import net.minecraft.resources.ResourceLocation;

public class JavaGolemRenderer extends IronGolemRenderer {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(
                    ProgrammingGoods.MOD_ID,
                    "textures/entity/java_golem.png");

    public JavaGolemRenderer(
            EntityRendererProvider.Context context) {

        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(
            net.minecraft.world.entity.animal.IronGolem entity) {

        return TEXTURE;
    }
}
package net.miguelx46.programminggoods.client.renderer;

import net.miguelx46.programminggoods.ProgrammingGoods;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.SpiderRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Spider;

public class JavaSpiderRenderer extends SpiderRenderer<Spider> {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(
                    ProgrammingGoods.MOD_ID,
                    "textures/entity/java_spider.png");

    public JavaSpiderRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(Spider entity) {
        return TEXTURE;
    }
}
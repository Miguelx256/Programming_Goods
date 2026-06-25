package net.miguelx46.programminggoods.client.renderer;

import net.miguelx46.programminggoods.ProgrammingGoods;
import net.miguelx46.programminggoods.entity.custom.JavaZombieEntity;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ZombieRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.monster.Zombie;

public class JavaZombieRenderer extends ZombieRenderer {

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(
                    ProgrammingGoods.MOD_ID,
                    "textures/entity/java_zombie.png");

    public JavaZombieRenderer(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public ResourceLocation getTextureLocation(Zombie entity) {
        return TEXTURE;
    }
}
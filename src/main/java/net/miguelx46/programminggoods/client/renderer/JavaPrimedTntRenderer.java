package net.miguelx46.programminggoods.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.miguelx46.programminggoods.entity.custom.JavaPrimedTnt;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.block.BlockRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;

public class JavaPrimedTntRenderer extends EntityRenderer<JavaPrimedTnt> {

    private final BlockRenderDispatcher blockRenderer;

    public JavaPrimedTntRenderer(EntityRendererProvider.Context context) {

        super(context);

        this.blockRenderer = context.getBlockRenderDispatcher();

        this.shadowRadius = 0.5F;
    }

    @Override
    public void render(
            JavaPrimedTnt entity,
            float entityYaw,
            float partialTicks,
            PoseStack poseStack,
            MultiBufferSource buffer,
            int packedLight) {

        poseStack.pushPose();

        blockRenderer.renderSingleBlock(
                Blocks.TNT.defaultBlockState(),
                poseStack,
                buffer,
                packedLight,
                OverlayTexture.NO_OVERLAY
        );

        poseStack.popPose();

        super.render(
                entity,
                entityYaw,
                partialTicks,
                poseStack,
                buffer,
                packedLight
        );
    }

    @Override
    public ResourceLocation getTextureLocation(JavaPrimedTnt entity) {

        return null;
    }
}
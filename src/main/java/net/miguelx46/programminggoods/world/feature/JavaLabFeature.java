package net.miguelx46.programminggoods.world.feature;

import com.mojang.serialization.Codec;
import net.miguelx46.programminggoods.ProgrammingGoods;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructurePlaceSettings;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

public class JavaLabFeature extends Feature<NoneFeatureConfiguration> {

    private static final Logger LOGGER = LogUtils.getLogger();

    public JavaLabFeature(
            Codec<NoneFeatureConfiguration> codec) {

        super(codec);
    }

    @Override
    public boolean place(
            FeaturePlaceContext<NoneFeatureConfiguration> context) {

        if (!(context.level() instanceof ServerLevel level)) {
            return false;
        }

        StructureTemplate template =
                level.getStructureManager()
                        .getOrCreate(
                                ResourceLocation.fromNamespaceAndPath(
                                        ProgrammingGoods.MOD_ID,
                                        "java_lab"
                                )
                        );

        BlockPos pos = context.origin();
        LOGGER.info("JAVA LAB GENERATED AT {}", pos);

        template.placeInWorld(
                level,
                pos,
                pos,
                new StructurePlaceSettings(),
                level.random,
                2
        );
        template.placeInWorld(
                level,
                pos,
                pos,
                new StructurePlaceSettings(),
                level.random,
                2
        );

        return true;
    }
}
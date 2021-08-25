package cofh.thermal.horizons.world.gen.feature;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.AcaciaFoliagePlacer;
import net.minecraft.world.gen.foliageplacer.JungleFoliagePlacer;
import net.minecraft.world.gen.placement.DepthAverageConfig;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraft.world.gen.trunkplacer.MegaJungleTrunkPlacer;
import net.minecraft.world.gen.trunkplacer.StraightTrunkPlacer;

import static cofh.lib.util.constants.Constants.ID_THERMAL;
import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.lib.common.ThermalIDs.ID_ELASTICA_LEAVES;
import static cofh.thermal.lib.common.ThermalIDs.ID_ELASTICA_LOG;

public class THorzFeatures {

    private THorzFeatures() {

    }

    public static void setup() {

        RUBBER_TREE = register("rubber_tree",
                Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(BLOCKS.get(ID_ELASTICA_LOG).getDefaultState()),
                        new SimpleBlockStateProvider(BLOCKS.get(ID_ELASTICA_LEAVES).getDefaultState()),
                        new AcaciaFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0)),
                        new StraightTrunkPlacer(3, 2, 0),
                        new TwoLayerFeature(1, 0, 1)))
                        .setIgnoreVines()
                        .build()));

        MEGA_RUBBER_TREE = register("mega_rubber_tree",
                Feature.TREE.withConfiguration((new BaseTreeFeatureConfig.Builder(
                        new SimpleBlockStateProvider(BLOCKS.get(ID_ELASTICA_LOG).getDefaultState()),
                        new SimpleBlockStateProvider(BLOCKS.get(ID_ELASTICA_LEAVES).getDefaultState()),
                        new JungleFoliagePlacer(FeatureSpread.func_242252_a(2), FeatureSpread.func_242252_a(0), 2),
                        new MegaJungleTrunkPlacer(7, 2, 2),
                        new TwoLayerFeature(1, 1, 2)))
                        .setIgnoreVines()
                        .build()));
    }

    private static <FC extends IFeatureConfig> ConfiguredFeature<FC, ?> register(String key, ConfiguredFeature<FC, ?> configuredFeature) {

        return Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(ID_THERMAL, key), configuredFeature);
    }

    private static DepthAverageConfig depthRange(int base, int spread) {

        return new DepthAverageConfig(base, spread);
    }

    private static TopSolidRangeConfig topRange(int min, int max) {

        return new TopSolidRangeConfig(min, min, max);
    }

    public static ConfiguredFeature<BaseTreeFeatureConfig, ?> RUBBER_TREE;
    public static ConfiguredFeature<BaseTreeFeatureConfig, ?> MEGA_RUBBER_TREE;

}
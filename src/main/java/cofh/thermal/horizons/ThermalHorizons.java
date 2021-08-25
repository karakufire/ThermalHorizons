package cofh.thermal.horizons;

import cofh.thermal.horizons.init.THorzBlocks;
import cofh.thermal.horizons.world.gen.feature.THorzFeatures;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import static cofh.lib.util.constants.Constants.ID_THERMAL_HORIZONS;
import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.lib.common.ThermalIDs.ID_ELASTICA_SAPLING;

@Mod(ID_THERMAL_HORIZONS)
public class ThermalHorizons {

    public ThermalHorizons() {

        setFeatureFlags();

        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);

        THorzBlocks.register();
    }

    private void setFeatureFlags() {

    }

    // region INITIALIZATION
    private void commonSetup(final FMLCommonSetupEvent event) {

        event.enqueueWork(THorzBlocks::setup);

        event.enqueueWork(THorzFeatures::setup);
    }

    private void clientSetup(final FMLClientSetupEvent event) {

        registerRenderLayers();
    }
    // endregion

    // region HELPERS
    private void registerRenderLayers() {

        RenderType cutout = RenderType.getCutout();

        RenderTypeLookup.setRenderLayer(BLOCKS.get(ID_ELASTICA_SAPLING), cutout);
        RenderTypeLookup.setRenderLayer(BLOCKS.get("elastica_door"), cutout);
    }
    // endregion
}

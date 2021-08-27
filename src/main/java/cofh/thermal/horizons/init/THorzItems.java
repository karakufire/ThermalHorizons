package cofh.thermal.horizons.init;

import cofh.core.item.SignItemCoFH;
import net.minecraft.item.Item;

import static cofh.lib.util.constants.Constants.ID_THERMAL_HORIZONS;
import static cofh.thermal.core.ThermalCore.BLOCKS;
import static cofh.thermal.core.util.RegistrationHelper.registerItem;
import static cofh.thermal.lib.common.ThermalItemGroups.THERMAL_BLOCKS;

public class THorzItems {

    private THorzItems() {

    }

    public static void register() {

        registerItem("elastica_sign", () -> new SignItemCoFH(new Item.Properties().maxStackSize(16).group(THERMAL_BLOCKS), BLOCKS.get("elastica_sign"), BLOCKS.get("elastica_wall_sign")).setModId(ID_THERMAL_HORIZONS));
    }

}
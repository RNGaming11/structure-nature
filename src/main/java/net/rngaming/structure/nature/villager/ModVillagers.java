package net.rngaming.structure.nature.villager;

import net.fabricmc.fabric.api.object.builder.v1.world.poi.PointOfInterestHelper;
import net.minecraft.block.Block;
import net.minecraft.util.Identifier;
import net.minecraft.world.poi.PointOfInterestType;
import net.rngaming.structure.nature.StructureNature;

public class ModVillagers {


    public static PointOfInterestType registerPOI(String name, Block block) {
        return PointOfInterestHelper.register(Identifier.of(StructureNature.MOD_ID, name),
                1, 1, Immuta)
    }

    public static void registerVillagers() {
        StructureNature.LOGGER.debug("Loading Villagers for " + StructureNature.MOD_ID);
    }
}

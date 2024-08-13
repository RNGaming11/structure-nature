package net.rngaming.structure.nature;

import net.fabricmc.api.ClientModInitializer;

public class StructureNatureClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {

    }

    public static void registerPlayerClient() {
        StructureNature.LOGGER.info("Getting World files for " + StructureNature.MOD_ID);
        StructureNature.LOGGER.info("Loading Structures from " + StructureNature.MOD_ID);
    }
}

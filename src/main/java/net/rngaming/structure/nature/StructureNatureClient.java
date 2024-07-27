package net.rngaming.structure.nature;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class StructureNatureClient implements ClientModInitializer {
    public static final String ID = "structure-nature";

    @Override
    public void onInitializeClient() {

    }
    public static Identifier asId(String path) {
        return Identifier.of(ID, path);
    }

    public static void registerPlayerClient() {
        StructureNature.LOGGER.info("Getting World files for " + StructureNature.MOD_ID);
        StructureNature.LOGGER.info("Loading Structures from " + StructureNature.MOD_ID);
    }
}

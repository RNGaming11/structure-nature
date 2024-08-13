package net.rngaming.structure.nature;

import net.fabricmc.api.ModInitializer;
import net.kyrptonaught.customportalapi.api.CustomPortalBuilder;
import net.minecraft.util.Identifier;
import net.rngaming.structure.nature.blocks.ModBlocks;
import net.rngaming.structure.nature.config.ModConfig;
import net.rngaming.structure.nature.item.ModItemGroups;
import net.rngaming.structure.nature.item.ModItems;
import net.rngaming.structure.nature.util.OptimizedEventManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StructureNature implements ModInitializer { // Implement ClientModInitializer
	public static final String MOD_ID = "structure-nature";
	public static final String MOD_VERSION = "1.1"; // Upblockate this with your mod version
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// Log mod initialization
		LOGGER.info("Initializing Structure Nature Mod");
		// Register Config
		LOGGER.info("Registering Config");
		ModConfig.registerConfigs();
		LOGGER.info("Config Registered");

		// Register item groups
		LOGGER.info("Registering item groups...");
		ModItemGroups.registerItemGroups();
		LOGGER.info("Item groups registered.");

		// Register items
		LOGGER.info("Registering mod items...");
		ModItems.registerModItems();
		LOGGER.info("Mod items registered.");

		// Register blocks
		LOGGER.info("Registering mod blocks...");
		ModBlocks.registerModBlocks();
		LOGGER.info("Mod blocks registered.");

		StructureNatureClient.registerPlayerClient();

		// Initialize the optimized event manager
		LOGGER.info("Initializing Optimized Event Manager...");
		new OptimizedEventManager();

		// Register portal
		registerPortalIfNeeded();
	}

	private void registerPortalIfNeeded() {
		Identifier portalId = Identifier.of(MOD_ID, "magic_dim");
		LOGGER.info("Checking if portal is already registered for dimension: {}", portalId);
		if (!isPortalRegistered(portalId)) {
			LOGGER.info("Portal not registered. Registering portal...");
			CustomPortalBuilder.beginPortal()
					.frameBlock(ModBlocks.MAGIC_BLOCK)
					.lightWithItem(ModItems.MAGIC_GEM)
					.destDimID(portalId)
					.registerPortal();
			LOGGER.info("Portal registered successfully.");
		} else {
			LOGGER.info("Portal is already registered. Skipping registration.");
		}
	}

	private boolean isPortalRegistered(Identifier identifier) {
		return false; // Placeholder for actual portal registration check
	}
}
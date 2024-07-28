package net.rngaming.structure.nature;

import net.fabricmc.api.ModInitializer;

import net.minecraft.registry.Registerable;
import net.minecraft.world.dimension.DimensionType;
import net.rngaming.structure.nature.blocks.ModBlocks;
import net.rngaming.structure.nature.item.ModItemGroups;
import net.rngaming.structure.nature.item.ModItems;
import net.rngaming.structure.nature.world.biome.ModBiomes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class StructureNature implements ModInitializer {
	public static final String MOD_ID = "structure-nature";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		StructureNatureClient.registerPlayerClient();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}
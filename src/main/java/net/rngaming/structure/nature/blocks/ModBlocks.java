package net.rngaming.structure.nature.blocks;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rngaming.structure.nature.StructureNature;

public class ModBlocks {
    public static final Block MAGIC_BLOCK = registerBlock("magic_block",
            new Block(FabricBlockSettings.copyOf(Blocks.OBSIDIAN)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(StructureNature.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, Identifier.of(StructureNature.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        StructureNature.LOGGER.info("Registering ModBlocks for" + StructureNature.MOD_ID);
    }
}

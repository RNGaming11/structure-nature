package net.rngaming.structure.nature.item;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.mixin.item.ItemSettingsMixin;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rngaming.structure.nature.StructureNature;

public class ModItems {
    public static final Item MAGIC_SHARD = registerItem("magic_shard",
            new Item(new Item.Settings()));


    private static void addItemToIngredientTabItemGroup(FabricItemGroupEntries entries) {
        entries.add(MAGIC_SHARD);
    }

        public static final Item MAGIC_SWORD = registerItem("magic_sword",
                new SwordItem(ModToolMaterial.MAGIC_SWORD, new Item.Settings()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(StructureNature.MOD_ID, name), item);
    }

    public static void registerModIems() {
        StructureNature.LOGGER.info("Registering Mod Items for " + StructureNature.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemToIngredientTabItemGroup);
    }
}

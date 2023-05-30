package dev.destinysoul.soulrpg.items.Magic;

import dev.destinysoul.soulrpg.SoulRPG;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class MagicItems {
    public static final Item magic_crystal = registerItem("magic_crystal",
            new Item(new FabricItemSettings()));

    public static final Item uncharged_magic_crystal=registerItem("uncharged_magic_crystal",
            new Item(new FabricItemSettings()));
    private static Item registerItem(String name,Item item){
        return Registry.register(Registries.ITEM,new Identifier(SoulRPG.MOD_ID, name), item);
    }
    public static void addItemsToItemGroup() {
        addItemToItemGroup(MagicClass.Magic,magic_crystal);
        addItemToItemGroup(MagicClass.Magic,uncharged_magic_crystal);
    }

    private static void addItemToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
    public static void register() {
        SoulRPG.LOGGER.info("Registering  Magic Items for " + SoulRPG.MOD_ID);
        addItemsToItemGroup();
    }
}

package dev.destinysoul.soulrpg.magic.item;

import dev.destinysoul.soulrpg.SoulRPG;
import dev.destinysoul.soulrpg.magic.MagicClass;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class MagicItems {
    public static final Item magic_crystal = registerItem("magic_crystal",
            new Item(new FabricItemSettings()));

    public static final Item uncharged_magic_crystal = registerItem("uncharged_magic_crystal",
            new Item(new FabricItemSettings()));

    public static final Item magic_crystal_ore_sand = registerItem("magic_crystal_ore_sand",
            new Item(new FabricItemSettings()));

    private static Item registerItem(String name,Item item){
        Item i = Registry.register(Registries.ITEM,new Identifier(SoulRPG.ID, name), item);
        ItemGroupEvents.modifyEntriesEvent(MagicClass.Magic).register(entries -> entries.add(i));
        return i;
    }
    public static void register() {
        SoulRPG.LOGGER.info("Registering  Magic Items for " + SoulRPG.ID);
    }
}

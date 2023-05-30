package dev.destinysoul.soulrpg.items;

import dev.destinysoul.soulrpg.SoulRPG;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class MagicItems {
    public static final Item MAGIC_CRYSTAL = registerItem("magic_crystal",
            new Item(new FabricItemSettings()));
    public static ItemGroup Magic = FabricItemGroup.builder(new Identifier(SoulRPG.MOD_ID, "magic"))
            .displayName(Text.translatable("itemgroup.magic"))
            .icon(() -> new ItemStack(MAGIC_CRYSTAL)).build();

    public static void addItemsToItemGroup() {
        addToItemGroup(Magic,MAGIC_CRYSTAL);
    }

    private static void addToItemGroup(ItemGroup group, Item item) {
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
    }
    public static void registerItems() {
        SoulRPG.LOGGER.info("Registering  MagicItems for " + SoulRPG.MOD_ID);

        addItemsToItemGroup();
    }
    private static Item registerItem(String name,Item item){
        return Registry.register(Registries.ITEM,new Identifier(SoulRPG.MOD_ID, name), item);
    }

}

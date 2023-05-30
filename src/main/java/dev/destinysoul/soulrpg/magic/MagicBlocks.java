package dev.destinysoul.soulrpg.magic;

import dev.destinysoul.soulrpg.SoulRPG;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class MagicBlocks {
    public static final Block magic_crystal_ore = registerBlock("magic_crystal_ore",
                new ExperienceDroppingBlock(FabricBlockSettings.of(Material.METAL).strength(2.5f).requiresTool(), UniformIntProvider.create(1, 5)), MagicClass.Magic);


    private static Block registerBlock(String name, Block block, ItemGroup group) {
        registerBlockItem(name, block, group);
        return Registry.register(Registries.BLOCK, new Identifier(SoulRPG.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block, ItemGroup group) {
        Item item = Registry.register(Registries.ITEM, new Identifier(SoulRPG.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
        ItemGroupEvents.modifyEntriesEvent(group).register(entries -> entries.add(item));
        return item;
    }

    public static void register() {
        SoulRPG.LOGGER.info("Registering Magic Blocks for " + SoulRPG.MOD_ID);
    }
}

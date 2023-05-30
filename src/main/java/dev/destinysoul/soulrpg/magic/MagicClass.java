package dev.destinysoul.soulrpg.magic;

import dev.destinysoul.soulrpg.SoulRPG;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static dev.destinysoul.soulrpg.magic.MagicItems.magic_crystal;


public class MagicClass {
    public static ItemGroup Magic = FabricItemGroup.builder(new Identifier(SoulRPG.MOD_ID, "magic"))
            .displayName(Text.translatable("itemgroup.magic"))
            .icon(() -> new ItemStack(magic_crystal)).build();
    public static void register(){
        MagicItems.register();
        MagicBlocks.register();
        MagicOres.register();
    }



}

package dev.destinysoul.soulrpg.magic;

import dev.destinysoul.soulrpg.SoulRPG;
import dev.destinysoul.soulrpg.magic.block.MagicBlocks;
import dev.destinysoul.soulrpg.magic.item.MagicItems;
import dev.destinysoul.soulrpg.magic.world.gen.MagicOres;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import static dev.destinysoul.soulrpg.magic.item.MagicItems.magic_crystal;
public class MagicClass {
    public static ItemGroup Magic = FabricItemGroup.builder(new Identifier(SoulRPG.ID, "magic"))
            .displayName(Text.translatable("itemgroup.magic"))
            .icon(() -> new ItemStack(magic_crystal)).build();

    public static void register(){
        MagicItems.register();
        MagicBlocks.register();
        MagicOres.register();
    }
    public static void registerClient(){
        BlockRenderLayerMap.INSTANCE.putBlock(MagicBlocks.coal_fired_refining_furnace, RenderLayer.getCutout());
    }
}

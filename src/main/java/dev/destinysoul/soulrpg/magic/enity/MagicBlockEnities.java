package dev.destinysoul.soulrpg.magic.enity;


import dev.destinysoul.soulrpg.SoulRPG;
import dev.destinysoul.soulrpg.magic.block.MagicBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class MagicBlockEnities {
    public static BlockEntityType<CoalFiredRefiningFurnaceBlockEnity> CoalFiredRefiningFurnaceBlock;

    public static void register(){
        BlockEntityType<CoalFiredRefiningFurnaceBlockEnity> CoalFiredRefiningFurnaceBlockEnity = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(SoulRPG.ID, "coal_fired_refining_furnace"),
                FabricBlockEntityTypeBuilder.create(dev.destinysoul.soulrpg.magic.enity.CoalFiredRefiningFurnaceBlockEnity::new,
                        MagicBlocks.coal_fired_refining_furnace).build(null));
    }
}

package dev.destinysoul.soulrpg.magic;
import dev.destinysoul.soulrpg.SoulRPG;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class MagicOres {
    public static final RegistryKey<PlacedFeature> magic_crystal_ore_placed = RegistryKey.of(RegistryKeys.PLACED_FEATURE,
            new Identifier(SoulRPG.MOD_ID,"magic_crystal_ore"));
    public static void register(){
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, magic_crystal_ore_placed);
    }

}

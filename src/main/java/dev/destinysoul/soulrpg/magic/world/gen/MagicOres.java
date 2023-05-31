package dev.destinysoul.soulrpg.magic.world.gen;
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
            new Identifier(SoulRPG.ID,"magic_crystal_ore"));
    public static void addOresToBiome(){
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, magic_crystal_ore_placed);
    }
    public static void register(){
        SoulRPG.LOGGER.info("Registering Magic Ores for " + SoulRPG.ID);
        addOresToBiome();
    }

}

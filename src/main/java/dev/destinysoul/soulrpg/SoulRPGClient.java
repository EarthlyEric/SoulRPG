package dev.destinysoul.soulrpg;

import dev.destinysoul.soulrpg.system.MPHUDOverlay;
import net.fabricmc.api.ClientModInitializer;

public class SoulRPGClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MPHUDOverlay.register();
    }
}

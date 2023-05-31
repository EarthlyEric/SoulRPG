package dev.destinysoul.soulrpg;

import dev.destinysoul.soulrpg.magic.MagicClass;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SoulRPG implements ModInitializer {
    public static final String ID = "soulrpg";
    public static final Logger LOGGER = LoggerFactory.getLogger("SoulRPG");

    @Override
    public void onInitialize() {
        LOGGER.info("SoulRPG Initializing...");
        MagicClass.register();
    }
}
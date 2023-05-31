package dev.destinysoul.soulrpg.mixin;

import dev.destinysoul.soulrpg.SoulRPG;
import net.minecraft.client.gui.screen.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(TitleScreen.class)
public class SoulRPGMixin {
	@Inject(at = @At("HEAD"), method = "init()V")
	private void init(CallbackInfo info) {
		SoulRPG.LOGGER.info("SoulRPG Mixin is Ready ! ");
	}
}
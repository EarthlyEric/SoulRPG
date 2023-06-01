package dev.destinysoul.soulrpg.system;

import com.mojang.blaze3d.systems.RenderSystem;
import dev.destinysoul.soulrpg.SoulRPG;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.Font;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class MPHUDOverlay implements HudRenderCallback {
    public static final Identifier empty_mp_bar = new Identifier(SoulRPG.ID,"textures/gui/empty_bar.png");
    @Override
    public void onHudRender(MatrixStack matrixStack, float tickDelta) {
        // init HUD position
        int x = 0;
        int y = 0;

        TextRenderer textRenderer = MinecraftClient.getInstance().inGameHud.getTextRenderer();

        MinecraftClient client = MinecraftClient.getInstance();
        if(client != null){
            y = client.getWindow().getScaledHeight();
        }

        RenderSystem.setShader(GameRenderer::getPositionTexProgram);
        RenderSystem.setShaderColor(1.0f,1.0f,1.0f,1.0f);
        RenderSystem.setShaderTexture(0,empty_mp_bar);
        DrawableHelper.drawTexture(matrixStack,x,y-10,0,0,10,104,10,104,10);


    }
    public static void register(){
        SoulRPG.LOGGER.info("Registering MP HUD for " + SoulRPG.ID);
        HudRenderCallback.EVENT.register(new MPHUDOverlay());
    }
}

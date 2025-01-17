package me.lyric.infinity.mixin.mixins.gui;

import me.lyric.infinity.impl.modules.misc.BetterChat;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiNewChat;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={GuiNewChat.class})
public class MixinGuiNewChat {
    @Final
    @Shadow
    public Minecraft mc = Minecraft.getMinecraft();
    //TODO: Bad and scheduled for removal.

    @Redirect(method = {"drawChat"}, at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/GuiNewChat;drawRect(IIIII)V"))
    public void drawChatHook1(int left, int top, int right, int bottom, int color) {
        if (BetterChat.getInstance().isEnabled() && BetterChat.getInstance().giantBeetleSoundsLikeJackhammer.getValue()) {
            Gui.drawRect(left, top, right, bottom, 0);
        } else {
            Gui.drawRect(left, top, right, bottom, color);
        }
    }
}
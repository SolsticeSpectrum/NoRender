package org.norender.mixin;

import net.minecraft.client.gui.hud.BossBarHud;
import org.norender.NoRender;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BossBarHud.class)
public class MixinBossBarHud {
    @Inject(method = "render", at = @At("HEAD"), cancellable = true)
    public void render(CallbackInfo callback) {
        if (NoRender.getInstance().isEnabled4()) {
            callback.cancel();
        }
    }
}

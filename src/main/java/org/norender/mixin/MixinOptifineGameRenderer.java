package org.norender.mixin;

import net.minecraft.client.render.Camera;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import org.norender.NoRender;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameRenderer.class)
public class MixinOptifineGameRenderer {
    // Optifine sure gave me a headache. Thanks to fayer3#2332 for figuring this shit out.
    @Inject(at = @At("HEAD"), method = "Lnet/minecraft/client/render/GameRenderer;renderHand(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/Camera;FZZZ)V", cancellable = true)
    public void onRenderHand(MatrixStack matrixStackIn, Camera activeRenderInfoIn, float partialTicks, boolean renderItem, boolean renderOverlay, boolean renderTranslucent, CallbackInfo info) {
        if (NoRender.getInstance().isEnabled6())
            info.cancel();
    }
}


package org.norender.mixin;

import net.minecraft.client.util.math.MatrixStack;
import org.norender.NoRender;
import org.spongepowered.asm.mixin.Mixin;
import xaero.common.XaeroMinimapSession;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xaero.common.interfaces.render.InterfaceRenderer;

@Mixin(InterfaceRenderer.class)
public class MixinInterfaceRenderer {
    @Inject(method = "renderInterfaces", at = @At("HEAD"), cancellable = true, remap = false)
    public void onRenderInterfaces(XaeroMinimapSession minimapSession, MatrixStack matrixStack, float partial, CallbackInfo info) {
        if (NoRender.getInstance().isEnabled8()) {
            info.cancel();
        }
    }
}

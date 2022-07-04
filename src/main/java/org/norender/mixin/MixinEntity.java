package org.norender.mixin;

import net.minecraft.entity.Entity;
import org.norender.NoRender;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class MixinEntity {
    @Inject(method = "isGlowing", at = @At("HEAD"), cancellable=true)
    private void onIsGlowing(CallbackInfoReturnable<Boolean> info) {
        if (NoRender.getInstance().isEnabled2()) {
            info.setReturnValue(false);
        }
    }

    @Inject(method = "shouldSpawnSprintingParticles", at = @At("HEAD"), cancellable=true)
    private void onShouldSpawnSprintingParticles(CallbackInfoReturnable<Boolean> info) {
        if (NoRender.getInstance().isEnabled7()) {
            info.setReturnValue(false);
        }
    }
}

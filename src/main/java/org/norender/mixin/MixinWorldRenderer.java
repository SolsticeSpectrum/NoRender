package org.norender.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Matrix4f;
import org.norender.NoRender;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public class MixinWorldRenderer {
    /*@Inject(method = "render", at = @At("HEAD"), cancellable = true)
    public void onRender(MatrixStack matrices, float tickDelta, long limitTime, boolean renderBlockOutline, Camera camera, GameRenderer gameRenderer, LightmapTextureManager lightmapTextureManager, Matrix4f positionMatrix, CallbackInfo info) {
        if (NoRender.getInstance().isEnabled8()) {
            info.cancel();
        }
    }*/

    @Inject(method = "drawBlockOutline", at = @At("HEAD"), cancellable = true)
    public void onDrawBlockOutline(MatrixStack matrices, VertexConsumer vertexConsumer, Entity entity, double d, double e, double f, BlockPos pos, BlockState state, CallbackInfo info) {
        if (NoRender.getInstance().isEnabled7()) {
            info.cancel();
        }
    }
}

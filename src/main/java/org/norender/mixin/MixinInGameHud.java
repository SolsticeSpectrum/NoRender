package org.norender.mixin;

import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.scoreboard.ScoreboardObjective;
import org.norender.NoRender;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class MixinInGameHud {

	@Inject(method = "renderScoreboardSidebar", at = @At("HEAD"), cancellable = true)
	public void renderScoreboardSidebar(MatrixStack matrices, ScoreboardObjective objective, CallbackInfo callback) {
		if (NoRender.getInstance().isEnabled1()) {
			callback.cancel();
		}
	}

	@Inject(method = "renderCrosshair", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/option/Perspective;isFirstPerson()Z"), cancellable = true)
	public void renderCrosshair(MatrixStack matrices, CallbackInfo callback) {
		if (NoRender.getInstance().isEnabled3()) {
			callback.cancel();
		}
	}

	@Inject(method = "renderHotbar", at = @At("HEAD"), cancellable = true)
	public void renderHotbar(float tickDelta, MatrixStack matrices, CallbackInfo callback) {
		if (NoRender.getInstance().isEnabled4()) {
			callback.cancel();
		}
	}

	@Inject(method = "renderStatusEffectOverlay", at = @At("HEAD"), cancellable = true)
	public void renderStatusEffectOverlay(MatrixStack matrices, CallbackInfo callback) {
		if (NoRender.getInstance().isEnabled4()) {
			callback.cancel();
		}
	}

	@Inject(method = "renderMountJumpBar", at = @At("HEAD"), cancellable = true)
	public void renderMountJumpBar(MatrixStack matrices, int x, CallbackInfo callback) {
		if (NoRender.getInstance().isEnabled4()) {
			callback.cancel();
		}
	}

	@Inject(method = "renderExperienceBar", at = @At("HEAD"), cancellable = true)
	public void renderExperienceBar(MatrixStack matrices, int x, CallbackInfo callback) {
		if (NoRender.getInstance().isEnabled4()) {
			callback.cancel();
		}
	}

	@Inject(method = "renderStatusBars", at = @At("HEAD"), cancellable = true)
	public void renderStatusBars(MatrixStack matrices, CallbackInfo callback) {
		if (NoRender.getInstance().isEnabled4()) {
			callback.cancel();
		}
	}

	@Inject(method = "renderMountHealth", at = @At("HEAD"), cancellable = true)
	public void renderMountHealth(MatrixStack matrices, CallbackInfo callback) {
		if (NoRender.getInstance().isEnabled4()) {
			callback.cancel();
		}
	}
}

package org.norender.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.scoreboard.ScoreboardObjective;
import net.minecraft.text.Text;
import org.norender.NoRender;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(InGameHud.class)
public class MixinInGameHud {
	@Inject(method = "renderScoreboardSidebar", at = @At("HEAD"), cancellable = true)
	public void onRenderScoreboardSidebar(MatrixStack matrices, ScoreboardObjective objective, CallbackInfo info) {
		if (NoRender.getInstance().isEnabled1()) {
			info.cancel();
		}
	}

	@Inject(method = "renderCrosshair", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/option/Perspective;isFirstPerson()Z"), cancellable = true)
	public void onRenderCrosshair(MatrixStack matrices, CallbackInfo info) {
		if (NoRender.getInstance().isEnabled3()) {
			info.cancel();
		}
	}

	@Inject(method = "renderHotbar", at = @At("HEAD"), cancellable = true)
	public void onRenderHotbar(float tickDelta, MatrixStack matrices, CallbackInfo info) {
		if (NoRender.getInstance().isEnabled4()) {
			info.cancel();
		}
	}

	@Inject(method = "renderStatusEffectOverlay", at = @At("HEAD"), cancellable = true)
	public void onRenderStatusEffectOverlay(MatrixStack matrices, CallbackInfo info) {
		if (NoRender.getInstance().isEnabled4()) {
			info.cancel();
		}
	}

	@Inject(method = "renderMountJumpBar", at = @At("HEAD"), cancellable = true)
	public void onRenderMountJumpBar(MatrixStack matrices, int x, CallbackInfo info) {
		if (NoRender.getInstance().isEnabled4()) {
			info.cancel();
		}
	}

	@Inject(method = "renderExperienceBar", at = @At("HEAD"), cancellable = true)
	public void onRenderExperienceBar(MatrixStack matrices, int x, CallbackInfo info) {
		if (NoRender.getInstance().isEnabled4()) {
			info.cancel();
		}
	}

	@Inject(method = "renderStatusBars", at = @At("HEAD"), cancellable = true)
	public void onRenderStatusBars(MatrixStack matrices, CallbackInfo info) {
		if (NoRender.getInstance().isEnabled4()) {
			info.cancel();
		}
	}

	@Inject(method = "renderMountHealth", at = @At("HEAD"), cancellable = true)
	public void onRenderMountHealth(MatrixStack matrices, CallbackInfo info) {
		if (NoRender.getInstance().isEnabled4()) {
			info.cancel();
		}
	}

	@Inject(method = "setTitle", at = @At("HEAD"), cancellable = true)
	public void onSetTitle(Text title, CallbackInfo info) {
		MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.literal("Title: ").append(title));
		info.cancel();
	}

	@Inject(method = "setSubtitle", at = @At("HEAD"), cancellable = true)
	public void onSetSubtitle(Text subtitle, CallbackInfo info) {
		MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.literal("Subtitle: ").append(subtitle));
		info.cancel();
	}

	@Inject(method = "setOverlayMessage", at = @At("HEAD"), cancellable = true)
	private void onSetOverlayMessage(Text message, boolean tinted, CallbackInfo info) {
		MinecraftClient.getInstance().inGameHud.getChatHud().addMessage(Text.literal("Action bar: ").append(message));
		info.cancel();
	}
}

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
		if (NoRender.getInstance().isEnabled()) {
			callback.cancel();
		}
	}
}

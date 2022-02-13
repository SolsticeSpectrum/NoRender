package org.norender;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class NoRender implements ModInitializer {
	private static KeyBinding keyBinding = KeyBindingHelper.registerKeyBinding(new KeyBinding(
        "key.norender.activate",
		InputUtil.Type.KEYSYM,
		GLFW.GLFW_KEY_K,
        "category.norender"
	));

	private boolean isEnabled;
	private static NoRender INSTANCE;

	@Override
	public void onInitialize() {
		if (INSTANCE == null) {
			INSTANCE = this;
		}

		ClientTickEvents.END_CLIENT_TICK.register(client -> {
			while (keyBinding.wasPressed()) {
				isEnabled = !isEnabled;
			}
		});
	}
	public static NoRender getInstance() {
		return INSTANCE;
	}

	public boolean isEnabled() {
		return isEnabled;
	}
}
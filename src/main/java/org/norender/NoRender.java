package org.norender;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class NoRender implements ModInitializer {
    private boolean isEnabled1;
    private boolean isEnabled2;
    private boolean isEnabled3;
    private boolean isEnabled4;
    private boolean isEnabled5;
    private boolean isEnabled6;
    private boolean isEnabled7;
    private boolean isEnabled8;
    private static KeyBinding keyBinding1;
    private static KeyBinding keyBinding2;
    private static KeyBinding keyBinding3;
    private static KeyBinding keyBinding4;
    private static KeyBinding keyBinding5;
    private static KeyBinding keyBinding6;
    private static KeyBinding keyBinding7;
    private static KeyBinding keyBinding8;
    //private static KeyBinding keyBinding0;
    private static NoRender INSTANCE;

    @Override
    public void onInitialize() {
        if (INSTANCE == null) {
            INSTANCE = this;
        }

        keyBinding1 = KeyBindingHelper.registerKeyBinding(new KeyBinding("Scoreboard", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_KP_1, "NoRender (press left ALT + Num)"));
        keyBinding2 = KeyBindingHelper.registerKeyBinding(new KeyBinding("Nametags + Glow", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_KP_2, "NoRender (press left ALT + Num)"));
        keyBinding3 = KeyBindingHelper.registerKeyBinding(new KeyBinding("Crosshair", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_KP_3, "NoRender (press left ALT + Num)"));
        keyBinding4 = KeyBindingHelper.registerKeyBinding(new KeyBinding("HUD", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_KP_4, "NoRender (press left ALT + Num)"));
        keyBinding5 = KeyBindingHelper.registerKeyBinding(new KeyBinding("Chat", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_KP_5, "NoRender (press left ALT + Num)"));
        keyBinding6 = KeyBindingHelper.registerKeyBinding(new KeyBinding("Hand", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_KP_6, "NoRender (press left ALT + Num)"));
        keyBinding7 = KeyBindingHelper.registerKeyBinding(new KeyBinding("Misc", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_KP_7, "NoRender (press left ALT + Num)"));
        //keyBinding8 = KeyBindingHelper.registerKeyBinding(new KeyBinding("World", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_KP_8, "NoRender (press left ALT + Num)"));
        keyBinding8 = KeyBindingHelper.registerKeyBinding(new KeyBinding("Minimap", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_KP_8, "NoRender (press left ALT + Num)"));
        //keyBinding0 = KeyBindingHelper.registerKeyBinding(new KeyBinding("Crash", InputUtil.Type.KEYSYM, GLFW.GLFW_KEY_KP_0, "NoRender (press left ALT + Num)"));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (InputUtil.isKeyPressed(MinecraftClient.getInstance().getWindow().getHandle(), GLFW.GLFW_KEY_LEFT_ALT)) {

                while (keyBinding1.wasPressed()) {
                    isEnabled1 = !isEnabled1;
                }

                while (keyBinding2.wasPressed()) {
                    isEnabled2 = !isEnabled2;
                }

                while (keyBinding3.wasPressed()) {
                    isEnabled3 = !isEnabled3;
                }

                while (keyBinding4.wasPressed()) {
                    isEnabled4 = !isEnabled4;
                }

                while (keyBinding5.wasPressed()) {
                    isEnabled5 = !isEnabled5;
                }

                while (keyBinding6.wasPressed()) {
                    isEnabled6 = !isEnabled6;
                }

                while (keyBinding7.wasPressed()) {
                    isEnabled7 = !isEnabled7;
                }

                while (keyBinding8.wasPressed()) {
                    isEnabled8 = !isEnabled8;
                }

                /*while (keyBinding0.wasPressed()) {
                    throw new RuntimeException("BOOM!");
                }*/
            }
        });
    }

    public static NoRender getInstance() {
        return INSTANCE;
    }
    public boolean isEnabled1() {
        return isEnabled1;
    }
    public boolean isEnabled2() {
        return isEnabled2;
    }
    public boolean isEnabled3() {
        return isEnabled3;
    }
    public boolean isEnabled4() {
        return isEnabled4;
    }
    public boolean isEnabled5() {
        return isEnabled5;
    }
    public boolean isEnabled6() {
        return isEnabled6;
    }
    public boolean isEnabled7() {
        return isEnabled7;
    }
    public boolean isEnabled8() {
        return isEnabled8;
    }
}
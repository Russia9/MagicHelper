package io.github.russia9.magichelper.lib;

import org.jnativehook.keyboard.NativeKeyEvent;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * Default Constants
 */
public class Reference {
    // Default buttons
    public static int AUTOCLICKER_DEFAULT_ACTIVATE_BUTTON = MouseEvent.BUTTON2;
    public static int AUTOMINER_DEFAULT_ACTIVATE_BUTTON = KeyEvent.VK_F4;
    public static final int AUTOCLICKER_DEFAULT_CLICK_BUTTON = InputEvent.getMaskForButton(1);

    // Constants
    public static final int AUTOCLICKER_DEFAULT_CLICK_TIME = 20;

}

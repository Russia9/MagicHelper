package io.github.russia9.magichelper.lib;

import org.jnativehook.mouse.NativeMouseEvent;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

/**
 * Default Constants
 */
public class Reference {
    // Default buttons
    /**
     * Default *NIX and MAC autoclicker activation button
     */
    public static final int AUTOCLICKER_DEFAULT_NIX_ACTIVATE_BUTTON = NativeMouseEvent.BUTTON2;
    /**
     * Default Windows autoclicker activation button
     */
    public static final int AUTOCLICKER_DEFAULT_WIN_ACTIVATE_BUTTON = NativeMouseEvent.BUTTON3;
    /**
     * Default autoclicker click button
     */
    public static final int AUTOCLICKER_DEFAULT_CLICK_BUTTON = InputEvent.getMaskForButton(1);
    /**
     * Default time between clicks
     */
    public static final int AUTOCLICKER_DEFAULT_CLICK_TIME = 20;
    /**
     * Default AutoMiner activation button
     */
    public static final int AUTOMINER_DEFAULT_ACTIVATE_BUTTON = KeyEvent.VK_F4;
    /**
     * Default AutoMiner activation button
     */
    public static final int BUTTONCLAMPER_DEFAULT_ACTIVATE_BUTTON = KeyEvent.VK_F7;
}

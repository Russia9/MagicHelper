package io.github.russia9.magichelper;

import io.github.russia9.magichelper.modules.autoClicker.Clicker;
import io.github.russia9.magichelper.lib.Helper;
import io.github.russia9.magichelper.lib.Reference;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.mouse.NativeMouseEvent;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Class to manage NativeHook Events
 */
class Manager {
    private static Clicker clicker;
    private boolean middleMouseButton;
    private int keyCode = -1;
    private int mouseCode = -1;

    Manager() throws NativeHookException {
        clicker = new Clicker();
        GlobalScreen.registerNativeHook();
        Hook hook = new Hook();
        GlobalScreen.addNativeMouseListener(hook);
        GlobalScreen.addNativeMouseMotionListener(hook);
        GlobalScreen.addNativeKeyListener(hook);
    }

    void mousePressed(NativeMouseEvent nativeMouseEvent) throws AWTException {
        if (nativeMouseEvent.getButton() == Reference.AUTOCLICKER_DEFAULT_ACTIVATE_BUTTON) {
            middleMouseButton = true;
        }
    }

    void mouseReleased(NativeMouseEvent nativeMouseEvent) throws AWTException {
        if (nativeMouseEvent.getButton() == Reference.AUTOCLICKER_DEFAULT_ACTIVATE_BUTTON) {
            if (clicker.isAlive()) {
                clicker.stop();
            } else {
                if (keyCode == -1 && mouseCode == -1) {
                    clicker.start();
                } else if (mouseCode != -1) {
                    clicker.start(0, mouseCode, Reference.AUTOCLICKER_DEFAULT_CLICK_TIME);
                } else {
                    clicker.start(1, keyCode, Reference.AUTOCLICKER_DEFAULT_CLICK_TIME);
                }
            }
            middleMouseButton = false;
        } else {
            if (middleMouseButton) {
                mouseCode = MouseEvent.getMaskForButton(nativeMouseEvent.getButton());
            } else {
                mouseCode = -1;
            }
        }
    }

    void keyPressed(NativeKeyEvent nativeKeyEvent) throws AWTException {

    }

    void keyReleased(NativeKeyEvent nativeKeyEvent) throws AWTException {
        if (middleMouseButton) {
            keyCode = Helper.getKeyCode(nativeKeyEvent);
        } else {
            keyCode = -1;
        }
    }
}

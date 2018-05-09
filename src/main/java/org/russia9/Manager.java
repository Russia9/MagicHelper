package org.russia9;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.mouse.NativeMouseEvent;
import org.russia9.autoClicker.Clicker;

import java.awt.*;

class Manager {
    private static Clicker clicker;
    private boolean middleMouseButtonPress;

    Manager() throws NativeHookException {
        clicker = new Clicker();
        GlobalScreen.registerNativeHook();
        Hook hook = new Hook();
        GlobalScreen.addNativeMouseListener(hook);
        GlobalScreen.addNativeMouseMotionListener(hook);
        GlobalScreen.addNativeKeyListener(hook);
    }

    void mousePressed(NativeMouseEvent nativeMouseEvent) throws AWTException {

    }

    void mouseReleased(NativeMouseEvent nativeMouseEvent) throws AWTException {
        if (nativeMouseEvent.getButton() == NativeMouseEvent.BUTTON3) {
            if (clicker.isAlive()) {
                clicker.stop();
            } else {
                clicker.start();
            }
            middleMouseButtonPress = false;
        }
    }

    void keyPressed(NativeKeyEvent nativeKeyEvent) throws AWTException {

    }

    void keyReleased(NativeKeyEvent nativeKeyEvent) throws AWTException {

    }
}

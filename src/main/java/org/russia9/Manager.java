package org.russia9;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.russia9.autoClicker.Clicker;

class Manager {
    static Clicker clicker;

    Manager() throws NativeHookException {
        clicker = new Clicker();
        GlobalScreen.registerNativeHook();
        Hook mouseHook = new Hook();
        GlobalScreen.addNativeMouseListener(mouseHook);
        GlobalScreen.addNativeMouseMotionListener(mouseHook);
    }
}

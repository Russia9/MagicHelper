package org.russia9;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;
import org.russia9.autoClicker.Clicker;

import java.awt.*;
import java.util.Set;

import static org.russia9.lib.Reference.*;


/**
 * <p>Class for capture key combinations.</p>
 *
 * @author Russia9
 * @since 0.1-SNAPSHOT
 */
public class Hook implements NativeKeyListener, NativeMouseInputListener {


    @Override
    public void nativeKeyTyped(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyPressed(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {

    }

    @Override
    public void nativeMouseClicked(NativeMouseEvent nativeMouseEvent) {
        if(nativeMouseEvent.getButton() == AUTOCLICKER_DEFAULT_ACTIVATE_BUTTON) {
            Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
            if(threadSet.size() > 1) { //Stop threads
                Manager.clicker.stop();
            }
        }
    }

    @Override
    public void nativeMousePressed(NativeMouseEvent nativeMouseEvent) {

    }

    @Override
    public void nativeMouseReleased(NativeMouseEvent nativeMouseEvent) {

    }

    @Override
    public void nativeMouseMoved(NativeMouseEvent nativeMouseEvent) {

    }

    @Override
    public void nativeMouseDragged(NativeMouseEvent nativeMouseEvent) {

    }


}

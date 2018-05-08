package org.russia9;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

import java.awt.*;
import java.util.Set;

import static org.russia9.lib.Reference.AUTOCLICKER_DEFAULT_CLICK_BUTTON;
import static org.russia9.lib.Reference.AUTOCLICKER_DEFAULT_CLICK_TIME;


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
        if (nativeMouseEvent.getButton() == NativeMouseEvent.BUTTON2) {
            Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
            if (threadSet.size() > 2) { //Stop threads
                Manager.clicker.stop();
            } else {
                try {
                    Manager.clicker.start(0, AUTOCLICKER_DEFAULT_CLICK_BUTTON, AUTOCLICKER_DEFAULT_CLICK_TIME);
                } catch (AWTException e) {
                    e.printStackTrace();
                }
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

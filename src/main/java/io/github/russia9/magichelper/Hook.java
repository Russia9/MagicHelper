package io.github.russia9.magichelper;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;

import java.awt.*;


/**
 * Class for capture key combinations.
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
        try {
            MagicHelper.manager.keyPressed(nativeKeyEvent);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void nativeKeyReleased(NativeKeyEvent nativeKeyEvent) {
        try {
            MagicHelper.manager.keyReleased(nativeKeyEvent);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void nativeMouseClicked(NativeMouseEvent nativeMouseEvent) {

    }

    @Override
    public void nativeMousePressed(NativeMouseEvent nativeMouseEvent) {
        try {
            MagicHelper.manager.mousePressed(nativeMouseEvent);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void nativeMouseReleased(NativeMouseEvent nativeMouseEvent) {
        try {
            MagicHelper.manager.mouseReleased(nativeMouseEvent);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void nativeMouseMoved(NativeMouseEvent nativeMouseEvent) {

    }

    @Override
    public void nativeMouseDragged(NativeMouseEvent nativeMouseEvent) {

    }


}

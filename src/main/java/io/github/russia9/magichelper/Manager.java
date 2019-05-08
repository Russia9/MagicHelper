package io.github.russia9.magichelper;

import io.github.russia9.magichelper.lib.Helper;
import io.github.russia9.magichelper.lib.Reference;
import io.github.russia9.magichelper.modules.autoClicker.Clicker;
import io.github.russia9.magichelper.modules.autoMiner.Miner;
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
    private static Miner miner;
    private boolean middleMouseButton;
    private boolean altGrButton;
    private int keyCode = -1;
    private int minerKeyCode = -1;
    private int mouseCode = -1;

    Manager() throws NativeHookException {
        clicker = new Clicker();
        miner = new Miner();
        GlobalScreen.registerNativeHook();
        Hook hook = new Hook();
        GlobalScreen.addNativeMouseListener(hook);
        GlobalScreen.addNativeMouseMotionListener(hook);
        GlobalScreen.addNativeKeyListener(hook);
    }

    void mousePressed(NativeMouseEvent nativeMouseEvent) throws AWTException {
        if (nativeMouseEvent.getButton() == Reference.AUTOCLICKER_DEFAULT_ACTIVATE_BUTTON) {
            middleMouseButton = true;
        } else {
            if (middleMouseButton) {
                mouseCode = MouseEvent.getMaskForButton(nativeMouseEvent.getButton());
            } else {
                mouseCode = -1;
            }
        }
    }

    void mouseReleased(NativeMouseEvent nativeMouseEvent) throws AWTException {
        if (nativeMouseEvent.getButton() == Reference.AUTOCLICKER_DEFAULT_ACTIVATE_BUTTON) {
            if (clicker.isAlive()) {
                clicker.stop();
            } else if (miner.isAlive()) {
                miner.stop();
            } else {
                if (keyCode == -1 && mouseCode == -1) {
                    clicker.start();
                } else if (mouseCode != -1) {
                    clicker.start(0, mouseCode, Reference.AUTOCLICKER_DEFAULT_CLICK_TIME);
                    mouseCode = -1;
                } else {
                    clicker.start(1, keyCode, Reference.AUTOCLICKER_DEFAULT_CLICK_TIME);
                    keyCode = -1;
                }
            }
            middleMouseButton = false;
            keyCode = -1;
        }
    }

    void keyPressed(NativeKeyEvent nativeKeyEvent) throws AWTException {
        if (middleMouseButton) {
            keyCode = Helper.getKeyCode(nativeKeyEvent);
        } else if (altGrButton) {
            minerKeyCode = Helper.getKeyCode(nativeKeyEvent);
        }

        if (Helper.getKeyCode(nativeKeyEvent) == Reference.AUTOMINER_DEFAULT_ACTIVATE_BUTTON) {
            altGrButton = true;
        }
    }

    void keyReleased(NativeKeyEvent nativeKeyEvent) throws AWTException {
        //System.out.println(nativeKeyEvent.getKeyCode() + " " + minerKeyCode + " " + NativeKeyEvent.VC_W);
        if (Helper.getKeyCode(nativeKeyEvent) == Reference.AUTOMINER_DEFAULT_ACTIVATE_BUTTON) {
            //System.out.println(1);
            switch (minerKeyCode) {
                case 87: // Horizontal mining
                    miner.start(0);
                    //System.out.println(2);
                    break;
                case NativeKeyEvent.VC_D: // Vertical mining
                    miner.start(1);
                    break;
                case NativeKeyEvent.VC_S: // Smart mining
                    miner.start(2);
                    break;
            }
            minerKeyCode = -1;
            altGrButton = false;
        }
    }
}

package io.github.russia9.magichelper;

import io.github.russia9.magichelper.lib.Helper;
import io.github.russia9.magichelper.lib.Reference;
import io.github.russia9.magichelper.modules.autoclicker.Clicker;
import io.github.russia9.magichelper.modules.autominer.Miner;
import io.github.russia9.magichelper.modules.buttonclamper.ButtonClamper;
import org.apache.commons.lang3.SystemUtils;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.mouse.NativeMouseEvent;

import java.awt.*;
import java.awt.event.MouseEvent;

/**
 * Main class
 */
public class Manager {
    private Clicker clicker;
    private ButtonClamper clamper;
    private Miner miner;

    private int autoclickerActivateButton;
    private int autoMinerActivateButton;

    private int autoclickerClickTime;
    private int autoclickerClickButton;

    private boolean mainButton;
    private boolean autoMinerButton;

    private int keyCode = -1;
    private int minerKeyCode = -1;
    private int mouseCode = -1;

    Manager() throws NativeHookException {
        // Init clicker and miner
        clicker = new Clicker(this);
        clamper = new ButtonClamper(this);
        miner = new Miner();

        // Default keys
        if (SystemUtils.IS_OS_WINDOWS) { // WINDOWS
            setAutoclickerActivateButton(Reference.AUTOCLICKER_DEFAULT_WIN_ACTIVATE_BUTTON);
        } else { // *NIX and MAC
            setAutoclickerActivateButton(Reference.AUTOCLICKER_DEFAULT_NIX_ACTIVATE_BUTTON);
        }
        setAutoMinerActivateButton(Reference.AUTOMINER_DEFAULT_ACTIVATE_BUTTON);
        setAutoclickerClickTime(Reference.AUTOCLICKER_DEFAULT_CLICK_TIME);
        setAutoclickerClickButton(Reference.AUTOCLICKER_DEFAULT_CLICK_BUTTON);

        // Registering events
        GlobalScreen.registerNativeHook();
        Hook hook = new Hook(this);
        GlobalScreen.addNativeMouseListener(hook);
        GlobalScreen.addNativeMouseMotionListener(hook);
        GlobalScreen.addNativeKeyListener(hook);
    }

    public void mousePressed(NativeMouseEvent nativeMouseEvent) throws AWTException {
        if (nativeMouseEvent.getButton() == autoclickerActivateButton) {
            mainButton = true;
        } else {
            if (mainButton) {
                mouseCode = MouseEvent.getMaskForButton(nativeMouseEvent.getButton());
            } else {
                mouseCode = -1;
            }
        }
    }

    public void mouseReleased(NativeMouseEvent nativeMouseEvent) throws AWTException {
        if (nativeMouseEvent.getButton() == autoclickerActivateButton) {
            if (clicker.isAlive()) {
                clicker.stop();
            } else if (miner.isAlive()) {
                miner.stop();
            } else {
                if (keyCode == -1 && mouseCode == -1) {
                    clicker.start();
                } else if (mouseCode != -1) {
                    clicker.start(0, mouseCode, autoclickerClickTime);
                    mouseCode = -1;
                } else {
                    clicker.start(1, keyCode, autoclickerClickTime);
                    keyCode = -1;
                }
            }
            mainButton = false;
            keyCode = -1;
        }
    }

    public void keyPressed(NativeKeyEvent nativeKeyEvent) throws AWTException {
        if (mainButton) {
            keyCode = Helper.getKeyCode(nativeKeyEvent);
        } else if (autoMinerButton) {
            minerKeyCode = Helper.getKeyCode(nativeKeyEvent);
        }

        if (Helper.getKeyCode(nativeKeyEvent) == autoMinerActivateButton) {
            autoMinerButton = true;
        }
    }

    public void keyReleased(NativeKeyEvent nativeKeyEvent) throws AWTException {
        if (Helper.getKeyCode(nativeKeyEvent) == autoclickerActivateButton) {
            switch (minerKeyCode) {
                case 87: // Horizontal mining
                    miner.start(0);
                    break;
                case NativeKeyEvent.VC_D: // Vertical mining
                    miner.start(1);
                    break;
                case NativeKeyEvent.VC_S: // Smart mining
                    miner.start(2);
                    break;
                default:
                    break;
            }
            minerKeyCode = -1;
            autoMinerButton = false;
        }
    }

    /**
     * Function to get autoclicker activation button
     *
     * @return Current autoclicker activating button
     */
    public int getAutoclickerActivateButton() {
        return autoclickerActivateButton;
    }

    /**
     * Function to set autoclicker activation button
     */
    public void setAutoclickerActivateButton(int autoclickerActivateButton) {
        this.autoclickerActivateButton = autoclickerActivateButton;
    }

    /**
     * Function to get autominer activation button
     *
     * @return Current autominer activating button
     */
    public int getAutoMinerActivateButton() {
        return autoMinerActivateButton;
    }

    /**
     * Function to set autominer activation button
     */
    public void setAutoMinerActivateButton(int autoMinerActivateButton) {
        this.autoMinerActivateButton = autoMinerActivateButton;
    }

    public int getAutoclickerClickTime() {
        return autoclickerClickTime;
    }

    public void setAutoclickerClickTime(int autoclickerClickTime) {
        this.autoclickerClickTime = autoclickerClickTime;
    }

    public int getAutoclickerClickButton() {
        return autoclickerClickButton;
    }

    public void setAutoclickerClickButton(int autoclickerClickButton) {
        this.autoclickerClickButton = autoclickerClickButton;
    }
}

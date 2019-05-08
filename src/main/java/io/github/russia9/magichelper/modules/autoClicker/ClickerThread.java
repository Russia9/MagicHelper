package io.github.russia9.magichelper.modules.autoClicker;

import java.awt.*;

/**
 * AutoClicker Thread
 */
public class ClickerThread extends Thread {
    private boolean alive = false;
    private boolean stop = false;
    private int type, button, time;
    private Robot clicker;

    ClickerThread(int type, int button, int time) throws AWTException {
        this.type = type;
        this.button = button;
        this.time = time;
        clicker = new Robot();
        this.setName("Autoclicker Thread");
    }

    void finish() {
        stop = true;
    }

    @Override
    public void run() {
        while (!stop) {
            switch (type) {
                case 0: // Mouse
                    clicker.mousePress(button);
                    clicker.delay(time);
                    clicker.mouseRelease(button);
                    break;
                case 1: // Keyboard
                    clicker.keyPress(button);
                    clicker.delay(time);
                    clicker.keyRelease(button);
                    break;
                default:
                    System.err.println("Unknown type. Check org.russia9.magichelper.modules.autoClicker.ClickerThread class");
            }
        }
    }
}
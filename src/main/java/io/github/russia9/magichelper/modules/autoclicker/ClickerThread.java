package io.github.russia9.magichelper.modules.autoclicker;

import java.awt.*;

/**
 * AutoClicker Thread
 */
public class ClickerThread extends Thread {
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

    public void finish() {
        stop = true;
    }

    @Override
    public void run() {
        while (!stop) {
            switch (type) {
                case 0: // Mouse
                    clicker.mousePress(button);
                    clicker.delay(6);
                    clicker.mouseRelease(button);
                    clicker.delay(time);
                    break;
                case 1: // Keyboard
                    clicker.keyPress(button);
                    clicker.delay(6);
                    clicker.keyRelease(button);
                    clicker.delay(time);
                    break;
                default:
                    System.err.println("Unknown type. Check org.russia9.magichelper.modules.autoclicker.ClickerThread class");
                    break;
            }
        }
    }
}
package org.russia9.autoClicker;

import java.awt.*;

public class ClickerThread extends Thread {
    boolean alive = false;
    private int type, button, time;
    private boolean stop = false;
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
        alive = true;
        while (!stop) {
            try {
                switch (type) {
                    case 0: // Mouse
                        clicker.mousePress(button);
                        Thread.sleep(time);
                        clicker.mouseRelease(button);
                        break;
                    case 1: // Keyboard
                        clicker.keyPress(button);
                        Thread.sleep(time);
                        clicker.keyPress(button);
                        break;
                    default:
                        System.err.println("Unknown type. Check org.russia9.autoClicker.ClickerThread class");
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        clicker.mouseRelease(button);
        alive = false;
    }
}
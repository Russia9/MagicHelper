package io.github.russia9.magichelper.modules.autoclicker;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;

/**
 * AutoClicker Thread
 */
public class ClickerThread extends Thread {
    private static final Logger logger = LogManager.getLogger(ClickerThread.class.getName());

    private final int type;
    private final int button;
    private final int time;
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
        switch (type) {
            case 0: // Mouse
                while (!stop) {
                    clicker.mousePress(button);
                    clicker.delay(6);
                    clicker.mouseRelease(button);
                    clicker.delay(time);
                }
                break;
            case 1: // Keyboard
                while (!stop) {
                    clicker.keyPress(button);
                    clicker.delay(6);
                    clicker.keyRelease(button);
                    clicker.delay(time);
                }
                break;
            default:
                logger.error("Unknown type");
                break;
        }
    }
}
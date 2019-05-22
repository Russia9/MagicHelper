package io.github.russia9.magichelper.modules.buttonclamper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;

public class ButtonClamperThread extends Thread {
    private static final Logger logger = LogManager.getLogger(ButtonClamperThread.class.getName());

    private final int type;
    private final int button;
    private boolean stop = false;
    private Robot clamper;

    ButtonClamperThread(int type, int button) throws AWTException {
        this.type = type;
        this.button = button;
        clamper = new Robot();
    }

    public void finish() {
        stop = true;
    }

    @Override
    public void run() {
        switch (type) {
            case 0:
                clamper.keyPress(button);
                clamper.delay(501);
                while (!stop) {
                    clamper.keyPress(button);
                    clamper.delay(33);
                }
                break;
            case 1:
                clamper.mousePress(button);
                while (!stop) ;
                clamper.mouseRelease(button);
                break;
            default:
                logger.error("Unknown type");
                break;
        }
    }
}

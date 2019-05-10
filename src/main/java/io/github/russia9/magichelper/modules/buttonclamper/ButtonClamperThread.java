package io.github.russia9.magichelper.modules.buttonclamper;

import java.awt.*;

public class ButtonClamperThread extends Thread {
    private boolean stop = false;
    private int type, button;
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
                break;
        }
    }
}

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
        notify();
    }

    @Override
    public void run() {
        clamper.mousePress(button);
        try {
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clamper.mouseRelease(button);
    }
}

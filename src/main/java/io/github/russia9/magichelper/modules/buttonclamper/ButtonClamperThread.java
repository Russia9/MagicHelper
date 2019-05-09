package io.github.russia9.magichelper.modules.buttonclamper;

import java.awt.*;

public class ButtonClamperThread extends Thread {
    private int button;
    private Robot clamper;

    ButtonClamperThread(int button) throws AWTException {
        this.button = button;
        clamper = new Robot();
    }

    public void finish() {
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

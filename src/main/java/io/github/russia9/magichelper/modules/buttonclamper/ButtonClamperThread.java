package io.github.russia9.magichelper.modules.buttonclamper;

import java.awt.*;

public class ButtonClamperThread extends Thread {
    private int type, button;
    private Robot clamper;

    ButtonClamperThread(int type, int button) throws AWTException {
        this.type = type;
        this.button = button;
        clamper = new Robot();
    }

    public synchronized  void finish() {
        notify();
    }

    @Override
    public synchronized void run() {
        switch (type) {
            case 0:
                clamper.keyPress(button);
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                clamper.keyRelease(button);
                System.out.println("lol");
                break;
            case 1:
                clamper.mousePress(button);
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                clamper.mouseRelease(button);
                break;
            default:
                break;
        }
    }
}

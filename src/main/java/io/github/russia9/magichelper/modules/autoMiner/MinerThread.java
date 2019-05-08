package io.github.russia9.magichelper.modules.autoMiner;

import java.awt.*;

/**
 * AutoMiner Thread
 */
public class MinerThread extends Thread {
    private boolean alive = false;
    private boolean stop = false;
    private int type;
    private Robot miner;

    public MinerThread(int type) throws AWTException {
        this.type = type;
        miner = new Robot();
        this.setName("AutoMiner Thread");
    }

    void finish() {
        stop = true;
    }

    @Override
    public void run() {
        alive = true;
        while (!stop) {
            switch (type) {
                case 0: // Horizontal mining

                    break;
                case 1: // Vertical mining

                    break;
                case 2: // Smart mining

                    break;
                default:
                    System.err.println("Unknown type. Check org.russia9.autoClicker.ClickerThread class");
            }
        }
        alive = false;
    }
}

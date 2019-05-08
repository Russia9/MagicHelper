package io.github.russia9.magichelper.modules.autoMiner;

import java.awt.*;

/**
 * AutoMiner Thread
 */
public class MinerThread extends Thread {
    private boolean stop = false;
    private int type;
    private Robot miner;

    MinerThread(int type) throws AWTException {
        this.type = type;
        miner = new Robot();
        this.setName("AutoMiner Thread");
    }

    void finish() {
        stop = true;
    }

    @Override
    public void run() {
        while (!stop) {
            switch (type) {
                case 0: // Horizontal mining

                    break;
                case 1: // Vertical mining

                    break;
                case 2: // Smart mining

                    break;
                default:
                    System.err.println("Unknown type. Check org.russia9.magichelper.modules.autoMiner.MinerThread class");
            }
        }
    }
}

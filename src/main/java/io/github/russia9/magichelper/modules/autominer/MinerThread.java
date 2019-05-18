package io.github.russia9.magichelper.modules.autominer;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;

/**
 * AutoMiner Thread
 */
public class MinerThread extends Thread {
    private static final Logger logger = LogManager.getLogger(MinerThread.class.getName());

    private final int type;
    private boolean stop = false;
    private Robot miner;

    MinerThread(int type) throws AWTException {
        this.type = type;
        miner = new Robot();
        this.setName("AutoMiner Thread");
    }

    public void finish() {
        stop = true;
    }

    @Override
    public void run() {
        while (!stop) {
            switch (type) {
                case 0: // Horizontal mining
                    miner.mouseMove(1000, 500);
                    miner.delay(1000);
                    break;
                case 1: // Vertical mining
                    // TODO: Vertical mining
                    break;
                case 2: // Smart mining
                    // TODO: Smart mining
                    break;
                default:
                    logger.error("Unknown type");
                    break;
            }
        }
    }
}

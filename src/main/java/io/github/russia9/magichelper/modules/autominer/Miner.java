package io.github.russia9.magichelper.modules.autominer;

import java.awt.*;

public class Miner {
    private boolean alive = false;
    private MinerThread miner;

    /**
     * @param type type of mining,
     *             0 for Horizontal,
     *             1 for Vertical,
     *             2 for Smart
     */
    public void start(int type) throws AWTException {
        if (miner != null) {
            if (!miner.isAlive()) {
                miner = new MinerThread(type);
                miner.start();
                alive = true;
            }
        } else {
            miner = new MinerThread(type);
            miner.start();
            alive = true;
        }
    }

    public boolean isAlive() {
        return alive;
    }

    public void stop() {
        miner.finish();
        alive = false;
    }
}

package io.github.russia9.magichelper.modules.autoMiner;

import java.awt.*;

public class Miner {
    boolean alive = false;
    private MinerThread miner;

    /**
     * @param type type of mining,
     *             0 for Horizontal,
     *             1 for Vertical,
     *             2 for Smart
     */
    public void start(int type) throws AWTException {
        miner = new MinerThread(type);
        miner.start();
        alive = true;
    }
}

package org.russia9.autoClicker;

import java.awt.*;

public class Clicker {
    ClickerThread clicker;

    /**
     * <p>Method that starts autoclicking</p>
     *
     * @param type   type of click,
     *               0 for mouse
     *               1 for keyboard
     * @param button Autoclicker will clicks those button
     * @param time
     */
    public void start(int type, int button, int time) throws AWTException {
        clicker = new ClickerThread(type, button, time);
    }

    /**
     * <p>Method that stops autoclicking</p>
     */
    public void stop() {
        clicker.interrupt();
    }
}

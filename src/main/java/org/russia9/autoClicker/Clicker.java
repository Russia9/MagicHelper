package org.russia9.autoClicker;

import java.awt.*;

import static org.russia9.lib.Reference.AUTOCLICKER_DEFAULT_CLICK_BUTTON;
import static org.russia9.lib.Reference.AUTOCLICKER_DEFAULT_CLICK_TIME;

public class Clicker {
    private ClickerThread clicker;

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
        clicker.start();
    }

    public void start() throws AWTException {
        start(0, AUTOCLICKER_DEFAULT_CLICK_BUTTON, AUTOCLICKER_DEFAULT_CLICK_TIME);
    }

    /**
     * <p>Method that stops autoclicking</p>
     */
    public void stop() {
        clicker.stop();
    }
}

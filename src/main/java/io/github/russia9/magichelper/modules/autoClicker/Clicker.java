package io.github.russia9.magichelper.modules.autoClicker;

import java.awt.*;

import static io.github.russia9.magichelper.lib.Reference.AUTOCLICKER_DEFAULT_CLICK_BUTTON;
import static io.github.russia9.magichelper.lib.Reference.AUTOCLICKER_DEFAULT_CLICK_TIME;

/**
 * Class to manage AutoClicker thread
 */
public class Clicker {
    private boolean alive = false;
    private ClickerThread clicker;

    /**
     * <p>Method that starts autoclicking</p>
     *
     * @param type   type of click,
     *               0 for mouse
     *               1 for keyboard
     * @param button Autoclicker will clicks those button
     * @param time   time between clicks
     */
    public void start(int type, int button, int time) throws AWTException {
        clicker = new ClickerThread(type, button, time);
        clicker.start();
        alive = true;
    }

    public void start() throws AWTException {
        start(0, AUTOCLICKER_DEFAULT_CLICK_BUTTON, AUTOCLICKER_DEFAULT_CLICK_TIME);
    }

    public boolean isAlive() {
        return alive;
    }

    /**
     * <p>Method that stops autoclicking</p>
     */
    public void stop() {
        clicker.finish();
        alive = false;
    }
}

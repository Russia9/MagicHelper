package io.github.russia9.magichelper.modules.autoClicker;

import io.github.russia9.magichelper.Manager;

import java.awt.*;


/**
 * Class to manage AutoClicker thread
 */
public class Clicker {
    private boolean alive = false;
    private ClickerThread clicker;
    private Manager manager;

    public Clicker(Manager manager) {
        this.manager = manager;
    }

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
        start(0, manager.getAutoclickerClickButton(), manager.getAutoclickerClickTime());
    }

    public boolean isAlive() {
        return alive;
    }

    /**
     * <p>Method that stops autoclicker/p>
     */
    public void stop() {
        clicker.finish();
        alive = false;
    }
}

package io.github.russia9.magichelper.modules.buttonclamper;

import java.awt.*;

public class ButtonClamper {
    private boolean alive = false;
    private ButtonClamperThread buttonClamperThread;

    /**
     * <p>Method that starts clamping button</p>
     *
     * @param type   type of click,
     *               0 for mouse
     *               1 for keyboard
     * @param button ButtonClamper will clamp those button
     */
    public void start(int type, int button) throws AWTException {
        buttonClamperThread = new ButtonClamperThread(button);
        buttonClamperThread.start();
        alive = true;
    }

    public boolean isAlive() {
        return alive;
    }

    /**
     * <p>Method that stops clamper/p>
     */
    public void stop() {
        buttonClamperThread.finish();
        alive = false;
    }
}

package io.github.russia9.magichelper;

import io.github.russia9.magichelper.lib.Reference;
import org.apache.commons.lang3.SystemUtils;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main class
 */
public class MagicHelper {
    static Manager manager;

    public static void main(String[] args) throws NativeHookException, InterruptedException {
        System.out.println("MagicHelper v0.1 by Russia9");
        System.out.println("For more information: https://github.com/Russia9/MagicHelper");

        System.err.println("MagicHelper v0.1 doesn't have full functional");

        if(SystemUtils.IS_OS_WINDOWS) {
            Reference.AUTOCLICKER_DEFAULT_ACTIVATE_BUTTON = MouseEvent.BUTTON3;
        }

        // Disabling standard jnativehook logging
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.WARNING);
        logger.setUseParentHandlers(false);

        manager = new Manager();
    }
}

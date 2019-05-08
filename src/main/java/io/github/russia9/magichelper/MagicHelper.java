package io.github.russia9.magichelper;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Initialisation class
 */
public class MagicHelper {
    static Manager manager;

    public static void main(String[] args) throws NativeHookException {
        System.out.println("MagicHelper v0.1.5 by Russia9");
        System.out.println("For more information: https://github.com/Russia9/MagicHelper");

        System.err.println("MagicHelper v0.1.5 doesn't have full functional");

        // Disabling standard jnativehook logging
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.WARNING);
        logger.setUseParentHandlers(false);

        manager = new Manager();
    }
}

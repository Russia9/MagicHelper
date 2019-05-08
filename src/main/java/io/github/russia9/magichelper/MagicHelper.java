package io.github.russia9.magichelper;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Initialisation class
 */
public class MagicHelper {

    public static void main(String[] args) throws NativeHookException {
        System.out.println("MagicHelper v0.2 by Russia9");
        System.out.println("For more information: https://github.com/Russia9/MagicHelper");

        System.err.println("MagicHelper v0.2 doesn't have full functional");

        // Disabling standard jnativehook logging
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.WARNING);
        logger.setUseParentHandlers(false);

        new Manager();
    }
}

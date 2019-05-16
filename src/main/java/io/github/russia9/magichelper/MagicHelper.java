package io.github.russia9.magichelper;

import org.apache.log4j.Logger;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;


/**
 * Initialisation class
 */
public class MagicHelper {
    private static Logger logger = Logger.getLogger(MagicHelper.class.getName());

    public static void main(String[] args) throws NativeHookException {
        logger.info("MagicHelper v0.3.1 by Russia9");
        logger.info("For more information: https://github.com/Russia9/MagicHelper");

        logger.warn("MagicHelper v0.3.1 doesn't have full functional");

        // Disabling standard jnativehook logging
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(java.util.logging.Level.WARNING);
        logger.setUseParentHandlers(false);

        new Manager();
    }
}

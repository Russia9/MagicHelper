package io.github.russia9.magichelper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;


/**
 * Initialisation class
 */
public class MagicHelper {
    private static final Logger logger = LogManager.getLogger(MagicHelper.class.getName());

    public static void main(String[] args) throws NativeHookException {
        logger.info("MagicHelper v0.3.2 by Russia9");
        logger.info("For more information: https://github.com/Russia9/MagicHelper");

        logger.warn("MagicHelper v0.3.2 doesn't have full functional");

        // Disabling standard JNativeHook logging
        java.util.logging.Logger logger = java.util.logging.Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(java.util.logging.Level.WARNING);
        logger.setUseParentHandlers(false);

        new Manager();
    }
}

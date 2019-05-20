package io.github.russia9.magichelper;

import io.github.russia9.magichelper.lib.Helper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jnativehook.NativeHookException;


/**
 * Initialisation class
 */
public class MagicHelper {
    private static final Logger logger = LogManager.getLogger(MagicHelper.class.getName());

    public static void main(String[] args) throws NativeHookException {
        logger.info("MagicHelper v0.3.3 by Russia9");
        logger.info("For more information: https://github.com/Russia9/MagicHelper");
        logger.warn("MagicHelper v0.3.3 doesn't have full functional");

        Helper.disableJNativeHookLog();
        new Manager();
    }
}

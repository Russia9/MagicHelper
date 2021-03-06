package io.github.russia9.magichelper;

import io.github.russia9.magichelper.lib.Helper;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.jnativehook.NativeHookException;


/**
 * Initialisation class
 */
public class MagicHelper {
    private static final Logger logger = LogManager.getLogger(MagicHelper.class.getName());

    public static void main(String[] args) throws NativeHookException {
        for (String arg : args) {
            if (arg.equals("Debug=true")) {
                Configurator.setRootLevel(Level.DEBUG);
            } else if (arg.equals("Trace=true")) {
                Configurator.setRootLevel(Level.TRACE);
            }
        }
        logger.info("MagicHelper v0.4 by Russia9");
        logger.info("For more information: https://github.com/Russia9/MagicHelper");

        Helper.disableJNativeHookLog();
        new Manager();
    }
}

package org.russia9;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    private static Manager manager;

    public static void main(String[] args) throws NativeHookException, AWTException, InterruptedException {
        System.out.println("MagicHelper v0.1-SNAPSHOT by Russia9");
        System.out.println("For more information: https://github.com/Russia9/MagicHelper");

        System.err.println("MagicHelper v0.1 doesn't have full functional");

        // Disabling standard jnativehook logging
        Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
        logger.setLevel(Level.WARNING);
        logger.setUseParentHandlers(false);

        manager = new Manager();
    }
}

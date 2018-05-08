package org.russia9;

import org.jnativehook.NativeHookException;

import java.awt.*;

public class Main {
    static Manager manager;

    public static void main(String[] args) throws NativeHookException, AWTException, InterruptedException {
        System.out.println("MagicHelper v0.1-SNAPSHOT by Russia9");
        System.out.println("For more information: https://github.com/Russia9/MagicHelper");
        //System.err.println("MagicHelper v0.1 haven't hook and start is unable");
        manager = new Manager();
    }
}

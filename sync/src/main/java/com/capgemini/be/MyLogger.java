package com.capgemini.be;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyLogger {

    private static final Logger LOGGER = Logger.getLogger(MyLogger.class.getName());

    public static void setup() {
        ConsoleHandler handler = new ConsoleHandler();
        handler.setLevel(Level.ALL);
        LOGGER.addHandler(handler);
        LOGGER.setLevel(Level.ALL);
    }

    public static Logger getLogger() {
        return LOGGER;
    }
}


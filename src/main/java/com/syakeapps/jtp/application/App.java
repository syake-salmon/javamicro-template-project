package com.syakeapps.jtp.application;

import static com.syakeapps.jtp.logging.Tracer.traceEnter;
import static com.syakeapps.jtp.logging.Tracer.traceExit;
import static spark.Spark.awaitInitialization;
import static spark.Spark.port;
import static spark.Spark.staticFiles;

import java.util.Properties;

import org.slf4j.Logger;

import com.syakeapps.jtp.api.ExampleAPI;
import com.syakeapps.jtp.logging.LoggerFactory;
import com.syakeapps.jtp.util.UtilityToolBox;

/**
 * Application launcher.
 */
public class App {

    private static final String PROPERTY_SPARK_PORT = "port";
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    /**
     * Main method.
     * 
     * @param args <i>NO USE</i>
     */
    public static void main(final String... args) {
        try {
            new App().run();
        } catch (Exception e) {
            LOGGER.error("An error occurred. Check stack trace.");
            throw e;
        }
    }

    private void run() {
        traceEnter(LOGGER, "#run");

        if (LOGGER.isDebugEnabled()) {
            Properties prop = System.getProperties();
            prop.keySet().forEach(key -> {
                LOGGER.debug("{} => {}", key, prop.get(key));
            });
        }

        init();
        ExampleAPI.api();
        awaitInitialization();
        LOGGER.info(
                "Application started successfully. Visit the page for usage. => http://localhost:{}/usage.html",
                port());

        traceExit();
    }

    private void init() {
        traceEnter(LOGGER, "#init");

        String portStr = System.getProperty(PROPERTY_SPARK_PORT);
        if (UtilityToolBox.isNotEmpty(portStr)) {
            try {
                int portNum = Integer.parseInt(portStr);
                if (UtilityToolBox.isPortNumber(portNum)) {
                    port(portNum);
                } else {
                    throw new IllegalStateException(
                            "Port number should be 0-65535.");
                }
            } catch (NumberFormatException | IllegalStateException e) {
                LOGGER.error(
                        "Specified port is invalid. Check system property. => -D{}={}",
                        PROPERTY_SPARK_PORT, portStr);
                throw e;
            }
        }
        staticFiles.location("/public");

        traceExit();
    }
}

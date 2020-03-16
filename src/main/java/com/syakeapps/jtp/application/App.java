package com.syakeapps.jtp.application;

import static com.syakeapps.jtp.logging.Tracer.trace_enter;
import static com.syakeapps.jtp.logging.Tracer.trace_exit;
import static spark.Spark.awaitInitialization;
import static spark.Spark.port;
import static spark.Spark.staticFiles;

import java.util.Properties;

import org.slf4j.Logger;

import com.syakeapps.jtp.api.ExampleAPI;
import com.syakeapps.jtp.logging.LoggerFactory;

import spark.utils.StringUtils;

public class App {

    private static final String PROPERTY_SPARK_PORT = "port";
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String... args) {
        try {
            new App().run();
        } catch (Exception | Error e) {
            LOGGER.error("An error occurred. Check stack trace.", e);
            throw e;
        }
    }

    private void run() {
        trace_enter(LOGGER, "#run");

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

        trace_exit();
    }

    private void init() {
        trace_enter(LOGGER, "#init");

        String port = System.getProperty(PROPERTY_SPARK_PORT);
        if (StringUtils.isNotEmpty(port)) {
            try {
                int portNum = new Integer(port);
                if (0 <= portNum && portNum <= 65535) {
                    port(portNum);
                } else {
                    throw new IllegalStateException(
                            "Port number should be 0-65535.");
                }
            } catch (NumberFormatException | IllegalStateException e) {
                LOGGER.error(
                        "Specified port is invalid. Check system property. => -D{}={}",
                        PROPERTY_SPARK_PORT, port);
                throw e;
            }
        }
        staticFiles.location("/public");

        trace_exit();
    }
}

package com.syakeapps.jtp.api;

import static com.syakeapps.jtp.logging.Tracer.traceEnter;
import static com.syakeapps.jtp.logging.Tracer.traceExit;
import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.path;
import static spark.Spark.post;
import static spark.Spark.put;

import org.slf4j.Logger;

import com.syakeapps.jtp.logging.LoggerFactory;

/**
 * Example API implement.
 */
public final class ExampleAPI {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(ExampleAPI.class);

    private ExampleAPI() {
        throw new IllegalStateException("Instantiate is not allowed.");
    }

    /**
     * Setup API.
     */
    public static void api() {
        traceEnter(LOGGER, "#api");

        path("/api", () -> {
            path("/example", () -> {
                get("/get", (request, response) -> {
                    return null;
                });

                post("/post", (request, response) -> {
                    return null;
                });

                put("/put", (request, response) -> {
                    return null;
                });

                delete("/delete", (request, response) -> {
                    return null;
                });
            });
        });

        traceExit();
    }
}

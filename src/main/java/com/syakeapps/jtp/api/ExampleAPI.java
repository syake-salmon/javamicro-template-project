package com.syakeapps.jtp.api;

import static com.syakeapps.jtp.logging.Tracer.trace_enter;
import static com.syakeapps.jtp.logging.Tracer.trace_exit;
import static spark.Spark.delete;
import static spark.Spark.get;
import static spark.Spark.path;
import static spark.Spark.post;
import static spark.Spark.put;

import org.slf4j.Logger;

import com.syakeapps.jtp.logging.LoggerFactory;

public class ExampleAPI {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(ExampleAPI.class);

    public static void api() {
        trace_enter(LOGGER, "#api");

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

        trace_exit();
    }
}

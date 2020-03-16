package com.syakeapps.jtp.logging;

import java.util.ArrayDeque;

import org.slf4j.Logger;

/**
 * Trace logging tool.
 */
public final class Tracer {

    private static final ArrayDeque<LogState> LOG_STATES = new ArrayDeque<>();

    private Tracer() {
        throw new IllegalStateException("Instantiate is not allowed.");
    }

    /**
     * Output trace log on method entrance.
     * 
     * @param log   Logger
     * @param point logging output point
     */
    public static void traceEnter(final Logger log, final String point) {
        LOG_STATES
                .addFirst(new LogState(log, point, System.currentTimeMillis()));
        log.trace("{} ENTER", point);
    }

    /**
     * Output trace log on method exit.
     */
    public static void traceExit() {
        LogState last = LOG_STATES.removeFirst();
        last.getLogger().trace("{} EXIT ({} mills)", last.getPoint(),
                System.currentTimeMillis() - last.getEnterTime());
    }
}

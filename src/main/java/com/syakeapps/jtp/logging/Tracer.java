package com.syakeapps.jtp.logging;

import java.util.Stack;

import org.slf4j.Logger;

public class Tracer {

    private static final Stack<LogState> STATES = new Stack<>();

    private Tracer() {
        throw new IllegalStateException("Instantiate is not allowed.");
    }

    public static void trace_enter(Logger log, String point) {
        STATES.push(new LogState(log, point, System.currentTimeMillis()));
        log.trace("{} ENTER", point);
    }

    public static void trace_exit() {
        LogState last = STATES.pop();
        last.getLogger().trace("{} EXIT ({} mills)", last.getPoint(),
                System.currentTimeMillis() - last.getEnterTime());
    }
}

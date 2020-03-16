package com.syakeapps.jtp.logging;

import org.slf4j.Logger;

/**
 * Bean that holds log states.
 */
public class LogState {
    private Logger logger = null;
    private String point = null;
    private long enterTime;

    /**
     * Constructor.
     * 
     * @param log   Logger
     * @param point logging output point
     * @param time  enter time
     */
    public LogState(final Logger log, final String point, final long time) {
        this.logger = log;
        this.point = point;
        this.enterTime = time;
    }

    public Logger getLogger() {
        return logger;
    }

    public String getPoint() {
        return point;
    }

    public long getEnterTime() {
        return enterTime;
    }
}

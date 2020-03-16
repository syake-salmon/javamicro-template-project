package com.syakeapps.jtp.logging;

import org.slf4j.Logger;

public class LogState {
    private Logger logger = null;
    private String point = null;
    private long enterTime;

    public LogState(Logger log, String point, long time) {
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

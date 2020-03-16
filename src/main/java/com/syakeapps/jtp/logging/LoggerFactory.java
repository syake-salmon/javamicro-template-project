package com.syakeapps.jtp.logging;

import org.slf4j.Logger;

/**
 * {@link Logger} provider.
 */
public final class LoggerFactory {

    private LoggerFactory() {
        throw new IllegalStateException("Instantiate is not allowed.");
    }

    /**
     * Get a new {@link Logger} instance by class.
     *
     * @param clazz {@link Class} for logger name
     * @return {@link Logger} instance by class
     */
    public static Logger getLogger(final Class<?> clazz) {
        return org.slf4j.LoggerFactory.getLogger(clazz.getName());
    }
}

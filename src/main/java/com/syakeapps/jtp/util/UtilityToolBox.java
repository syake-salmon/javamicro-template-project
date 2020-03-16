package com.syakeapps.jtp.util;

/**
 * Utility class that has some util methods.
 */
public final class UtilityToolBox {
    private static final int MINIMUM_PORT_NUMBER = 0;
    private static final int MAXIMUM_PORT_NUMBER = 65535;

    private UtilityToolBox() {
        throw new IllegalStateException("Instantiate is not allowed.");
    }

    // ########## String ##########

    /**
     * Validate String value that is null or empty.
     * 
     * @param str check target String
     * @return validate result boolean
     */
    public static boolean isEmpty(final String str) {
        return (str == null || str.equals(""));
    }

    /**
     * @see {@link UtilityToolBox#isEmpty(String)}
     *
     * @param str check target String
     * @return validate result boolean
     */
    public static boolean isNotEmpty(final String str) {
        return !isEmpty(str);
    }

    // ########## Integer ##########

    /**
     * Validate int value that is in bounds, {@value #MINIMUM_PORT_NUMBER} -
     * {@value #MAXIMUM_PORT_NUMBER}.
     * 
     * @param port port number
     * @return validate result boolean
     */
    public static boolean isPortNumber(final int port) {
        return (MINIMUM_PORT_NUMBER <= port && port <= MAXIMUM_PORT_NUMBER);
    }
}

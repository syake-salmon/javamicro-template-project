package com.syakeapps.jtp.logging;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.slf4j.Logger;

public class LoggerFactoryTest {

    @Test
    public void test_getLogger() throws Exception {
        /* SETUP */
        String expected = LoggerFactoryTest.class.getName();

        /* INVOCATION */
        Logger logger = LoggerFactory.getLogger(LoggerFactoryTest.class);
        String actual = logger.getName();

        /* ASSERTION */
        assertNotNull(logger);
        assertEquals(expected, actual);
    }
}

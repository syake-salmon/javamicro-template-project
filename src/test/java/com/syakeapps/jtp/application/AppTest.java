package com.syakeapps.jtp.application;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import spark.Spark;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ Spark.class })
public class AppTest {

    @Before
    public void doBefore() {
        System.clearProperty("port");
    }

    @Test
    public void test_main() {
        /* SETUP */
        PowerMockito.mockStatic(Spark.class);
        boolean isError = false;

        /* INVOCATION */
        try {
            App.main("");
        } catch (Exception | Error e) {
            isError = true;
        }

        /* ASSERTION */
        assertFalse(isError);
    }

    @Test
    public void test_main_StringPortNum() {
        /* SETUP */
        PowerMockito.mockStatic(Spark.class);
        System.setProperty("port", "STRING_PORT_NUM");
        boolean isError = false;
        String expected = new NumberFormatException().getClass().getName();

        /* INVOCATION */
        String actual = null;
        try {
            App.main("");
        } catch (Exception | Error e) {
            isError = true;
            actual = e.getClass().getName();
        }

        /* ASSERTION */
        assertTrue(isError);
        assertEquals(expected, actual);
    }

    @Test
    public void test_main_MinimumPortNum() {
        /* SETUP */
        PowerMockito.mockStatic(Spark.class);
        System.setProperty("port", "0");
        boolean isError = false;

        /* INVOCATION */
        try {
            App.main("");
        } catch (Exception | Error e) {
            isError = true;
        }

        /* ASSERTION */
        assertFalse(isError);
    }

    @Test
    public void test_main_MaximumPortNum() {
        /* SETUP */
        PowerMockito.mockStatic(Spark.class);
        System.setProperty("port", "65535");
        boolean isError = false;

        /* INVOCATION */
        try {
            App.main("");
        } catch (Exception | Error e) {
            isError = true;
        }

        /* ASSERTION */
        assertFalse(isError);
    }

    @Test
    public void test_main_OutOfTopBoundsPortNum() {
        /* SETUP */
        PowerMockito.mockStatic(Spark.class);
        System.setProperty("port", "65536");
        boolean isError = false;
        String expected = new IllegalStateException().getClass().getName();

        /* INVOCATION */
        String actual = null;
        try {
            App.main("");
        } catch (Exception | Error e) {
            isError = true;
            actual = e.getClass().getName();
        }

        /* ASSERTION */
        assertTrue(isError);
        assertEquals(expected, actual);
    }

    @Test
    public void test_main_OutOfUnderBoundsPortNum() {
        /* SETUP */
        PowerMockito.mockStatic(Spark.class);
        System.setProperty("port", "-1");
        boolean isError = false;
        String expected = new IllegalStateException().getClass().getName();

        /* INVOCATION */
        String actual = null;
        try {
            App.main("");
        } catch (Exception | Error e) {
            isError = true;
            actual = e.getClass().getName();
        }

        /* ASSERTION */
        assertTrue(isError);
        assertEquals(expected, actual);
    }
}

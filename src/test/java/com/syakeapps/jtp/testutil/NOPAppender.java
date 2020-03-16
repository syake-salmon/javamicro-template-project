package com.syakeapps.jtp.testutil;

import java.io.IOException;
import java.io.OutputStream;

import ch.qos.logback.core.Layout;
import ch.qos.logback.core.OutputStreamAppender;
import ch.qos.logback.core.encoder.Encoder;

public class NOPAppender<E> extends OutputStreamAppender<E> {
    @Override
    public OutputStream getOutputStream() {
        return null;
    }

    @Override
    public void start() {
        // nop
    }

    @Override
    public void setLayout(Layout<E> layout) {
        // nop
    }

    @Override
    protected void append(E eventObject) {
        // nop
    }

    @Override
    public void stop() {
        // nop
    }

    @Override
    protected void closeOutputStream() {
        // nop
    }

    @Override
    public void setOutputStream(OutputStream outputStream) {
        // nop
    }

    @Override
    protected void writeOut(E event) throws IOException {
        // nop
    }

    @Override
    protected void subAppend(E event) {
        // nop
    }

    @Override
    public Encoder<E> getEncoder() {
        return null;
    }

    @Override
    public void setEncoder(Encoder<E> encoder) {
        // nop
    }

    @Override
    public boolean isImmediateFlush() {
        return false;
    }

    @Override
    public void setImmediateFlush(boolean immediateFlush) {
        // nop
    }
}

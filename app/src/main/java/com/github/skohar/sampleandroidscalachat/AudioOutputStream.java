package com.github.skohar.sampleandroidscalachat;

import java.io.IOException;

public interface AudioOutputStream {
    public void write(double value) throws IOException;

    public void write(double[] buffer) throws IOException;

    public void write(double[] buffer, int start, int count) throws IOException;

    public void close() throws IOException;
}
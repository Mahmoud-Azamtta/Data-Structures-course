package com.example.sorting;

public class Stopwatch {
    private long start;
    private long end;

    public void start() {
        start = System.currentTimeMillis();
    }

    public void stop() {
        end = System.currentTimeMillis();
    }

    public long getTimeElapsed() {
        return end - start;
    }
}

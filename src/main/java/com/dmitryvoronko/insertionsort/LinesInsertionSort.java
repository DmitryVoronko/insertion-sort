package com.dmitryvoronko.insertionsort;

/**
 * Created by Dmitry on 06/09/2016.
 */
public final class LinesInsertionSort extends InsertionSort {

    private final String[] lines;
    private String temp;

    public LinesInsertionSort(String[] lines) {
        this.lines = lines;
        count = lines.length;
    }

    protected void allocateTemp() {
        temp = lines[out];
    }

    protected void returnTemp() {
        lines[in] = temp;
    }

    protected boolean isReady() {
        return in > 0 &&
                (isAscending ? (lines[in - 1].compareTo(temp) > 0)
                : (lines[in - 1].compareTo(temp) < 0));
    }

    protected void swap() {
        lines[in] = lines[in - 1];
    }
}

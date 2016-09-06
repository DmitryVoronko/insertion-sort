package com.dmitryvoronko;

/**
 * Created by Dmitry on 06/09/2016.
 */
public class LinesInsertionSort extends InsertionSort {

    private String[] lines;
    private String temp;

    public LinesInsertionSort(String[] lines) {
        this.lines = lines;
        count = lines.length;
    }

    public void allocateTemp() {
        temp = lines[out];
    }

    public void returnTemp() {
        lines[in] = temp;
    }

    protected boolean isReady() {
        return in > 0 &&
                isAscending ? lines[in - 1].compareTo(temp) > 0
                : lines[in - 1].compareTo(temp) < 0;
    }

    protected void swap() {
        lines[in] = lines[in - 1];
    }
}

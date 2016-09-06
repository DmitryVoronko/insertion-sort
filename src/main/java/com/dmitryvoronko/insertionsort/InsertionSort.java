package com.dmitryvoronko.insertionsort;

/**
 * Created by Dmitry on 06/09/2016.
 */
public abstract class InsertionSort {

    protected int count;
    protected int in;
    protected int out;
    protected boolean isAscending = true;

    public final void sort() {
        for (out = 1; out < count; out++) {
            allocateTemp();
            in = out;
            while (isReady()) {
                swap();
                --in;
            }
            returnTemp();
        }
    }

    protected abstract void swap();

    protected abstract void allocateTemp();

    protected abstract void returnTemp();

    protected abstract boolean isReady();

    public void setAscending(boolean isAscending) {
        this.isAscending = isAscending;
    }
}

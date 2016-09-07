package com.dmitryvoronko.sort;

/**
 * Created by Dmitry on 07/09/2016.
 */
public final class BubbleSort extends Sort {

    public void sort(Comparable[] comparables) {
        int out, in;
        for (out = comparables.length - 1; out > 1; out--) {
            for (in = 0; in < out; in++) {
                if (comparables[in].compareTo(comparables[in + 1]) > 0) {
                    swap(comparables, in, in + 1);
                }
            }
        }
    }
}

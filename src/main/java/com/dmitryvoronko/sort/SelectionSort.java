package com.dmitryvoronko.sort;

/**
 * Created by Dmitry on 07/09/2016.
 */
public final class SelectionSort extends Sort {

    public void sort(Comparable[] comparables) {
        int out, in, min;

        for (out = 0; out < comparables.length; out++) {
            min = out;
            for (in = out + 1; in < comparables.length; in++) {
                if (comparables[in].compareTo(min) < 0) {
                    min = in;
                }
            }
            swap(comparables, out, min);
        }
    }
}

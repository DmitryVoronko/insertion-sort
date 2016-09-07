package com.dmitryvoronko.sort;

/**
 * Created by Dmitry on 06/09/2016.
 */
public final class InsertionSort implements Sort {

    public final void sort(Comparable[] comparables) {
        int in, out;
        for (out = 1; out < comparables.length; out++) {
            Comparable temp = comparables[out];
            in = out;
            while (in > 0 && comparables[in - 1].compareTo(temp) > 0) {
                comparables[in] = comparables[in - 1];
                --in;
            }
            comparables[in] = temp;
        }
    }

}

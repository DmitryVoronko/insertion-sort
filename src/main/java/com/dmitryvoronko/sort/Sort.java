package com.dmitryvoronko.sort;

/**
 * Created by Dmitry on 06/09/2016.
 */
public abstract class Sort {

    public abstract void sort(Comparable[] comparables);
    public final void swap(Comparable[] comparables, int one, int two) {
        Comparable temp = comparables[one];
        comparables[one] = comparables[two];
        comparables[two] = temp;
    }
}

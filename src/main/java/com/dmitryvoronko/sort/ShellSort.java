package com.dmitryvoronko.sort;

/**
 * Created by Dmitry on 07/09/2016.
 */
public final class ShellSort extends Sort {

    public void sort(Comparable[] comparables) {
        int inner, outer;
        Comparable temp;
        int h = 1;

        while (h <= comparables.length / 3) {
            h = h * 3 + 1;
        }

        while (h > 0) {
            for (outer = h; outer < comparables.length; outer++) {
                temp = comparables[outer];
                inner = outer;

                while (inner > h - 1 && comparables[inner - h].compareTo(temp) > 0) {
                    comparables[inner] = comparables[inner - h];
                    inner -= h;
                }
                comparables[inner] = temp;
            }
            h = (h - 1) / 3;
        }
    }
}

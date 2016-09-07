package com.dmitryvoronko.sort;

import java.util.Comparator;

/**
 * Created by Dmitry on 07/09/2016.
 */
public final class MergeSort extends Sort {

    public void sort(Comparable[] comparables) {
        Comparable[] workcComparables = new Comparable[comparables.length];
        recMergeSort(comparables, workcComparables, 0, comparables.length - 1);
    }

    private void recMergeSort(Comparable[] comparables,
                              Comparable[] workComparables,
                              int lowerBound,
                              int upperBound) {
        if (lowerBound == upperBound) {
            return;
        } else {
            int mid = (lowerBound + upperBound) / 2;

            recMergeSort(comparables, workComparables, lowerBound, mid);

            recMergeSort(comparables, workComparables, mid + 1, upperBound);

            merge(comparables, workComparables, lowerBound, mid + 1, upperBound);
        }
    }

    private void merge(Comparable[] comparables,
                       Comparable[] workComparables,
                       int lowPtr,
                       int highPtr,
                       int upperBound) {
        int j = 0;
        int lowerBound = lowPtr;
        int mid = highPtr - 1;
        int n = upperBound - lowerBound + 1;

        while (lowPtr <= mid && highPtr <= upperBound) {
            if (comparables[lowPtr].compareTo(comparables[highPtr]) < 0){
                workComparables[j++] = comparables[lowPtr++];
            } else {
                workComparables[j++] = comparables[highPtr++];
            }
        }

        while (lowPtr <= mid) {
            workComparables[j++] = comparables[lowPtr++];
        }
        while (highPtr <= upperBound) {
            workComparables[j++] = comparables[highPtr++];
        }

        for (j = 0; j < n; j++) {
            comparables[lowerBound + j] = workComparables[j];
        }


    }
}

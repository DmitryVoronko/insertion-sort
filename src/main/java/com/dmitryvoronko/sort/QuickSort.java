package com.dmitryvoronko.sort;

/**
 * Created by Dmitry on 07/09/2016.
 */
public final class QuickSort extends Sort {

    public void sort(Comparable[] comparables) {
        recQuickSort(comparables, 0, comparables.length - 1);
    }

    private void recQuickSort(Comparable[] comparables, int left, int right) {
        if (right - left <= 0) {
            return;
        } else {
            Comparable pivot = comparables[right];

            int partition = partitionIt(comparables, left, right, pivot);
            recQuickSort(comparables, left, partition - 1);
            recQuickSort(comparables, partition + 1, right);
        }
    }

    private int partitionIt(Comparable[] comparables,
                            int left,
                            int right,
                            Comparable pivot) {
        int leftPtr = left - 1;
        int rigthPtr = right;
        while (true) {
            while (comparables[++leftPtr].compareTo(pivot) < 0) ;
            while (rigthPtr > 0 && comparables[--rigthPtr].compareTo(pivot) > 0) ;

            if (leftPtr >= rigthPtr) {
                break;
            } else {
                swap(comparables, leftPtr, rigthPtr);
            }

        }
        swap(comparables, leftPtr, right);
        return leftPtr;
    }
}

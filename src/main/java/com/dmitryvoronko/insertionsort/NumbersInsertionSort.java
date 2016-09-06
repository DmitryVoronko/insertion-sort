package com.dmitryvoronko.insertionsort;

/**
 * Created by Dmitry on 06/09/2016.
 */
public final class NumbersInsertionSort extends InsertionSort {

    private final long[] numbers;
    private long temp;

    public NumbersInsertionSort(long[] numbers) {
        this.numbers = numbers;
        count = numbers.length;
    }

    protected void allocateTemp() {
        long temp = numbers[out];
    }

    protected void returnTemp() {
        numbers[in] = temp;
    }

    protected boolean isReady() {
        return in > 0 &&
                (isAscending ?
                        numbers[in - 1] >= temp
                        : numbers[in - 1] <= temp);
    }

    protected void swap() {
        numbers[in] = numbers[in - 1];
    }
}

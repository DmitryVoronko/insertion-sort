package com.dmitryvoronko;

/**
 * Created by Dmitry on 06/09/2016.
 */
public class NumbersInsertionSort extends InsertionSort {

    private long[] numbers;
    private long temp;

    public NumbersInsertionSort(long[] numbers) {
        this.numbers = numbers;
        count = numbers.length;
    }

    public void allocateTemp() {
        long temp = numbers[out];
    }

    public void returnTemp() {
        numbers[in] = temp;
    }

    protected boolean isReady() {
        return in > 0 &&
                        isAscending ?
                        numbers[in - 1] >= temp
                        : numbers[in - 1] <= temp;
    }

    protected void swap() {
        numbers[in] = numbers[in - 1];
    }
}

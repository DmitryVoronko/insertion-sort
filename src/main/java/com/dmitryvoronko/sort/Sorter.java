package com.dmitryvoronko.sort;

/**
 * Created by Dmitry on 07/09/2016.
 */
public class Sorter {
    private static final
    String BUBBLE = "-bubble",
            INSERT = "-insert",
            SELECT = "-select",
            SHELL = "-shell",
            MERGE = "-merge",
            QUICK = "-quick";

    private Sort sort;

    public Sorter(String sortMethod) {
        switch (sortMethod) {
            case BUBBLE:
                sort = new BubbleSort();
                break;
            case INSERT:
                sort = new InsertionSort();
                break;
            case SELECT:
                sort = new SelectionSort();
                break;
            case SHELL:
                sort = new ShellSort();
                break;
            case MERGE:
                sort = new MergeSort();
                break;
            case QUICK:
                sort = new QuickSort();
                break;
            default:
                sort = new QuickSort();
                break;
        }
    }

    public void sort(Comparable[] comparables) {
        sort.sort(comparables);
    }
}

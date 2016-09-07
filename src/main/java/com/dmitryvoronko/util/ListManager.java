package com.dmitryvoronko.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitry on 07/09/2016.
 */
public class ListManager {

    private static final String ASCENDING = "-a", DESCENDING = "-d";

    public static void displayList(List<String> lines) {
        for (String line : lines)
            System.out.println(line);
    }

    public static List<String> getListFormComparables(Comparable[] comparables, boolean ascending) {
        List<String> list = new ArrayList<String>();
        if (ascending)
            for (Comparable comparable : comparables)
                list.add(String.valueOf(comparable));
        else
            for (int i = comparables.length - 1; i >= 0; i--)
                list.add(String.valueOf(comparables[i]));
        return list;
    }

    public static List<String> getStrings(String ascending, Comparable[] comparables) {
        List<String> lines;
        switch (ascending) {
            case ASCENDING:
                lines = ListManager.getListFormComparables(comparables, true);
                break;
            case DESCENDING:
                lines = ListManager.getListFormComparables(comparables, false);
                break;
            default:
                lines = ListManager.getListFormComparables(comparables, true);
                break;
        }
        return lines;
    }

}

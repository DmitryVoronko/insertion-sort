package com.dmitryvoronko.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitry on 07/09/2016.
 */
public class ListManager {

    public static void removeEmptyStrings(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            String temp = lines.get(i);
            if (temp.trim().length() == 0) {
                lines.remove(i);
            }
        }
    }

    public static void displayList(List<String> lines, boolean ascending) {
        if (ascending) {
            for (int i = 0; i < lines.size(); i++) {
                System.out.println(lines.get(i));
            }
        } else {
            for (int i = lines.size() - 1; i >= 0; i--) {
                System.out.println(lines.get(i));
            }
        }
    }

    public static List<String> packComparablesToList(Comparable[] comparables, boolean ascending) {
        List<String> list = new ArrayList<String>();
        if (ascending) {
            for (int i = 0; i < comparables.length; i++) {
                list.add(String.valueOf(comparables[i]));
            }
        } else {
            for (int i = comparables.length - 1; i >= 0; i--) {
                list.add(String.valueOf(comparables[i]));
            }
        }
        return list;
    }

}

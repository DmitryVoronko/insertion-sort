package com.dmitryvoronko.util.data;

import java.util.List;

/**
 * Created by Dmitry on 07/09/2016.
 */
public final class IntegerConverter extends Converter {
    public IntegerConverter(List<String> lines) {
        super(lines);
    }

    public Comparable[] convert() {
        for (int i = 0; i < lines.size(); i++) {
            String s = getStringWithoutSpaceAndTabs(lines.get(i));
            isInteger(s);
            comparables[i] = Integer.valueOf(s);
        }
        return comparables;
    }

    protected boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Incorrect input data type. It's not an integer.");
            System.exit(0);
            return false;
        }
    }
}

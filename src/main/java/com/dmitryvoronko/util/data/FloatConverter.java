package com.dmitryvoronko.util.data;

import java.util.List;

/**
 * Created by Dmitry on 07/09/2016.
 */
public final class FloatConverter extends Converter {
    public FloatConverter(List<String> lines) {
        super(lines);
    }

    public Comparable[] convert() {
        for (int i = 0; i < lines.size(); i++) {
            String s = getStringWithoutSpaceAndTabs(lines.get(i));
            isFloat(s);
            comparables[i] = Float.valueOf(s);
        }

        return comparables;
    }

    protected boolean isFloat(String s) {
        try {
            Float.parseFloat(s);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Incorrect input data type. It's not a float.");
            System.exit(0);
            return false;
        }
    }
}

package com.dmitryvoronko.data;

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
            comparables[i] = Integer.valueOf(
                    getStringWithoutSpaceAndTabs(lines.get(i))
            );
        }
        return comparables;
    }
}

package com.dmitryvoronko.data;

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
            comparables[i] = Float.valueOf(
                    getStringWithoutSpaceAndTabs(lines.get(i))
            );
        }

        return comparables;
    }
}

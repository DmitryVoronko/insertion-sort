package com.dmitryvoronko.data;

import java.util.List;

/**
 * Created by Dmitry on 07/09/2016.
 */
public class ComparableConverter {
    private static final String
            STRING = "-s",
            INTEGER = "-i",
            FLOAT = "-f";

    private Converter converter;

    public ComparableConverter(String dataType, List<String> lines) {
        switch (dataType) {
            case STRING:
                converter = new FloatConverter(lines);
                break;
            case INTEGER:
                converter = new IntegerConverter(lines);
                break;
            case FLOAT:
                converter = new FloatConverter(lines);
                break;
            default:
                converter = new StringConverter(lines);
                break;
        }
    }

    public Comparable[] convert(){
        return converter.convert();
    }

}

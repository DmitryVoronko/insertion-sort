package com.dmitryvoronko.data;

import java.util.List;

/**
 * Created by Dmitry on 07/09/2016.
 */
public abstract class Converter {

    protected Comparable[] comparables;
    protected List<String> lines;

    public Converter(List<String> lines) {
        this.comparables = new Comparable[lines.size()];
        this.lines = lines;
        removeEmptyStrings(lines);
    }

    private void removeEmptyStrings(List<String> lines) {
        for (int i = 0; i < lines.size(); i++) {
            String temp = lines.get(i);
            if (temp.trim().length() == 0) {
                lines.remove(i);
            }
        }
    }

    public abstract Comparable[] convert();

    protected String getStringWithoutSpaceAndTabs(String s) {
        return s.replaceAll(" ", "").replaceAll("\t", "");
    }
}

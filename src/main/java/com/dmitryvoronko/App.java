package com.dmitryvoronko;

import com.dmitryvoronko.sort.Sorter;
import com.dmitryvoronko.util.FileManager;
import com.dmitryvoronko.util.ListManager;
import com.dmitryvoronko.util.data.ComparableConverter;

import java.util.List;

/**
 * Created by Dmitry on 05/09/2016.
 */
public class App {


    public static void main(String[] args) {
        start(args);
    }

    public static void start(String[] args) {
        if (args.length >= 2) {
            String inputFile = args[0];
            String outputFile = args[1];
            String dataType = args[2];
            String ascending = args[3];
            String sortMethod = args[4];

            List<String> lines = FileManager.readFile(inputFile);

            //Remove empty strings. Remove tabs and spaces. Convert source data to comparable.
            ComparableConverter comparableConverter = new ComparableConverter(dataType, lines);
            Comparable[] comparables = comparableConverter.convert();

            //Sort data with specific method.
            Sorter sorter = new Sorter(sortMethod);
            sorter.sort(comparables);

            //Pack data to list.
            lines = ListManager.getStrings(ascending, comparables);

            ListManager.displayList(lines);
            FileManager.writeLinesToFile(lines, outputFile);
        } else {
            System.out.println("Incorrect arguments.");
        }
    }


}

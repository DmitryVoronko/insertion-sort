package com.dmitryvoronko;

import com.dmitryvoronko.data.ComparableConverter;
import com.dmitryvoronko.sort.Sorter;
import com.dmitryvoronko.util.FileManager;
import com.dmitryvoronko.util.ListManager;

import java.util.List;

/**
 * Created by Dmitry on 05/09/2016.
 */
public class App {

    public static final String INCORRECT_ARGUMENTS = "Некорректные аргументы.";

    public static void main(String[] args) {
//        App app = new App();
//        String[] arguments;
//        arguments = new String[]{
//            "C:\\Users\\Dmitry\\Documents\\NetBeansProjects\\insertion-sort\\inS.txt",
//                "out.txt",
//                "-s",
//                "-d",
//                "-quick"
//        };
//        app.start(arguments);
        start(args);
    }

    public static void start(String[] args) {
        if (args.length >= 2) {
            String inputFile = args[0];
            String outputFile = args[1];
            String optionOne = args[2];
            String optionTwo = args[3];
            String optionThree = args[4];

            List<String> lines = FileManager.readFile(inputFile);

            ComparableConverter comparableConverter = new ComparableConverter(optionOne, lines);
            Comparable[] comparables = comparableConverter.convert();

            Sorter sorter = new Sorter(optionThree);
            sorter.sort(comparables);

            switch (optionTwo) {
                case "-a":
                    lines = ListManager.packComparablesToList(comparables, true);
                    break;
                case "-d":
                    lines = ListManager.packComparablesToList(comparables, false);
                    break;
                default:
                    lines = ListManager.packComparablesToList(comparables, true);
                    break;
            }
            ListManager.displayList(lines, true);
            FileManager.writeLinesToFile(lines, outputFile);
        } else {
            exitWithMessage(INCORRECT_ARGUMENTS);
        }
    }


    private static void exitWithMessage(String message) {
        System.out.println(message);
        System.exit(0);
    }


}

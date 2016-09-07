package com.dmitryvoronko;

import com.dmitryvoronko.sort.InsertionSort;
import com.dmitryvoronko.sort.Sort;
import com.dmitryvoronko.util.FileManager;
import com.dmitryvoronko.util.ListManager;

import java.util.List;

/**
 * Created by Dmitry on 05/09/2016.
 */
public class App {

    public static final String INCORRECT_ARGUMENTS = "Некорректные аргументы.";
    private static final int MAX_SIZE = 100;

    public static void main(String[] args) {
//        App app = new App();
//        String[] arguments;
//        arguments = new String[]{"C:\\Users\\Dmitry\\Documents\\NetBeansProjects\\insertion-sort\\inI.txt", "out.txt", "-i", "-a"};
//        app.start(arguments);
        start(args);
    }

    public static void start(String[] args) {
        if (args.length >= 4) {
            String inputFile = args[0];
            String outputFile = args[1];
            String optionOne = args[2];
            String optionTwo = args[3];

            List<String> lines = FileManager.readFile(inputFile);
            ListManager.removeEmptyStrings(lines);

            Comparable[] comparables = getComparables(optionOne, lines);

            Sort sort = new InsertionSort();
            sort.sort(comparables);

            switch (optionTwo) {
                case "-a":
                    lines = ListManager.packComparablesToList(comparables, true);
                    break;
                case "-d":
                    lines = ListManager.packComparablesToList(comparables, false);
                    break;
                default:
                    exitWithMessage(INCORRECT_ARGUMENTS);
                    break;
            }
            System.out.println("RESULT");
            ListManager.displayList(lines, true);
            FileManager.writeLinesToFile(lines, outputFile);
        } else {
            exitWithMessage(INCORRECT_ARGUMENTS);
        }
    }

    private static Comparable[] getComparables(String optionOne, List<String> lines) {
        Comparable[] comparables = new Comparable[lines.size()];
        switch (optionOne) {
            case "-s":
                for (int i = 0; i < lines.size(); i++) {
                    comparables[i] = String.valueOf(lines.get(i));
                }
                break;
            case "-i":
                for (int i = 0; i < lines.size(); i++) {
                    String stringWithoutSpaces = lines.get(i).replaceAll(" ", "");
                    String stringWithoutTabs = stringWithoutSpaces.replaceAll("\t", "");
                    comparables[i] = Integer.valueOf(stringWithoutTabs);
                }
                break;
            default:
                exitWithMessage(INCORRECT_ARGUMENTS);
                break;
        }
        return comparables;
    }

    private static void exitWithMessage(String message) {
        System.out.println(message);
        System.exit(0);
    }


}

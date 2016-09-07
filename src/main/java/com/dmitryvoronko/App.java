package com.dmitryvoronko;

import com.dmitryvoronko.sort.*;
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
        if (args.length >= 4) {
            String inputFile = args[0];
            String outputFile = args[1];
            String optionOne = args[2];
            String optionTwo = args[3];
            String optionThree = args[4];

            List<String> lines = FileManager.readFile(inputFile);
            ListManager.removeEmptyStrings(lines);

            Comparable[] comparables = getComparables(optionOne, lines);

            Sort sort = getSort(optionThree);

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
            ListManager.displayList(lines, true);
            FileManager.writeLinesToFile(lines, outputFile);
        } else {
            exitWithMessage(INCORRECT_ARGUMENTS);
        }
    }

    private static Sort getSort(String optionThree) {
        Sort sort;
        switch (optionThree) {
            case "-bubble":
                sort = new BubbleSort();
                break;
            case "-insert":
                sort = new InsertionSort();
                break;
            case "-select":
                sort = new SelectionSort();
                break;
            case "-shell":
                sort = new ShellSort();
                break;
            case "-merge":
                sort = new MergeSort();
                break;
            case "-quick":
                sort = new QuickSort();
                break;
            default:
                sort = new InsertionSort();
                break;
        }
        return sort;
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
                    comparables[i] = Integer.valueOf(
                        getStringWithoutSpaceAndTabs(lines.get(i))
                    );
                }
                break;
            case "-f":
                for (int i = 0; i < lines.size(); i++) {
                    comparables[i] = Float.valueOf(
                            getStringWithoutSpaceAndTabs(lines.get(i))
                    );
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

    private static String getStringWithoutSpaceAndTabs(String s) {
        return  s.replaceAll(" ", "").replaceAll("\t", "");
    }


}

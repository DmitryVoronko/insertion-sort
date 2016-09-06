package com.dmitryvoronko;

import com.dmitryvoronko.insertionsort.InsertionSort;
import com.dmitryvoronko.insertionsort.LinesInsertionSort;
import com.dmitryvoronko.insertionsort.NumbersInsertionSort;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dmitry on 05/09/2016.
 */
public class App {

    private static final int MAX_SIZE = 100;
    public static final String INCORRECT_ARGUMENTS = "Некорректные аргументы.";

    public static void main(String[] args) throws IOException {
        App app = new App();
        String[] arguments;
        arguments = new String[]{"C:\\Users\\Dmitry\\Documents\\NetBeansProjects\\insertion-sort\\in.txt", "out.txt", "-s", "-a"};
        app.start(arguments);
    }

    public void start(String[] args) throws IOException {
        if (args.length >= 4) {
            String inputFile = args[0];
            String outputFile = args[1];
            String optionOne = args[2];
            String optionTwo = args[3];

            checkLinesCount(inputFile);

            List<String> list = FileManager.readFile(inputFile);

            String[] lines = new String[list.size()];

            for (int i = 0; i < list.size(); i++) {
                lines[i] = list.get(i);
            }

            for (int i = 0; i < lines.length; i++) {
                System.out.println(lines[i]);
            }

            initSort(lines, optionOne, optionTwo);
            System.out.println("----RESULT----");
            for (int i = 0; i < lines.length; i++) {
                System.out.println(lines[i]);
            }
            

        } else {
            exitWithMessage(INCORRECT_ARGUMENTS);
        }
    }

    public void initSort(String[] lines, String optionOne, String optionTwo) {
        InsertionSort insertionSort = null;

        switch (optionOne) {
            case "-s":
                insertionSort = new LinesInsertionSort(lines);
                break;
            case "-i":
                int size = lines.length;
                long[] temp = new long[size];
                for (int i = 0; i < size; i++) {
                    temp[i] = Long.parseLong(lines[i]);
                }
                insertionSort = new NumbersInsertionSort(temp);
                break;
            default:
                exitWithMessage(INCORRECT_ARGUMENTS);
                break;
        }


        switch (optionTwo) {
            case "-a":
                insertionSort.setAscending(true);
                break;
            case "-d":
                insertionSort.setAscending(false);
                break;
            default:
                exitWithMessage(INCORRECT_ARGUMENTS);
                break;
        }

        insertionSort.sort();
    }

    private void exitWithMessage(String message) {
        System.out.println(message);
        System.exit(0);
    }

    private void checkLinesCount(String filePath) throws IOException {
        if (FileManager.getLinesCount(filePath) > MAX_SIZE) {
            exitWithMessage("Превышено допустимое количество строк в файле. Строк больше " + MAX_SIZE + "!");
        }
    }

    private void writeFile(List list, String[] lines, String outputFile) {
        list = new ArrayList<String>();

        for (int i = 0; i <lines.length; i++) {
            list.add(lines[i]);
        }

        FileManager.writeFile(outputFile, list);
    }

}

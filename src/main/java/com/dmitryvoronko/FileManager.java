package com.dmitryvoronko;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Dmitry on 05/09/2016.
 */
public class FileManager {

    public static long getLinesCount(String filePath) {
        long result = 0;
        try {
            result = Files.lines(Paths.get(filePath)).count();
        } catch (IOException e) {
            System.out.println("Невозможно посчитать количесво строк в файле.");
        }
        return result;
    }

    public static List<String> readFile(String filePath) {
        List<String> result = null;
        try {
            result = Files.lines(Paths.get(filePath), StandardCharsets.ISO_8859_1).collect(Collectors.toList());
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл.");
        }
        return result;
    }

    public static void writeFile(String filePath, List<String> lines) {
        try {
            Files.write(Paths.get(filePath), lines);
        } catch (IOException e) {
            System.out.println("Невозможно записать файл.");
        }
    }
}

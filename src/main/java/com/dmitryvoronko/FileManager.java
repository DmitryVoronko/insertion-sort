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

    public static long getLinesCount(String filePath) throws IOException {
        return Files.lines(Paths.get(filePath)).count();
    }

    public static List<String> readFile(String filePath) throws IOException {
         return Files.lines(Paths.get(filePath), StandardCharsets.ISO_8859_1).collect(Collectors.toList());
    }

    public static void writeFile(String filePath, List<String> lines) throws IOException {
        Files.write(Paths.get(filePath), lines);
    }
}

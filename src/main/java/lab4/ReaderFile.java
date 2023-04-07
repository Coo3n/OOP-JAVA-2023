package lab4;

import lab4.exceptions.InvalidFileFormatException;
import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;
import java.util.stream.Collectors;


public class ReaderFile {
    private static ReaderFile instance;
    private BufferedReader bufferedReader;

    private ReaderFile() {
    }

    public static ReaderFile getInstance() {
        if (instance == null) {
            instance = new ReaderFile();
        }
        return instance;
    }


    @SneakyThrows
    public Map<String, String> getDictionaryOfTextFile(File file) {
        if (!file.exists()) {
            throw new InvalidFileFormatException();
        }

        bufferedReader = new BufferedReader(new FileReader(file));

        return bufferedReader.lines()
                .filter(str -> !str.isEmpty())
                .map(str -> str.toLowerCase().split("[|]"))
                .filter(strings -> strings.length == 2)
                .sorted(new Comparator<String[]>() {
                    @Override
                    public int compare(String[] o1, String[] o2) {
                        return o2[0].length() - o1[0].length();
                    }
                })
                .collect(Collectors.toMap(
                        strings -> strings[0].trim(),
                        strings -> strings[1].trim(),
                        (x, y) -> y,
                        LinkedHashMap::new
                ));
    }

    @SneakyThrows
    public String getTextFile(File file) {
        if (!file.exists()) {
            throw new InvalidFileFormatException();
        }

        bufferedReader = new BufferedReader(new FileReader(file));

        return bufferedReader.lines()
                .filter(str -> !str.isEmpty())
                .collect(Collectors.joining());
    }
}

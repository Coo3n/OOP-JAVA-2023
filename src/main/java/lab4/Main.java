package lab4;

import java.io.*;
import java.util.Map;

public class Main {
    private static final File PATH_DICTIONARY_FILE = new File("src/main/java/lab4/textFiles/test.txt");
    private static final File PATH_INPUT_FILE = new File("src/main/java/lab4/textFiles/input.txt");

    public static void main(final String[] arg) {
        ReaderFile readerFile = new ReaderFile();
        Map<String, String> dictionary = readerFile.getDictionaryOfTextFile(PATH_DICTIONARY_FILE);
        String textFile = readerFile.getTextFile(PATH_INPUT_FILE);
        Translator translator = new Translator(dictionary);
        System.out.println(translator.getTranslateString(textFile));
    }
}

package lab4;

import lombok.SneakyThrows;

import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static final File PATH_DICTIONARY_FILE = new File("src/main/java/lab4/textFiles/test.txt");
    private static final File PATH_INPUT_FILE = new File("src/main/java/lab4/textFiles/input.txt");

    private Main() {

    }

    @SneakyThrows
    private static void solve(final FastScanner in, final PrintWriter out) {
        ReaderFile readerFile = ReaderFile.getInstance();
        Map<String, String> dictionary = readerFile.getDictionaryOfTextFile(PATH_DICTIONARY_FILE);
        String textFile = readerFile.getTextFile(PATH_INPUT_FILE);
        Translator translator = new Translator(dictionary);
        out.println(translator.getTranslateString(textFile));
    }

    private static final class FastScanner {
        private final BufferedReader reader;
        private StringTokenizer tokenizer;

        FastScanner(final InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

    public static void main(final String[] arg) {
        final FastScanner in = new FastScanner(System.in);
        try (PrintWriter out = new PrintWriter(System.out)) {
            solve(in, out);
        }
    }
}

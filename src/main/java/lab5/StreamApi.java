package lab5;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public final class StreamApi {
    public static final ArrayList<Integer> INTEGER_ARRAY_LIST = new ArrayList<>(List.of(1, 2, 2, 3, 4, 5));
    public static final ArrayList<String> STRING_ARRAY_LIST = new ArrayList<>(List.of(
            "Imran",
            "Ilya",
            "Valerik",
            "Kwazimota",
            "Imran"
    ));

    private static final int[] SIMPLE_ARRAY = {1, 2, 3, 4, 5};

    private StreamApi() {
    }

    private static double getAverageValueArray(ArrayList<Integer> list) {
        return list.stream()
                .mapToInt(x -> x)
                .average()
                .orElse(0);
    }

    private static List<String> getNewListStringWithNewPrefix(List<String> list) {
        return list.stream()
                .map(str -> "_new_".concat(str.toUpperCase()))
                .collect(Collectors.toCollection((ArrayList::new)));
    }

    private static List<Integer> getArrayOfSquaresEncounteredElements(List<Integer> list) {
        return list.stream()
                .distinct()
                .filter(element -> Collections.frequency(list, element) == 1)
                .map(element -> element * element)
                .collect(Collectors.toCollection((ArrayList::new)));
    }

    private static List<String> getListWordsStartingWithSymbol(List<String> list, Character symbol) {
        return list.stream()
                .filter(str -> str.startsWith(String.valueOf(symbol)))
                .sorted()
                .collect(Collectors.toCollection((ArrayList::new)));
    }

    private static <T> T getLastElementCollection(Collection<T> collection) {
        return collection.stream()
                .reduce((a, b) -> b)
                .orElseThrow(IllegalArgumentException::new);
    }

    private static int getSumEvenNumbers(int[] array) {
        return Arrays.stream(array)
                .filter(element -> element % 2 == 0)
                .sum();
    }

    private static Map<Character, String> getDictionaryOfList(List<String> list) {
        return list.stream()
                .filter(str -> !str.isEmpty())
                .collect(Collectors.toMap(str -> str.charAt(0),
                        str -> str.substring(1),
                        (s1, s2) -> s1 + ", " + s2));
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        out.println("1) Метод, возвращающий среднее значение списка целых чисел");
        out.println("Среднее значение INTEGER_ARRAY_LIST: " + getAverageValueArray(INTEGER_ARRAY_LIST));


        out.println("2) метод, приводящий все строки в списке в верхний регистр и добавляющий к ним префикс «_new_»");
        out.println("Было:");
        STRING_ARRAY_LIST.forEach(out::println);
        out.println("Стало:");
        getNewListStringWithNewPrefix(STRING_ARRAY_LIST).forEach(out::println);


        out.println("3) метод, возвращающий список квадратов всех встречающихся только один раз элементов списка");
        out.println("Было:");
        INTEGER_ARRAY_LIST.forEach(out::println);
        out.println("Стало:");
        getArrayOfSquaresEncounteredElements(INTEGER_ARRAY_LIST).forEach(out::println);


        out.println("4) метод, принимающий на вход коллекцию строк и возвращает все" +
                "строки, начинающиеся с заданной буквы, отсортированные по алфавиту");
        out.println("Было:");
        STRING_ARRAY_LIST.forEach(out::println);
        out.println("Стало:");
        getListWordsStartingWithSymbol(STRING_ARRAY_LIST, 'I').forEach(out::println);


        out.println("5) метод, принимающий на вход коллекцию и возвращающий ее" +
                "последний элемент или кидающий исключение, если коллекция пуста");
        out.println(getLastElementCollection(STRING_ARRAY_LIST));


        out.println("6) метод, принимающий на вход массив целых чисел," +
                "возвращающий сумму чётных чисел или 0, если чётных чисел нет");
        out.println(getSumEvenNumbers(SIMPLE_ARRAY));


        out.println("7) метод, преобразовывающий все строки в списке в Map, гдe первый символ – ключ, оставшиеся – значение");
        out.println(getDictionaryOfList(STRING_ARRAY_LIST));
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

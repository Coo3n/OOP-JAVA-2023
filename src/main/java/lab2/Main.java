package lab2;


import lombok.SneakyThrows;

import java.io.*;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public final class Main {
    private static final TestClass TEST_CLASS = new TestClass();

    private Main() {
    }

    private static ArrayList<Method> getMethodsWithMyAnnotationOfClass(Class<?> clazz) {
        return Arrays.stream(clazz.getDeclaredMethods())
                .filter(method -> !Modifier.isPublic(method.getModifiers()) &&
                        method.isAnnotationPresent(MyAnnotation.class))
                .collect(Collectors.toCollection(ArrayList::new));
    }

    @SneakyThrows
    private static <T> void callMethodCertainNumber(Method method, int cntIterations, T argumentForMethod) {
        for (int i = 0; i < cntIterations; i++) {
            method.invoke(TEST_CLASS, argumentForMethod);
        }
    }

    private static void solve(final FastScanner in, final PrintWriter out) {
        ArrayList<Method> methods = getMethodsWithMyAnnotationOfClass(TEST_CLASS.getClass());
        methods.forEach(method -> {
            int cntIterations = method.getAnnotation(MyAnnotation.class).cntIterations();
            Type typeParameter = method.getGenericParameterTypes()[0];

            method.setAccessible(true);

            if (int.class.equals(typeParameter)) {
                callMethodCertainNumber(method, cntIterations, 2);
            } else if (Boolean.class.equals(typeParameter)) {
                callMethodCertainNumber(method, cntIterations, true);
            } else if (String.class.equals(typeParameter)) {
                callMethodCertainNumber(method, cntIterations, "krutotenь");
            }

            method.setAccessible(false);
        });
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


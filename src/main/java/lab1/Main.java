package lab1;

import lombok.SneakyThrows;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public final class Main {
    private final static String SET_FLYING_MOVE_TYPE_HERO_COMMAND = "FLYING";
    private final static String SET_WALKING_MOVE_TYPE_HERO_COMMAND = "WALKING";
    private final static String MOVE_COMMAND = "MOVE";
    private final static String SHOW_CURRENT_COORDINATES = "COORDINATES";
    private final static String EXIT_PROGRAM_COMMAND = "EXIT";
    private final static String UNKNOWN_COMMAND = "UNKNOWN_COMMAND";

    private Main() {
    }

    @SneakyThrows
    private static void solve(final FastScanner in, final PrintWriter out) {
        String currentCommand = "";
        Hero hero = new Hero(new WalkingMoveType()); // default

        while (!currentCommand.equals(EXIT_PROGRAM_COMMAND)) {
            currentCommand = in.reader.readLine().trim();

            switch (currentCommand) {
                case SET_FLYING_MOVE_TYPE_HERO_COMMAND -> hero.setMoveType(new FlyingMoveType());
                case SET_WALKING_MOVE_TYPE_HERO_COMMAND -> hero.setMoveType(new WalkingMoveType());
                case MOVE_COMMAND -> hero.move(new Point(in.nextInt(), in.nextInt()));
                case SHOW_CURRENT_COORDINATES -> hero.showCurrentCoordinates();
                case EXIT_PROGRAM_COMMAND -> out.println("Программа завершила свою работу");
                default -> out.println(UNKNOWN_COMMAND);
            }
        }
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

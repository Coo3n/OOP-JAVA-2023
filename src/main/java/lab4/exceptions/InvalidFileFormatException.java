package lab4.exceptions;

public class InvalidFileFormatException extends Exception {
    public final static String ERROR = "Неверный формат записи файла";

    public InvalidFileFormatException() {
        super(ERROR);
    }
}

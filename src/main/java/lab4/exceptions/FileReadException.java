package lab4.exceptions;

public class FileReadException extends Exception {
    public final static String ERROR = "Неверный формат записи файла";

    public FileReadException() {
        super(ERROR);
    }
}

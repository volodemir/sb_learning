package Task_2.Exception;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Содержимое файла: " + readFile());
        System.out.println("Попытка печати");
        try {
            print();
        } catch (PrinterNoPaperException e) {
            System.out.println(e.getMessage());
            System.out.println("Загрузите бумагу в принтер");
        } catch (RuntimeException e) {
            System.out.println("Что-то пошло не так. Общая ошибка принтера");
        }
    }
    private static String readFile() {
        String content = null;
        try {
            String path = "D:/workspace/1/src/Task_2/Exception/example.txt";
            content = Files.lines(Paths.get(path)).collect(Collectors.joining());
        } catch (IOException | RuntimeException e) {
            System.out.println("Попытка чтения файла не удалась! Проверьте наличие файла");
            e.printStackTrace();
        }
        return content;
    }
    private static void print() {
        if (true) {
            throw new ArithmeticException("Ошибка в файле который мы хотим печатать");
        }
        // какой-то код
        throw new PrinterNoPaperException("Закончилась бумага в принтере");
    }
}

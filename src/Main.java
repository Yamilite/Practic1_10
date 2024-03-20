import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Вариант 3, Куранов Нурлан Расуллаевич ");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к исходному файлу: ");
        String inputFilePath = scanner.nextLine();
        System.out.print("Введите байты гаммы (должно быть два символа): ");
        String gammaString = scanner.nextLine();

        if (gammaString.length() != 2) {
            System.out.println("Ошибка: Длина гаммы должна быть два символа.");
            return;
        }

        byte[] gammaBytes = gammaString.getBytes();

        try {
            FileInputStream inputStream = new FileInputStream(inputFilePath);
            byte[] inputBytes = new byte[inputStream.available()];
            inputStream.read(inputBytes);
            inputStream.close();

            for (int i = 0; i < inputBytes.length; i++) {
                inputBytes[i] ^= gammaBytes[i % 2];
            }

            String outputFilePath = inputFilePath.substring(0, inputFilePath.lastIndexOf('.')) + "_modified.txt";
            FileOutputStream outputStream = new FileOutputStream(outputFilePath);
            outputStream.write(inputBytes);
            outputStream.close();

            System.out.println("Файл успешно модифицирован. Результат сохранен в " + outputFilePath);
        } catch (IOException e) {
            System.out.println("Ошибка при чтении/записи файла: " + e.getMessage());
        }
    }
}

package readability;

import java.io.File;
import java.util.Scanner;

public class MyReadFile {


    public static String readFile(String fileName) {
        File fileIn = new File(fileName);
        StringBuilder stringBuilder = new StringBuilder();

        try (Scanner scanner = new Scanner(fileIn)) {
            while (scanner.hasNextLine()) {
                stringBuilder.append(scanner.nextLine());
            }
        } catch (Exception e) {
            System.out.println("File not found");
        }
        return stringBuilder.toString();
    }
}

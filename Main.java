package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    private static String operation = "enc";
    private static String text = "";
    private static int key = 0;
    private static String result = "";
    private static String fileIn;
    private static String fileOut;
    private static boolean flag = false;
    private static boolean flagRead = false;


    public static void encryption(String text, int key) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] += key;
            result += chars[i];
        }
        outText();
    }

    public static void decryption(String text, int key) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] -= key;
            result += chars[i];
        }
        outText();
    }

    public static void outText() {
        if (flag)
            writeFile();
        else System.out.println(result);
    }

    public static void readFile() {
        if (!flagRead) {
            File file = new File(fileIn);

            try (Scanner scanner = new Scanner(file)) {
                while (scanner.hasNext()) {
                    text += scanner.nextLine();
                }
            } catch (FileNotFoundException e) {
                System.out.println("Error");
            }
        }
    }

    public static void writeFile() {
        File file = new File(fileOut);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(result);
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public static void main(String[] args) {

        for (int i = 0; i < args.length - 1; i++) {
            switch (args[i]) {
                case "-mode":
                    operation = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    text = args[i + 1];
                    flagRead = true;
                    break;
                case "-in":
                    fileIn = args[i + 1];
                    readFile();
                    break;
                case "-out":
                    flag = true;
                    fileOut = args[i + 1];
                    break;
            }
        }

        switch (operation) {
            case "enc":
                encryption(text, key);
                break;
            case "dec":
                decryption(text, key);
                break;
        }

    }
}

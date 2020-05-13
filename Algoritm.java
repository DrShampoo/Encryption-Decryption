package encryptdecrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public abstract class Algoritm {
    protected static int key = 0;
    protected static String text = "";
    protected static String result = "";
    protected static String fileIn;
    protected static String fileOut;
    protected static boolean flag = false;
    protected static boolean flagRead = false;

    public abstract void encryption();

    public abstract void decryption();

    public void outText() {
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

    public void writeFile() {
        File file = new File(fileOut);

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(result);
        } catch (IOException e) {
            System.out.println("Error");
        }
    }

    public void workingProcess(String operation){
        readFile();
        if (operation.equals("enc"))
            encryption();
        else if (operation.equals("dec"))
            decryption();
    }
}

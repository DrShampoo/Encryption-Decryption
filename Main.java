package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void encryption(String text, int key) {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] += key;
            System.out.print(chars[i]);
        }

    }

    public static void decryption(String text, int key){
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++){
            chars[i] -= key;
            System.out.print(chars[i]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String operation = scanner.nextLine();
        String text = scanner.nextLine();
        int key = scanner.nextInt();

        switch (operation){
            case "enc":
                encryption(text, key);
                break;
            case "dec":
                decryption(text, key);
                break;
        }

    }
}

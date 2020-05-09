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
        String operation = "enc";
        String text = "";
        int key = 0;

        for (int i = 0; i < args.length-1; i++){
            switch (args[i]) {
                case "-mode":
                    operation = args[i + 1];
                    break;
                case "-key":
                    key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    text = args[i + 1];
                    break;
            }
        }

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

package encryptdecrypt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        int key = scanner.nextInt();
        String mySimple = "abcdefghijklmnopqrstuvwxyz";
//        String myRevert = new String ("zyxwvutsrqponmlkjihgfedcba");
        char[] abc = mySimple.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < abc.length; j++) {
                if (chars[i] == abc[j]) {
                    chars[i] = abc[(j + key) % 26];
                    break;
                }
            }
            System.out.print(chars[i]);
        }
    }
}

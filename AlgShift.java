package encryptdecrypt;

import javafx.css.Match;

public class AlgShift extends Algoritm {

    public void encryption() {
        char[] chars = text.toCharArray();

        String mySimple = "abcdefghijklmnopqrstuvwxyz";
        String mySimpleUp = mySimple.toUpperCase();

        char[] abc = mySimple.toCharArray();
        char[] abcUp = mySimpleUp.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < abc.length; j++) {
                if (chars[i] == abc[j]) {
                    chars[i] = abc[(j + key) % 26];
                    result += chars[i];
                    break;
                } else if (chars[i] == abcUp[j]) {
                    chars[i] = abcUp[(j + key) % 26];
                    result += chars[i];
                    break;
                } else if (!mySimple.contains(String.valueOf(chars[i]).toLowerCase())) {
                    result += chars[i];
                    break;
                }
            }
        }
        outText();
    }

    public void decryption() {
        char[] chars = text.toCharArray();

        String mySimple = "abcdefghijklmnopqrstuvwxyz";
        String mySimpleUp = mySimple.toUpperCase();

        char[] abc = mySimple.toCharArray();
        char[] abcUp = mySimpleUp.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < abc.length; j++) {
                if (chars[i] == abc[j]) {
                    chars[i] = abc[((j - key) < 0 ? (26 + j - key) : (j - key)) % 26];
                    result += chars[i];
                    break;
                } else if (chars[i] == abcUp[j]) {
                    chars[i] = abcUp[((j - key) < 0 ? (26 + j - key) : (j - key)) % 26];
                    result += chars[i];
                    break;
                }else if (!mySimple.contains(String.valueOf(chars[i]).toLowerCase())) {
                    result += chars[i];
                    break;
                }
            }
        }
        outText();
    }
}


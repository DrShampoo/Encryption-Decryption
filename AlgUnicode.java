package encryptdecrypt;

public class AlgUnicode extends Algoritm {

    public void encryption() {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] += key;
            result += chars[i];
        }
        outText();
    }

    public void decryption() {
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] -= key;
            result += chars[i];
        }
        outText();
    }
}

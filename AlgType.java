package encryptdecrypt;

public class AlgType {

    public Algoritm algCreate(String alg){
        if (alg.equals("shift"))
            return new AlgShift();
        else if (alg.equals("unicode"))
            return new AlgUnicode();
        return null;
    }
}

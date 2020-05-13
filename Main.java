package encryptdecrypt;

public class Main {
    public static void main(String[] args) {
        String alg = "shift";
        String operation = "enc";

        for (int i = 0; i < args.length - 1; i++) {
            switch (args[i]) {
                case "-mode":
                    operation = args[i + 1];
                    break;
                case "-key":
                    Algoritm.key = Integer.parseInt(args[i + 1]);
                    break;
                case "-data":
                    Algoritm.text = args[i + 1];
                    Algoritm.flagRead = true;
                    break;
                case "-in":
                    Algoritm.fileIn = args[i + 1];
                    break;
                case "-out":
                    Algoritm.flag = true;
                    Algoritm.fileOut = args[i + 1];
                    break;
                case "-alg":
                    alg = args[i + 1];
                    break;
            }
        }
        AlgType algType = new AlgType();
        Algoritm algoritm = algType.algCreate(alg);
        algoritm.workingProcess(operation);
    }
}

import java.util.*;

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        sc.close();

        String result = "";

        result = poliomino(s);

        System.out.println(result);
    }

    private static String poliomino(String s) {
        String src = "";
        String A = "AAAA", B = "BB";

        s = s.replaceAll("XXXX", A);
        src = s.replaceAll("XX", B);

        if(src.contains("X")) {
            src = "-1";
        }

        return src;
    }
}

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int rslt = 0;

        while (n >= k) {
            if (n % k != 0) {
                n--;
                rslt++;
            } else {
                n /= k;
                rslt++;
            }
        }
        while (n > 1) {
            n--;
            rslt++;
        }
        System.out.println(rslt);
    }
}
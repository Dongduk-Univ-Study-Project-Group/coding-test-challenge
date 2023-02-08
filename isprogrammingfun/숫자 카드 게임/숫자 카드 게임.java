import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    int m = sc.nextInt();

    int min = 9999999;
    int max = -9999999;
    int small = 0;
    int big = 0;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
          small = sc.nextInt();
          min = Math.min(min, small);
        }
      max = Math.max(max, min);
      min = 9999999;
    }
      System.out.println(max);
    }
}
import java.util.*;
import java.io.*;
import java.nio.file.FileVisitResult;

public class Main {
    
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int rslt = 0;

    int n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt();

    int[] arr = new int[n];

    for(int i = 0; i < n; i++){
      arr[i] = sc.nextInt();
    }
    Arrays.sort(arr);
    int first = arr[n-1];
    int second = arr[n-2];

    while(true) {
      for (int i = 0; i < k; i++){
        if(m == 0)
        break;
        else {
          rslt += first;
          m --;
        }
      }
      if(m == 0)
      break;

      rslt += second;
      m--;
    }
    System.out.println(rslt);

  }
}
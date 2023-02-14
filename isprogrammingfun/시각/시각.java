import java.util.*;

public class Main {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int cnt = 0;

        for (int h = 0; h <= t; h++) {
            for (int m = 0; m < 60; m++) {
                for (int s = 0; s < 60; s++) {
                    // 매 시각 안에 '3'이 포함되어 있다면 카운트 증가
                    if (h % 10 == 3 || m / 10 == 3 || m % 10 == 3 || s / 10 == 3 || s % 10 == 3) cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

}
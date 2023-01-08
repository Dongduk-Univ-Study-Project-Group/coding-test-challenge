import java.io.*;
import java.util.*;

public class Main {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        int[] dp = new int[100001];
        dp[1] = -1;
        dp[2] = 1;
        dp[3] = -1;
        dp[4] = 2;
        dp[5] = 1;

        for(int i = 6; i <= num; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for(int i = 6; i <= num; i++) {
            if(dp[i-2] == -1 && dp[i-5] == -1){
                dp[i] = -1;
            }else if (dp[i-2] == -1) {
                dp[i] = dp[i-5] + 1;
            }else if (dp[i-5] == -1) {
                dp[i] = dp[i-2] + 1;
            }else {
                dp[i] = Math.min(dp[i-2], dp[i-5]) + 1;
            }
        }
        System.out.println(dp[num]);
    }
}
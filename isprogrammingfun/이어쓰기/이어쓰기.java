import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;	// 자릿수
		int plus = 1;	// 자릿수에 더하는 값
		int num = 10;	// 몇 자릿수 더할지 판단
		for(int i=1; i<=N; i++) {
			// 자릿수 바뀌는 조건 => 10, 100, 1000, 10000, ...
			if(i%num == 0) {
				plus ++;
				num *= 10;
			}
			count += plus;

		}
		System.out.println(count);
		sc.close();
	}
}
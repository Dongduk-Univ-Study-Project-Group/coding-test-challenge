import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int t = sc.nextInt();
		int move = 0;
		
		int left = 0;
		int right = 0 + (m - 1);
		
		for(int i = 0; i < t; i++) {
			int tmp = sc.nextInt() - 1;
			if(tmp > right) {
				move += tmp - right;
				right = tmp;
				left = tmp - (m - 1);
			}
			else if(tmp < left) {
				move += left - tmp;
				left = tmp;
				right = tmp + (m - 1);
			}
		}
		System.out.println(move);
	}
}
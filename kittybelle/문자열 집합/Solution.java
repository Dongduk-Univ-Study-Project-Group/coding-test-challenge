import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		String[] s = new String[n];
		String[] a = new String[m]; 
		
		int j = 0;
		for(int i = 0; i < n + m; i++) {
			// nextLine()쓰면 정수 입력 후 엔터값 남아서 입력 안 받고 넘어감
			if(i < n) {
				s[i] = sc.next(); 
			} else {
				a[j++] = sc.next();
			}
		}
		System.out.println(numOfS(s, a));
		
		sc.close();
	}

	public static int numOfS(String[] s, String[] a) {

		int num = 0;
		
		for(int i = 0; i < a.length; i++) { 
			for(int j = 0; j < s.length; j++) {
				if(a[i].length() == s[j].length()) {
					if(a[i].equals(s[j])) {
						num += 1;
					}
				}
			}
		}
		return num;
	}

}

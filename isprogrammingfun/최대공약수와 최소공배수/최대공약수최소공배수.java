import java.util.Scanner; 

public class Main {
	// 최대공약수 구하기
	public static int GCD(int a, int b)
	{
		if (b == 0) {
			return a;
		}
		else {
			return GCD(b, a % b);
		}
	}

	// 최소공배수 구하기
	public static int LCM(int a, int b) 
	{
		return a * b / GCD(a, b);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(GCD(a,b));
		System.out.println(LCM(a,b));
        sc.close();
	}
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		if(n == 2) {
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			for(int i = 1; i <= Math.min(num1, num2); i++) {
				if(num1 % i == 0 && num2 % i == 0) {
					System.out.println(i);
				}
			}
		}else {
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			int num3 = Integer.parseInt(st.nextToken());
			for(int i = 1; i <= Math.min(num1, Math.min(num2, num3)); i++) {
				if(num1 % i == 0 && num2 % i == 0 && num3 % i == 0) {
					System.out.println(i);
				}
			}
		}
	}

}
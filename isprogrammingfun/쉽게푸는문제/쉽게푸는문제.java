import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        sc.close();
        int sum = 0; int count = 0;
        
		for(int i=1;;i++) {
			for(int j=1;j<=i;j++) {
				count++;
				if(count >= start && count <= end)
					sum+=i;			
			}
			if(count > end)
				break;
		}
		System.out.println(sum);
	}
}
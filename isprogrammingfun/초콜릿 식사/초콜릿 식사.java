import java.util.Scanner; 

public class Main {
    
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int k = scan.nextInt();	
		int size = 1;
        int s = 0;
		int count = 0;
		
		while(size < k) {
			size *= 2;
		}
        s = size;
        
		while(k > 0) {
			if(k>=size) {
				k-=size;
			}else {
				size /= 2;
				count++;
			}
		}
		System.out.println(s + " " + count);
    }
}
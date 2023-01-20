import java.util.Scanner; 

public class Main {
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int count = 0;
        for (int i = 0; i < num; i++)
        {
            boolean isPrime = true;
            int a = sc.nextInt();
            
           if(a == 1) {
				continue;
			}
            for(int j = 2; j <= Math.sqrt(a); j++)
            {
                if(a % j == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime)
                count ++;
        }
        System.out.println(count);
    }
}
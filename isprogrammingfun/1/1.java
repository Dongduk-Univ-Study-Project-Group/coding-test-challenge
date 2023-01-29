import java.util.Scanner; 

public class Main {
    public static void main (String [] args){
        Scanner sc = new Scanner(System.in);
        
        while(sc.hasNextInt()){
            int num = sc.nextInt();
            int n = 0;
            for(int i = 1; ; i++)
            {
                n = (n * 10) + 1;
                n = n % num;
                if(n == 0){
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
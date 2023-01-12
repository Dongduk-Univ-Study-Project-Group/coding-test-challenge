import java.util.*;

public class Main {
	
	public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt(); // 시
		int m = sc.nextInt(); // 분
		sc.close();
        
        if(m < 45){
            m = m + 60 - 45;
            if(h == 0)
                h = 23;
            else
                h = h - 1;
        }
        else
            m = m - 45;
        
        System.out.println(h + " " + m);
    }
}
import java.util.*;
 
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String str = sc.nextLine();
        sc.close();
        int cnt = 0;
 
        text = text.replaceAll(str, "1");
 
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '1') {
                cnt++;
            }
        }
 
        System.out.println(cnt);
    }
}

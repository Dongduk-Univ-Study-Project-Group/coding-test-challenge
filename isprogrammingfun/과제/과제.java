import java.util.*;
import java.util.stream.IntStream;

public class Main {
    public static int j = 0;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int[] student = new int[30];
        ArrayList<Integer> s = new ArrayList<Integer>();
        for(int i = 0; i < 28; i++) {
            int num = sc.nextInt();
            student[i] = num;
        }

        for(j = 0; j < 30; j++){
            if(IntStream.of(student).anyMatch(x -> x == j + 1))
                continue;
            else
                s.add(j + 1);
        }

        if(s.get(0) > s.get(1)) {
            System.out.println(s.get(1));
            System.out.println(s.get(0));
        }

        else{
            System.out.println(s.get(0));
            System.out.println(s.get(1));
        }
    }
}
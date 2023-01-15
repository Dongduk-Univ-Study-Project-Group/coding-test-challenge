import java.io.*;
import java.util.*;

public class Main{
    static long rslt = 0;
    static long start;
    static long end;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        start = sc.nextLong();
		end = sc.nextLong(); 
        sc.close();
        count(0);
        System.out.println(rslt);
    }
    public static void count(long n){
        if(n > end)
            return;
        if(end >= n && n >= start)
            rslt++;
        
        count(n * 10 + 4);
        count(n * 10 + 7);
    }
}
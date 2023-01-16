import java.io.*;
import java.util.*;

public class Main {

    public static int kingX = 0;
    public static int kingY = 0;
    public static int stoneX = 0;
    public static int stoneY = 0;
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        //킹,돌 좌표
        String king = sc.next();
        kingX = king.charAt(0)-'A'+1;
        kingY = king.charAt(1)-'0';
        String stone = sc.next();
        stoneX = stone.charAt(0)-'A'+1;
        stoneY = stone.charAt(1)-'0';
        int n = Integer.parseInt(sc.next());
        moveKing(n);
        moveStone(n);
    }
    public static void moveKing(int n) {
        for (int i = 0; i < n; i++) {
            String mv = sc.next();
            switch(mv) {
                case "R":
                    kingX--;
                    break;
                case "L":
                    kingX--;
                    break;
                case "B":
                    kingY--;
                    break;
                case "T":
                    kingY++;
                    break;
                case "RT":
                    kingX++;
                    kingY++;
                    break;
                case "LT":
                    kingX--;
                    kingY++;
                    break;
                case "RB":
                    kingX++;
                    kingY--;
                    break;
                case "LB":
                    kingX--;
                    kingY--;
                    break;
            }
            if(kingX < 1 && kingX > 8 && kingY < 1 && kingY > 8)
                continue;
        }
        String king = "";
        System.out.println((char)(kingX+'A'-1));
        System.out.println((char)(kingY+'0'));
        king = Character.toString((char)(kingX+'A'-1)) + Character.toString((char)(kingY+'0'));
        System.out.println(king);
    }

    public static void moveStone(int n) {
        for (int i = 0; i < n; i++) {
            String mv = sc.next();
            switch(mv) {
                case "R":
                    stoneX++;
                    break;
                case "L":
                    stoneX--;
                    break;
                case "B":
                    stoneY--;
                    break;
                case "T":
                    stoneY++;
                    break;
                case "RT":
                    stoneX++;
                    stoneY++;
                    break;
                case "LT":
                    stoneX--;
                    stoneY++;
                    break;
                case "RB":
                    stoneX++;
                    stoneY--;
                    break;
                case "LB":
                    stoneX--;
                    stoneY--;
                    break;
            }
            if(stoneX < 1 && stoneX > 8 && stoneY < 1 && stoneY > 8)
                continue;
        }
        String stone = "";
        stone = Character.toString((char)(stoneX+'A'-1)) + Character.toString((char)(stoneY+'0'));
        System.out.println(stone);
    }


}
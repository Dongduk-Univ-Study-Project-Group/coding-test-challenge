import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String n = sc.nextLine();
        int x = n.charAt(0) - 'a' + 1;
        int y = n.charAt(1) - '0';

        int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
        int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

        // 8가지 방향에 대하여 각 위치로 이동이 가능한지 확인
        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int X = x + dx[i];
            int Y = y + dy[i];
            // 해당 위치로 이동이 가능하다면 카운트 증가
            if (X >= 1 && X <= 8 && Y >= 1 && Y <= 8) {
                cnt += 1;
            }
        }

        System.out.println(cnt);
    }

}
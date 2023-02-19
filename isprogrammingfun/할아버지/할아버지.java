import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int[] score = new int[10001];

        while(true) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int first = Integer.MIN_VALUE;
            int second = Integer.MIN_VALUE;

            score = new int[10001];

            if(N == 0 && M == 0)
                break;

            //점수 계산
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    int idx = Integer.parseInt(st.nextToken());
                    score[idx]++;
                }
            }

            //1등의 점수 확인
            for (int i = 1; i < 10001; i++) {
                first = Math.max(first, score[i]);
            }

            //2등의 점수 확인
            for (int i = 1; i < 10001; i++) {
                if(score[i] != first){
                    second = Math.max(second, score[i]);
                }
            }

            //2등인 선수 확인
            for (int i = 1; i < 10001; i++) {
                if(score[i] == second)
                    sb.append(i+" ");
            }

            //
            sb.append("\\n");
        }
        System.out.println(sb.toString());
    }

}
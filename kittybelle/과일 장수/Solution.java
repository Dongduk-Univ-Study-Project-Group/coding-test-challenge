import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		int[] array = {1, 2, 3, 1, 2, 3, 1};
		int[] array1 = {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2};

		System.out.println(solution(3, 4, array));
		System.out.println(solution(4, 3, array1));
	}
	
	public static int solution(int k, int m, int[] score) {
		int answer = 0;

		// 배열 정렬
		Arrays.sort(score);

		// 최댓값이 오른쪽에 있으므로 i는 오른쪽에서부터 탐색 
		for(int i = score.length - 1; i >= 0; i--) {
			// 사과 개수 모자라서 박스 단위 못 만들때
			if (score.length - i < m) {
				continue;
			}

			// 한 박스가 완성되려면 m의 배수여야 함(사과 개수 = 박스 단위)
			if((score.length - i) % m == 0) {
				answer += score[i] * m;
			}
		}
		return answer;
    }
	
}

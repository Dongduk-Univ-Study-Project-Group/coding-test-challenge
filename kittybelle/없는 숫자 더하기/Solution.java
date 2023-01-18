public class Solution {

	public static void main(String[] args) {
		int[] array = {1, 2, 3, 4, 6, 7, 8, 0};
		int[] array1 = {5, 8, 4, 0, 6, 7, 9};

		System.out.println(solution(array));
		System.out.println(solution(array1));
	}

	public static int solution(int[] numbers) {
        int answer = -1;
        
        // 0부터 9까지의 합
        int totalSum = 45;
        
        int numberSum = 0;
        
        for(int i = 0; i < numbers.length; i++) {
        	numberSum += numbers[i];
        }
        
        // 0부터 9까지의 합에서 numbers 원소의 합을 빼면 없는 숫자의 합
        answer = totalSum - numberSum;
        
        return answer;
    }
}

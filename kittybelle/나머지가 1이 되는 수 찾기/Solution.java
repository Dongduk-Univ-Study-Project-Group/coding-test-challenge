public class Solution {
	
	public static void main(String[] args) {
		System.out.println(solution(10));
		System.out.println(solution(12));
	}
	
	public static int solution(int n) {
        int answer = 0;
        
        for(int i = 2; i < n; i++) {
            if(n % i == 1) {
                answer = i;
                return answer;
            }
        }
        answer = -1;
        return answer;
    }
}

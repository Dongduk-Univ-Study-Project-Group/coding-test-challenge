public class Solution {
	
	public static void main(String[] args) {
		System.out.println(solution(13, 17));
		System.out.println(solution(24, 27));
	}
	
	public static int solution(int left, int right) {
        int answer = 0;
        
        int count = 0;

        for(int i = left; i <= right; i++) {
        	
        	for(int j = 1; j <= i; j++) {
        		if(i % j == 0) {
        			count++;
        		}
        	}

        	if((count % 2) == 0) {
        		answer += i;
        	} else {
        		answer -= i;
        	}
        	count = 0;
        }
        return answer;
	}

}

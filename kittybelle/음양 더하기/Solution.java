public class Solution {
	
	public static void main(String[] args) {
		int[] array = {4, 7, 12};
		int[] array1 = {1, 2, 3};
		
		boolean[] s = {true, false, true};
		boolean[] s1 = {false, false, true};

		System.out.println(solution(array, s));
		System.out.println(solution(array1, s1));
	}
	
	public static int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        for(int i = 0; i < absolutes.length; i++) {
        	if(signs[i]) {
        		answer += absolutes[i];
        	} else {
        		answer -= absolutes[i];
        	}
        }
        
        return answer;
    }
	
}

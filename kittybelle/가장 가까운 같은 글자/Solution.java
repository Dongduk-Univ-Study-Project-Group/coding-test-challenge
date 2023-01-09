public class Solution {

	public static void main(String[] args) {
		solution("banana");
		solution("foobar");
	}
	
	public static int[] solution(String s) {
		// 문자열의 크기에 맞게 배열 선언
        int[] answer = new int[s.length()];
        
        // 맨 처음 문자는 무조건 -1
        answer[0] = -1;
        		   
        // banana 체크중 a는 나보다 두 칸 앞 = index 차이 체크 
        for(int i = 1; i < s.length(); i++) {
        	int count = s.lastIndexOf(s.substring(i, i+1), i-1);
        	
        	if(count != -1) { // 최초 발견
        		answer[i] = i - count;
        	} else {
        		answer[i] = count;
        	}
        }
        return answer;
    }
	
}

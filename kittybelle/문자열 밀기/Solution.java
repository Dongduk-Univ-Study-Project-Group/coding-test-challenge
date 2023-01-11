public class Solution {

	public static void main(String[] args) {
		System.out.println(solution("hello", "ohell"));
		System.out.println(solution("apple", "elppa"));
		System.out.println(solution("atat", "tata"));
		System.out.println(solution("abc", "abc"));
	}

	public static int solution(String A, String B) {
        int answer = 0;
        
        for(int i = 0; i < A.length(); i++) {
        	// B가 된다면 return
            if(A.equals(B)) {
                return answer;
            }
            
            // 맨 앞으로 밀 맨 오른쪽 글자 저장(hello -> o)
            String sLast = A.substring(A.length() - 1);
            
            // 맨 오른쪽 글자를 뺀 나머지 문자열(hello -> hell)
            String sCut = A.substring(0, A.length() - 1);
            
            // 합치기
            String sResult = sLast + sCut; 
            
            // 옆으로 밀린 새로운 문자열 A에 다시 대입
            A = sResult;
            answer++;

        }
        // 문자열 끝끼지 다 돌았는데도 B가 될 수 없다면 -1
        answer = -1;
        
        return answer;
    }
}

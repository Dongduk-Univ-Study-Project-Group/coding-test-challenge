public class Solution {

	public static void main(String[] args) {
		System.out.println(solution("3 + 4"));
	}
	
	public static int solution(String my_string) {
        int answer = 0;
        
	 // 공백을 기준으로 자르기
        String[] op = my_string.split(" ");

	 // 첫 번째 수 저장
        answer = Integer.parseInt(op[0]);

        for(int i = 1; i < op.length; i++) {
		// 연산자 종류에 따라 op[i+1]은 이미 더해져 연산 완료했으므로 continue
        	if(i % 2 == 0) {
        		continue;
        	}
        	if(op[i].equals("+")) {
        		answer += Integer.parseInt(op[i + 1]);
        	} else {
        		answer -= Integer.parseInt(op[i + 1]);
        	}

        }
        return answer;
    }

}

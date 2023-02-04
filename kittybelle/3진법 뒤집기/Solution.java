import java.util.ArrayList;

public class Solution {

	public static void main(String[] args) {
		System.out.println(solution(45));
		System.out.println(solution(125));
	}
	
	public static int solution(int n) {
        int answer = 0;
        
        ArrayList<Integer> trinary = new ArrayList<>();
        
        while(n > 0) {
			trinary.add(n % 3);
			n /= 3;
		}
        
        int j = 0;
		for(int i = trinary.size()-1; i >= 0; i--) {
			answer += (trinary.get(i)) * Math.pow(3, j);
			j++;
		}
        
        return answer;
    }
	
}

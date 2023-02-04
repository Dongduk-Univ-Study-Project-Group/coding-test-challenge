public class Solution {
	
	public static void main(String[] args) {
		System.out.println(solution(5, 3, 2));
		System.out.println(solution(10, 3, 2));
	}

	public static int solution(int number, int limit, int power) {
        int answer = 0;

        for(int i = 1; i <= number; i++) {
        	answer += getCount(i, limit, power);
        }
        
        return answer;
	}

	public static int getCount(int number, int limit, int power) {
		int count = 0;
		
		for(int i = 1; i * i <= number; i++) {  // 1~n까지가 아닌, n의 제곱수까지 반복
			if((number % i) == 0) {	// 나누어 떨어짐
				if((i*i) == number) { // 나누어 떨어지긴 하는데 제곱근이라 겹치는 경우 ex: 2*2 = 4
					count++;
				} else {  // 제곱근이 아닌 약수는 짝이 있음
					count += 2; 
				}
			}
			if(count > limit) {
				return power;
			}
		}
		return count;
	}

}

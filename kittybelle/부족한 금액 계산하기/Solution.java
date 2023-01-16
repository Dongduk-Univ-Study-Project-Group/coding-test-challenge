public class Solution {
	public static void main(String[] args) {
		System.out.println(solution(3, 20, 4));
	}
	
    public static long solution(int price, int money, int count) {
        long answer = 0;
        long totalPrice = 0;
        
        for(int i = 1; i <= count; i++) {
        	totalPrice += price * i;
        }
        
        if(totalPrice > money) { // 돈이 부족한 경우
        	answer = totalPrice - money;
        } else { // 돈이 남는 경우
        	answer = 0;
        }
        return answer;
    }
}

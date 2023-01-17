public class Solution {
	public static void main(String[] args) {
		System.out.println(solution("one4seveneight"));
		System.out.println(solution("23four5six7"));
		System.out.println(solution("2three45sixseven"));
		System.out.println(solution("123"));
	}
	
	public static int solution(String s) {
        String[] sList = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] sNumber = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        
        for (int i = 0; i < 10; i++) {
            s = s.replace(sList[i], sNumber[i]);
        }
        return Integer.parseInt(s);
    }
}

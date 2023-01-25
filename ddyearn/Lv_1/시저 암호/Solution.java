class Solution {
    public String solution(String s, int n) {
        String answer = "";
        String[] str = s.split("");
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) >= 65 & s.charAt(i) <= 90) {  //대문자
                if(s.charAt(i) + n > 90) {
                    answer += (char)(s.charAt(i) + n - 26);
                } else {
                    answer += (char)(s.charAt(i) + n);
                }
            } else if(s.charAt(i) >= 97 & s.charAt(i) <= 122) {  //소문자
                if(s.charAt(i) + n > 122) {
                    answer += (char)(s.charAt(i) + n - 26);
                } else {
                    answer += (char)(s.charAt(i) + n);
                }
            } else {
                answer += (char) s.charAt(i);
            }

        }
        return answer;
    }
}
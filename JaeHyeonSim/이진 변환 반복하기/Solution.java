class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        answer = new int[2];
        answer[1] = 0;
        for (answer[0] = 0; s.length() > 1; answer[0]++) {
            int leng = s.length();
            s = s.replace("0", "");             // 0 제거
            answer[1] += leng - s.length();
            
            s = Integer.toString(s.length());
            s = toBinary(s);                    // 이진 변환
        }
        
        return answer;
    }
    
    public String toBinary(String s) {
        int n = Integer.parseInt(s);
        StringBuilder b = new StringBuilder();
        
        while (n > 0) {
            b.append(Integer.toString(n % 2));
            n /= 2;
        }
        
        return b.reverse().toString();
    }
    
}
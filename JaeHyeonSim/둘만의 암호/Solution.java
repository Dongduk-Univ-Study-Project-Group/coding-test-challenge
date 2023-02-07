class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            for (int cnt = 0; cnt < index; cnt++) {
                ch++;
                if (ch > 'z') {     // z를 넘어가면 a로
                    ch -= 'z' - 'a' + 1;
                }
                if (skip.indexOf(ch) != -1) {
                    cnt--;  // skip에 포함되면 index로 치지 않음
                }
            }
            
            answer += ch;
        }
        
        return answer;
    }
}
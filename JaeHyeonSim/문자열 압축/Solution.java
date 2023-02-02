class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int min = s.length();
        for (int unit = 1; unit <= s.length() / 2; unit++) {
            int i;
            int leng = s.length();
            int pressed = 1;        // 연속 압축 횟수
            for (i = 0; i + unit * 2 <= s.length(); i += unit) {
                String next = s.substring(i + unit, i + unit * 2);
                if (next.equals(s.substring(i, i + unit))) {
                    pressed++;
                    leng -= unit;   // 압축된 길이를 뺀다
                } else {
                    if (pressed > 1) {
                        leng += Integer.toString(pressed).length();    // 압축 숫자(자릿수 길이) 추가
                    }
                    pressed = 1;
                }
            }
            if (pressed > 1) {
                leng += Integer.toString(pressed).length();
            }
            if (leng < min) {
                min = leng;
            }
        }
        answer = min;
        
        return answer;
    }
}
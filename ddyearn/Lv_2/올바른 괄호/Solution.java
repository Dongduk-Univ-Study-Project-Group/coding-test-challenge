class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int openCount = 1;
        char o = '(';
        char c = ')';

        if(s.charAt(0) == c) return false;

        for(int i = 1; i<s.length(); i++) {
            if(s.charAt(i) == o) {
                openCount++;
            } else {
                openCount--;
            }
            if(openCount<0) return false;
        }
        if(openCount!=0) return false;
        return answer;
    }
}
class Solution {
    public int[] solution(String s) {
        String temp  = "";
        int[] answers = new int[s.length()];
        String[] strings = s.split("");
        
        for (int i = 0; i < s.length(); i++) {
            if (!temp.contains(strings[i])) {
                answers[i] = -1;
            } else {
                answers[i] = i - temp.lastIndexOf(strings[i]);
            }
            
            temp += strings[i];
        }
        
        return answers;
    }
}
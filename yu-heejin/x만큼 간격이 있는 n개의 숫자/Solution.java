class Solution {
    public long[] solution(int x, int n) {
        long[] answers = new long[n];
        long element = x;
        
        for (int i = 0; i < n; i++) {
            answers[i] = element;
            element += x;
        }
        
        return answers;
    }
}

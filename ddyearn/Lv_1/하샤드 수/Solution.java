class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int n = 0;
        int xx = x;
        while(xx >= 1) {
            n += xx % 10;
            xx /= 10;
        }
        if(x % n != 0) {
            answer = false;
        }
        return answer;
    }
}
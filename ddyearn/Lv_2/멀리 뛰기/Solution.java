class Solution {
    public long solution(int n) {
        long answer = 0;
        int[] memo = new int[20001];
        memo[1] = 1;
        memo[2] = 2;
        for(int i = 3; i<2001; i++) {
            memo[i] = (memo[i-2] + memo[i-1]) % 1234567;
        }
        return memo[n];
    }
}
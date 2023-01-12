class Solution {
    public int solution(int n) {
        int gcd = getGcd(6, n);
        int answer = n / gcd;
        return answer;
    }

    public static int getGcd(int a, int b) {
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
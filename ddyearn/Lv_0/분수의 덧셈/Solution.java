class Solution {
    public int[] solution(int denum1, int num1, int denum2, int num2) {
        int den = denum1 * num2 + denum2 * num1;
        int n = num1 * num2;
        int gdc = 1;
        for (int i = 1; i <= den; i++) {
            if(den % i == 0 && n % i == 0) {
                gdc = i;
            }
        }
        int[] answer = {den / gdc, n / gdc};
        return answer;
    }
}

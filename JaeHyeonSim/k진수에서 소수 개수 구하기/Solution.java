class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        
        int kLeng = 0;
        int[] kNum = new int[n];
        for (kLeng = 0; n / k > 0; kLeng++) {   // k진수로 변환
            kNum[kLeng] = n % k;
            n /= k;
        }
        kNum[kLeng++] = n;
        
        long check = 0;
        for (int i = kLeng - 1; i >= 0; i--) {
            check += kNum[i];
            
            if (i == 0 || kNum[i - 1] == 0) {   // 다음에 오는 수가 0이면 소수 판별
                if (isPrime(check)) {
                    answer++;
                }
                check = 0;
                continue;
            }
            check *= 10;
        }
        
        return answer;
    }
    
    public boolean isPrime(long n) {
        if (n == 0 || n == 1) {
            return false;
        }
        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
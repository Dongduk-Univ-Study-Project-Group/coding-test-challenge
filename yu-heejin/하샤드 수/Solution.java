class Solution {
    public boolean solution(int x) {
        int number = 0;
        int temp = x;
        
        while (temp > 0) {
            number += temp % 10;
            temp /= 10;
        }
        
        return x % number == 0;
    }
}
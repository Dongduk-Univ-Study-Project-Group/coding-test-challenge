class Solution {
    public int solution(int price) {
        int answer = 0;
        int drate = 0;
        if(price >= 500000){
            drate = 20;
        } else if(price >= 300000){
            drate = 10;
        } else if(price >= 100000){
            drate = 5;
        }
        answer = price * (100 - drate) / 100;
        return answer;
    }
}
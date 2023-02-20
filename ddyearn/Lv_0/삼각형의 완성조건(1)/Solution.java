class Solution {
    public int solution(int[] sides) {
        int answer = 1;
        int sum = 0;
        int max = 0;
        for(int side: sides) {
            sum += side;
            if(max<side) {
                max = side;
            }
        }
        if(max >= (sum - max)) {
            answer = 2;
        }
        return answer;
    }
}
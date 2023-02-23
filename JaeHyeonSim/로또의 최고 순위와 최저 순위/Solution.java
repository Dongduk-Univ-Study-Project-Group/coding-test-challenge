class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        
        int win = 0;
        int scribbled = 0;
        for (int i = 0; i < lottos.length; i++) {
            if (lottos[i] == 0) {
                scribbled++;
                continue;
            }
            for (int j = 0; j < win_nums.length; j++) {
                if (lottos[i] == win_nums[j]) {
                    win++;
                    break;
                }
            }
        }
        
        answer = new int[2];
        answer[0] = 7 - (win + scribbled);
        answer[1] = 7 - win;
        if (answer[0] >= 6) {
            answer[0] = 6;
        }
        if (answer[1] >= 6) {
            answer[1] = 6;
        }
        
        return answer;
    }
}
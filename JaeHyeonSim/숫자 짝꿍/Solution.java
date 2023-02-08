import java.util.Arrays;

class Solution {
    public String solution(String X, String Y) {
        String answer = "";
        StringBuilder answerStr = new StringBuilder();
        
        int[] xNums = new int[10];
        int[] yNums = new int[10];
        // 숫자별 개수 count
        countNum(xNums, X);
        countNum(yNums, Y);
        
        for (int num = 9; num >= 0; num--) {
            int pairCnt = xNums[num];
            if (yNums[num] < pairCnt) {
                pairCnt = yNums[num];
            }
            for (int i = 0; i < pairCnt; i++) {
                answerStr.append(Integer.toString(num));
            }
        }
        
        answer = answerStr.toString();
        // 짝꿍이 존재하지 않거나 0으로만 구성된 경우
        if (answer.length() == 0) {
            answer = "-1";
        } else if (answer.split("0").length == 0) {
            answer = "0";
        }
        
        return answer;
    }
    
    public void countNum(int[] nums, String s) {
        for (int i = 0; i <= 9; i++) {
            String num = Integer.toString(i);
            nums[i] = s.length() - s.replace(num, "").length();
        }
    }
}
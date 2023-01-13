import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        
        String[][] type = { {"R", "T"}, {"C", "F"}, {"J", "M"}, {"A", "N"} };
        int[] points = { 0, 3, 2, 1, 0, 1, 2, 3 };
        
        HashMap<String, Integer> sum = new HashMap<String, Integer>();
        for (int i = 0; i < type.length; i++) { // 점수 저장
            sum.put(type[i][0], 0);
            sum.put(type[i][1], 0);
        }
        
        for (int i = 0; i < survey.length; i++) {
            if (choices[i] < 4) {           // 비동의
                int point = sum.get(survey[i].substring(0, 1)) + points[choices[i]];
                sum.replace(survey[i].substring(0, 1), point); 
            } else if (choices[i] > 4) {    // 동의
                int point = sum.get(survey[i].substring(1)) + points[choices[i]];
                sum.replace(survey[i].substring(1), point);
            }
        }
        
        String[] result = { "R", "C", "J", "A" };
        for (int i = 0; i < type.length; i++) {
            if (sum.get(type[i][1]) > sum.get(type[i][0])) {
                result[i] = type[i][1];
            }
        }
        answer = result[0] + result[1] + result[2] + result[3];
        
        return answer;
    }
}
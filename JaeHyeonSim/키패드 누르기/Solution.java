class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        
        int left = 10;
        int right = 12;
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            if (num == 0) {             // * 0 # -> 10 11 12 로 계산
                num = 11;
            }
            
            if (num % 3 == 1) {          // 1, 4, 7
                left = num;
                answer += "L";
            } else if (num % 3 == 0) {   // 3, 6, 9
                right = num;
                answer += "R";
            } else {                     // 2, 5, 8, 0(11)
                int leftDist = getDistance(num, left);
                int rightDist = getDistance(num, right);
                
                if (leftDist < rightDist) {
                    left = num;
                    answer += "L";
                } else if (leftDist > rightDist) {
                    right = num;
                    answer += "R";
                } else {    // 거리가 같을 경우
                    if (hand.equals("left")) {
                        left = num;
                        answer += "L";
                    } else {
                        right = num;
                        answer += "R";
                    }
                    
                }
            }
        }
        
        return answer;
    }
    
    public int getDistance(int num, int now) {
        int dist = Math.abs(num - now);
        int layer = 0;
        while (dist > 1) {  // 층이 다를 경우
            if (num > now) {
                num -= 3;
            } else {
                num += 3;
            }
            dist = Math.abs(num - now);
            layer++;
        }
        return layer + dist;
    }
}
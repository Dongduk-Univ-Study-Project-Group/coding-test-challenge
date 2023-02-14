class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        int cnt = 0;
        int[] points = new int[4];
        
        for (int i = 0; i < dartResult.length(); i++) {
            String s = dartResult.substring(i, i + 1);
            switch (s) {
                case "S":
                    break;
                case "D":
                    points[cnt] = (int)Math.pow(points[cnt], 2);
                    break;
                case "T":
                    points[cnt] = (int)Math.pow(points[cnt], 3);
                    break;
                case "*":
                    points[cnt] *= 2;
                    if (cnt > 1) {
                        points[cnt - 1] *= 2;
                    }
                    break;
                case "#":
                    points[cnt] *= -1;
                    break;
                default:
                    if (i > 0 && dartResult.charAt(i - 1) == '1') {     // 앞자리가 '1'이면
                        points[cnt] = 10;
                    } else {
                        cnt++;
                        points[cnt] = Integer.parseInt(s);
                    }
                    break;
            }
        }
        
        for (int i = 1; i < points.length; i++) {
            answer += points[i];
        }
        
        return answer;
    }
}
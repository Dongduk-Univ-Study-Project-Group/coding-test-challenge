class Solution {
    public String solution(int[] food) {
        String answer = "";
        String half = "";
        for(int i = 1; i<food.length; i++) {
            half += String.valueOf(i).repeat(food[i]/2);
        }
        StringBuffer sb = new StringBuffer(half);
        answer = half + "0" + sb.reverse().toString();
        return answer;
    }
}
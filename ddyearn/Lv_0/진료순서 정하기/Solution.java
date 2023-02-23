import java.util.Arrays;
import java.util.Collections;
class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        Integer[] cArray = Arrays.stream(emergency).boxed().toArray(Integer[]::new); // int[]배열을 Integer[]배열로 변환
        Arrays.sort(cArray, Collections.reverseOrder()); // 내림차순 정렬

        for(int i=0; i<emergency.length; i++) {
            answer[i] = Arrays.asList(cArray).indexOf(emergency[i]) + 1; // indexOf는 boxer클래스만 사용 가능
        }
        return answer;
    }
}
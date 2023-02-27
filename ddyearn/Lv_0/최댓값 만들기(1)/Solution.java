import java.util.Arrays;
import java.util.Collections;
class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Integer b[] = Arrays.stream(numbers).boxed().toArray(Integer[]::new);
        Arrays.sort(b,Collections.reverseOrder());
        answer = b[0] * b[1];
        return answer;
    }
}

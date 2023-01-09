import java.util.*;

class Solution {
    public int solution(int[] array) {
        int mid = array.length / 2;
        Arrays.sort(array);
        int answer = array[mid];
        return answer;
    }
}

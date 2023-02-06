import java.lang.Math;
import java.util.*;
class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;

        Arrays.sort(works);
        for(int i = 0; i<n; i++) {
            int index = works.length - 1;
            works[index]--;
            if(works[index] < works[index-1]) {
                Arrays.sort(works);
            }
        }
        for(int work : works) {
            if(work < 0) return 0;
            answer += Math.pow(work, 2);
        }
        return answer;
    }
}
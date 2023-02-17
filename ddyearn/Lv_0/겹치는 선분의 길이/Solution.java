import java.util.*;
class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int[] blocks = new int[200];
        for(int i=0; i<3; i++) {
            for(int j=lines[i][0]; j<lines[i][1]; j++) {
                blocks[j+100]++;
            }
        }
        for(int block : blocks) {
            if(block>1) answer++;
        }

        return answer;
    }
}
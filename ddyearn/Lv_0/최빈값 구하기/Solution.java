import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] array) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int answer = 0;
		int count = 0;
		for (int i = 0; i < array.length; i++) {
			int t = map.getOrDefault(array[i], 0) + 1;
			map.put(array[i], t);
			if(count < t) {answer = array[i]; count = t;}
		}
		for(Integer i: map.keySet()) {
			if(map.get(i)==count && i!=answer) return -1;
		}
        return answer;
    }
}

import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize == 0)
            return cities.length * 5;

        int answer = 0;

        List<String> cache = new ArrayList<>();

        for(int i = 0; i<cities.length; i++) {
            String s = cities[i].toUpperCase();
            if(cache.remove(s)) {
                answer += 1;
            } else {
                answer += 5;
                if(cache.size() >= cacheSize)
                    cache.remove(0);
            }
            cache.add(s);
        }

        return answer;
    }
}
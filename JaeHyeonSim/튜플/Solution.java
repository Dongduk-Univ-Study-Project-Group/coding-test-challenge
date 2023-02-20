import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        s = s.replace("{{", "");
        s = s.replace("}}", "");
        String[] sSet = s.split("\\},\\{");
        int leng = sSet.length;
        
        HashMap<String, Integer> sCnt = new HashMap<>();    // <숫자, 개수>
        for (int i = 0; i < leng; i++) {
            String[] splited = sSet[i].split(",");
            for (int j = 0; j < splited.length; j++)  {     // 각 숫자별 개수를 구함
                sCnt.put(splited[j], sCnt.getOrDefault(splited[j], 0) + 1);
            }
        }
        
        answer = new int[leng];
        ArrayList<String> sArr = new ArrayList<>(sCnt.keySet());
        for (int i = 0; i < leng; i++) {
            int num = Integer.parseInt(sArr.get(i));
            int counted = sCnt.get(sArr.get(i));
            answer[leng - counted] = num;       // 개수가 많을수록 index는 크다
        }
        
        return answer;
    }
}
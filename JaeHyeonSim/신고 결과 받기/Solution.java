import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        
        HashMap<String, ArrayList<String>> rMap = new HashMap<>();  // <신고당한id, 신고자 목록>
        for (int i = 0; i < id_list.length; i++) {
            rMap.put(id_list[i], new ArrayList<String>());
        }
        
        for (int i = 0; i < report.length; i++) {
            String reporter = report[i].split(" ")[0];
            String reported = report[i].split(" ")[1];
            
            ArrayList<String> rList = rMap.get(reported);
            if (!rList.contains(reporter)) {    // 신고자 목록에 없을 경우 추가
                rList.add(reporter);
                rMap.replace(reported, rList);
            }
        }
        
        answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            ArrayList<String> rList = rMap.get(id_list[i]);
            if (rList.size() >= k) {    // 신고자가 k명 이상일 경우 처리 결과 전송
                for (String reporter : rList) {
                    answer[Arrays.asList(id_list).indexOf(reporter)]++;
                }
            }
        }
        
        return answer;
    }
}
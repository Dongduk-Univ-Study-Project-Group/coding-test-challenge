import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] fees, String[] records) {
        int[] answer = {};
        
        int dayMin = 24 * 60 - 1;
        
        HashMap<String, Integer> inTime = new HashMap<>();      // 입차 시각
        HashMap<String, Integer> totalMin = new HashMap<>();    // 누적 주차 시간
        
        for (int i = 0; i < records.length; i++) {
            String[] rec = records[i].split(" ");
            int minute = Integer.parseInt(rec[0].split(":")[0]) * 60
                        + Integer.parseInt(rec[0].split(":")[1]);
            
            if (rec[2].equals("IN")) {              // 입차
                inTime.put(rec[1], minute);
                totalMin.put(rec[1], totalMin.getOrDefault(rec[1], 0));
            } else if (rec[2].equals("OUT")) {      // 출차
                int countedMin = totalMin.get(rec[1]) + minute - inTime.get(rec[1]);
                inTime.remove(rec[1]);
                totalMin.replace(rec[1], countedMin);
            }
        }
        for (String key : inTime.keySet()) {        // 출차 기록이 없는 경우
            int countedMin = totalMin.get(key) + dayMin - inTime.get(key);
            if (countedMin > fees[0]) {
                totalMin.replace(key, countedMin);
            }
        }
        
        ArrayList<String> cars = new ArrayList<>(totalMin.keySet());
        Collections.sort(cars);                   // 차량 번호 순 정렬
        answer = new int[cars.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = fees[1];                    // 기본 요금
            if (totalMin.get(cars.get(i)) > fees[0]) {
                answer[i] += Math.ceil((totalMin.get(cars.get(i)) - fees[0]) / (double)fees[2]) * fees[3];
            }
        }
        
        return answer;
    }
}
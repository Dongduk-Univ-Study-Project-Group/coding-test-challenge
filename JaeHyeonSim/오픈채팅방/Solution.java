import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        
        ArrayList<String> message = new ArrayList<>();
        HashMap<String, String> nickname = new HashMap<>();
        
        for (int i = 0; i < record.length; i++) {
            String[] rec = record[i].split(" ");
            if (rec[0].equals("Enter")) {       // 입장 시 메시지, 닉네임 추가
                message.add(record[i]);
                nickname.put(rec[1], rec[2]);
            } else if (rec[0].equals("Leave")) {    // 퇴장 시 메시지 추가
                message.add(record[i]);
            } else if (rec[0].equals("Change")) {   // 닉네임 변경
                nickname.replace(rec[1], rec[2]);
            }
        }
        
        answer = new String[message.size()];
        for (int i = 0; i < answer.length; i++) {
            String[] msg = message.get(i).split(" ");
            if (msg[0].equals("Enter")) {
                answer[i] = nickname.get(msg[1]) + "님이 들어왔습니다.";
            } else {
                answer[i] = nickname.get(msg[1]) + "님이 나갔습니다.";
            }
        }
        
        return answer;
    }
}
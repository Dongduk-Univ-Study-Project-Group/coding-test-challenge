class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        // 1
        answer = new_id.toLowerCase();
        
        // 2
        answer = answer.replaceAll("[^a-z0-9-_.]", "");
        
        // 3
        StringBuffer removed = new StringBuffer(answer);
        for (int i = 1; i < removed.length(); i++) {
            if (removed.charAt(i) == '.' && removed.charAt(i) == removed.charAt(i - 1)) {
                removed.deleteCharAt(i--);
            }
        }
        
        // 4
        if (removed.length() > 0 && removed.indexOf(".") == 0) {
            removed.deleteCharAt(0);
        }
        if (removed.length() > 0 && removed.lastIndexOf(".") == removed.length() - 1) {
            removed.deleteCharAt(removed.length() - 1);
        }
        answer = removed.toString();
        
        // 5
        if (answer.length() == 0) {
            answer = "a";
        }
        
        // 6
        if (answer.length() >= 16) {
            answer = answer.substring(0, 15);
            if (answer.charAt(14) == '.') {
                answer = answer.substring(0, 14);
            }
        }
        
        // 7
        while (answer.length() < 3) {
            answer += answer.substring(answer.length() - 1);
        }
        
        return answer;
    }
}
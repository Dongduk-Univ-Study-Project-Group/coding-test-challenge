import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        String[] t = today.split("\\.");
        Calendar tDate = Calendar.getInstance();
        tDate.setTimeInMillis(0);
        tDate.set(Integer.parseInt(t[0]), Integer.parseInt(t[1]) - 1, Integer.parseInt(t[2]));
        
        Map<String, Integer> termMap = new HashMap<String, Integer>();
        for (int i = 0; i < terms.length; i++) {
            String[] s = terms[i].split(" ");
            termMap.put(s[0], Integer.parseInt(s[1]));
        }
        
        int count = 0;
        for (int i = 0; i < privacies.length; i++) {
            String[] privacie =  privacies[i].split(" ");
            
            int year = Integer.parseInt(privacie[0].split("\\.")[0]);
            int month = Integer.parseInt(privacie[0].split("\\.")[1]);
            int day = Integer.parseInt(privacie[0].split("\\.")[2]);
            
            int term = termMap.get(privacie[1]);
            if (term >= 12) {
                year += term / 12;
                term %= 12;
            }
            month += term;
            
            Calendar date = Calendar.getInstance();
            date.setTimeInMillis(0);
            date.set(year, month - 1, day);
            
            if (date.equals(tDate) || date.before(tDate)) {
            	result.add(i);
            }
        }
        
        answer = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
        	answer[i] = result.get(i) + 1;
        }
        
        return answer;
    }
}
class Solution {
    public int[] solution(String[][] places) {
        int[] answer = {};
        
        answer = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            answer[i] = isDistancing(places[i], reverseArr(places[i]));
        }
        
        return answer;
    }
    
    public int isDistancing(String[] place, String[] reverse) {
        for (int i = 0; i < place.length; i++) {
            if (place[i].contains("PP") || place[i].contains("POP")) { // 가로 체크
                return 0;
            }
            if (reverse[i].contains("PP") || reverse[i].contains("POP") ) { // 세로 체크
                return 0;
            }
        }
        
        for (int i = 0; i < place.length - 1; i++) {
            for (int j = 0; j < place.length - 1; j++) {
                if ((place[i].charAt(j) == 'P' && place[i + 1].charAt(j + 1) == 'P') && // 대각선 체크
                    (place[i].charAt(j + 1) == 'O' || place[i + 1].charAt(j) == 'O')) {
                    return 0;
                }
            }
        }
        
    
        return 1;
    }
    
    public String[] reverseArr(String[] arr) {
        String[] reverse = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            String rvs = "";
            for (int j = 0; j < arr.length; j++) {
                rvs += arr[j].charAt(i);
            }
            reverse[i] = rvs;
        }
        return reverse;
    }
    
}
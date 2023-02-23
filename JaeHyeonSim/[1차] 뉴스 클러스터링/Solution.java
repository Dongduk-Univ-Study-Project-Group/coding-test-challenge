import java.util.ArrayList;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        
        ArrayList<String> s1Arr = getArr(str1);
        ArrayList<String> s2Arr = getArr(str2);
        int leng1 = s1Arr.size();
        int leng2 = s2Arr.size();
        
        int intersection = 0;
        for (int i = 0; i < s1Arr.size(); i++) {
            if (s2Arr.contains(s1Arr.get(i))) {
                intersection++;
                s2Arr.remove(s1Arr.get(i));
            }
        }
        int union = leng1 + leng2 - intersection;
        
        if (leng1 == 0 && leng2 == 0) {
            answer = 65536;
        } else {
            answer = (int)((double)intersection / union * 65536);
        }
        
        return answer;
    }
    
    public ArrayList<String> getArr(String s) {
        s = s.toUpperCase();
        ArrayList<String> sArr = new ArrayList<>();
        for (int i = 0; i < s.length() - 1; i++) {
            // 2자씩 끊어서 문자만으로 이루어지면 arr에 삽입
            String str = s.substring(i, i + 2);
            if (str.length() == str.replaceAll("[^A-Z]", "").length()) {
                sArr.add(str);
            }
        }
        return sArr;
    }
    
}
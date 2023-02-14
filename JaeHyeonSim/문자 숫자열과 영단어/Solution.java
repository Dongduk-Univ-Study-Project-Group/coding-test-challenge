class Solution {
    public int solution(String s) {
        int answer = 0;
        
        String changed = s;
        String[] numEng = { "zero", "one", "two", "three", "four",
                           "five", "six", "seven", "eight", "nine"  };
        for (int i = 0; i < numEng.length; i++) {        // 0~9 문자->숫자
            changed = changed.replace(numEng[i], Integer.toString(i));
        }
        answer = Integer.parseInt(changed);
        
        return answer;
    }
}
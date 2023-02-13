class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] strs = {"aya", "ye", "woo", "ma"};

        for(String bab : babbling){
            for(String str : strs) {
                bab = bab.replaceFirst(str, " ");
            }
            if(bab.replaceAll(" ","").equals("")) answer++;
        }

        return answer;
    }
}
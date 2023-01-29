class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i<n; i++) {
            String tmp = "";
            for(int j=0; j<n; j++) {
                if(arr1[i] % 2 == 0 & arr2[i] % 2 == 0) {
                    tmp += " ";
                } else {
                    tmp += "#";
                }
                arr1[i] /= 2;
                arr2[i] /= 2;
            }
            StringBuffer sb = new StringBuffer(tmp);
            answer[i] = sb.reverse().toString();
        }
        return answer;
    }
}
class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i = 0; i < n; i++) {
            StringBuilder result = new StringBuilder();
            // 10 -> 2진수 변환
            int[] bin1 = decimalToBinary(arr1[i], n);
            int[] bin2 = decimalToBinary(arr2[i], n);
            // 둘 다 0이면 공백, 아니면 #
            for (int j = 0; j < n; j++) {
                if (bin1[j] == 0 && bin2[j] == 0) {
                    result.append(" ");
                } else {
                    result.append("#");
                }
            }
            answer[i] = result.toString();
        }
        
        return answer;
    }
    
    public int[] decimalToBinary(int decimal, int n) {
        int[] binary = new int[n];
        for (int i = n - 1; decimal > 0; i--) {
            binary[i] = decimal % 2;
            decimal /= 2;
        }
        return binary;
    }
}
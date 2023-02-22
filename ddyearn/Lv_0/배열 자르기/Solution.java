import java.util.Arrays;
class Solution {
    public int[] solution(int[] numbers, int num1, int num2) {
        /*
        반복문 사용
        int[] answer = new int[num2 - num1 + 1];
        int index = 0;
        for (int i=num1; i<num2+1; i++) {
            answer[index++] = numbers[i];
        }
        return answer;
        */

        // Arrays.copyOfRange() 사용
        int[] answer = Arrays.copyOfRange(numbers, num1, num2+1);
        return answer;
    }
}
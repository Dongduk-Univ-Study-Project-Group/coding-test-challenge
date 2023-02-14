import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public long solution(String expression) {
        long answer = 0;
        
        ArrayList<String> operators = new ArrayList<>(Arrays.asList("+", "-", "*"));
        for (int i = 0; i < operators.size(); i++) {
            String op = operators.get(i);
            if (expression.indexOf(op) == -1) {
                operators.remove(op);
            }
        }
        for (String op : operators) {
            System.out.print(op + " ");
        }
        System.out.println();
        
        int n = operators.size();
        pick(operators, new int[n], n);
        
        
        
        return answer;
    }
    
    public String pick(ArrayList<String> items, int[] bucket, int k){
        if (k == 0) {
            String result = "";
            for (int i = 0; i < bucket.length; i++) {
                result += items.get(bucket[i]);
            }
            System.out.println(result);
            return result;
        }
        
        int lastIndex = bucket.length - 1 - k;
        int smallest = 0;   // 순열
        
        for (int i = smallest; i < items.size(); i++) {
            boolean chosen = false;
            for (int j = 0; j <= lastIndex; j++) {
                if (i == bucket[j]) {
                    chosen = true;
                    break;
                }
            }
            if (chosen) {
                continue;
            }
            
            bucket[lastIndex + 1] = i;
            pick(items, bucket, k - 1);
        }
        
        return "";
    }
    
}
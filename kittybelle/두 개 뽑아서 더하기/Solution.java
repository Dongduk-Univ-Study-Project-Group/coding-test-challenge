import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	
	public static void main(String[] args) {
		int[] array = {2,1,3,4,1};
		int[] array1 = {5, 0, 2, 7};

		System.out.println(solution(array));
		System.out.println(solution(array1));
	}
	
	public static int[] solution(int[] numbers) {  
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < numbers.length; i++) {
        	for(int j = i + 1; j < numbers.length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }
 
        ArrayList<Integer> list = new ArrayList<>();
        Iterator<Integer> iter = set.iterator();
        
        while(iter.hasNext()) {
        	list.add(iter.next());
        }
        
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < list.size(); i++) {
        	answer[i] = list.get(i);
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
	
}

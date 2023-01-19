import java.util.ArrayList;
import java.util.Collections;

public class Solution {
	
	public static void main(String[] args) {
		String[] array = {"sun", "bed", "car"};
		String[] array1 = {"abce", "abcd", "cdx"};

		System.out.println(solution(array, 1));
		System.out.println(solution(array1, 2));
	}

	public static String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        
        ArrayList<String> sList = new ArrayList<>();
        
        for(int i = 0; i < strings.length; i++) {
        	sList.add(strings[i].substring(n, n + 1) + strings[i]);
        }
        
        Collections.sort(sList);

        for (int i = 0; i < sList.size(); i++) {
            answer[i] = sList.get(i).substring(1, sList.get(i).length());
        }

        return answer;
    }
	
}

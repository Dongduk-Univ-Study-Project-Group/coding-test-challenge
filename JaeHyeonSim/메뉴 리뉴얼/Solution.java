import java.util.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        
        String[][] items = new String[orders.length][];
        for (int i = 0; i < orders.length; i++) {	// 선택된 메뉴 목록
	        items[i] = new String[orders[i].length()];
	        for (int j = 0; j < orders[i].length(); j++) {
	            items[i][j] = orders[i].substring(j, j + 1);
	        }
	        Arrays.sort(items[i]);
        }

        ArrayList<String> menuList = new ArrayList<>();
        for (int i = 0; i < course.length; i++) {   // 메뉴 개수별로 count
            HashMap<String, Integer> menu = new HashMap<>();
            
            int size = course[i];
            int[] bucket = new int[size];
	        for (int j = 0; j < orders.length; j++) {
	            if (items[j].length >= size) {
	                pick(items[j], bucket, menu, size);    // 조합으로 뽑기
	            }
	        }

            if (menu.size() > 0) {
                int maxVal = Collections.max(menu.values());
                if (maxVal >= 2) {
                    for (String key : menu.keySet()) {    // 가장 많이 주문한 메뉴(2회 이상)
                        if (menu.get(key) == maxVal) {
                            menuList.add(key);
                        }
                    }
                }
            }
        }
        answer = menuList.toArray(new String[menuList.size()]);
	    Arrays.sort(answer);
        
        return answer;
    }
    
    public void pick(String[] items, int[] bucket, HashMap<String, Integer> menu, int k) {
        if (k == 0) {
            String result = "";
            for (int i : bucket) {  // item 합치기
                result += items[i];
            }
            
            if (!menu.containsKey(result)) {    // menu 추가
                menu.put(result, 1);
            } else {
                menu.replace(result, menu.get(result) + 1);
            }
            
            return;
        }
        
        int lastIndex = bucket.length - 1 - k;
        int smallest = 0;
        if (lastIndex >= 0) {   // 조합(중복X)
            smallest = bucket[lastIndex] + 1;
        }
        
        for (int i = smallest; i < items.length; i++) {
            bucket[lastIndex + 1] = i;
            pick(items, bucket, menu, k - 1);
        }
    }
}
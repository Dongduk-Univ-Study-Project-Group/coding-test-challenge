import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        double answer = 0;
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        List<String> union = new ArrayList<>();
        List<String> intersection = new ArrayList<>();

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for(int i = 0; i<str1.length() - 1; i++) {
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i+1);
            if(isAlpha(c1) && isAlpha(c2)) {
                list1.add(c1 + "" + c2);
            }
        }
        for(int i = 0; i<str2.length() - 1; i++) {
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i+1);
            if(isAlpha(c1) && isAlpha(c2)) {
                list2.add(c1 + "" + c2);
            }
        }
        Collections.sort(list1);
        Collections.sort(list2);

        for(String s : list1) {
            if(list2.remove(s)) {
                intersection.add(s);
            }
            union.add(s);
        }

        for(String s : list2) {
            union.add(s);
        }

        if(union.size() == 0) {
            answer = 1;
        } else {
            answer = (double)intersection.size() / (double)union.size();
        }

        return (int) (answer * 65536);
    }
    public static boolean isAlpha(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }
}
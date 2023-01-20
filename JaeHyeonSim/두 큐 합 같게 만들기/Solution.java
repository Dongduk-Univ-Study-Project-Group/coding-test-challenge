import java.util.ArrayList;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = -2;
        
        long sum, s1, s2;
        sum = s1 = s2 = 0;
        ArrayList<Integer> combine = new ArrayList<Integer>();
        for (int i = 0; i < queue1.length; i++) {
            s1 += queue1[i];
            combine.add(queue1[i]);
            // q2.add(queue2[i]);
        }
        for (int i = 0; i < queue2.length; i++) {
            s2 += queue2[i];
            combine.add(queue2[i]);
        }
        sum = (s1 + s2) / 2;
        
        int min = queue1.length * 4 + 1;
        for (int leng = 1; leng <= qSize * 2; leng++) {
            int s = 0;
            int e = qSize * 2 - leng;
            if (leng >= qSize) {
                s = 1;
                e = qSize * 2 - leng - 1;
            }
            // 길이별(1~queue)로 연속한 숫자를 선택
            for (int start = s; start <= e; start++) {
                long total = 0;
                for (int j = start; j < start + leng; j++) {    // 합계 계산
                    if (j < qSize) {
                        total += queue1[j];
                    } else {
                        total += queue2[j - qSize];
                    }
                }
                // System.out.println(leng + " " + start + " " + (start + leng - 1));
                
                if (total == sum) { // 이동 횟수 계산
                    int count = 0;
                    if (start + leng != qSize * 2) {
                        count += start;
                    }
                    if (start + leng > qSize) {    // 마지막 숫자가 queue2면
                        count += (start + leng) - qSize;
                    }
                    if (count < min) {
                        min = count;
                    }
                }
            }
        }
        
        
        
        if (min == leng * 4 + 1) {
            answer = -1;
        } else {
            answer = min;
        }
        
        return answer;
    }
    
//     for (int i = -1; i < leng * 2; i++) {
//             if (i != -1) {
//                 if (i < leng) {
//                     s1 -= queue1[i];
//                 } else {
//                     // s1 -= queue2[i - leng];
//                 }
//             }
//             long total = s1;
            
//             for (int j = -1; j < leng * 2; j++) {
//                 if (j != -1) {
//                     if (j < leng) {
//                         if (i >= leng) {
//                             break;
//                         }
//                         total += queue2[j];
//                     } else  {
//                         if (i < leng) {
//                             break;
//                         }
//                         // total += queue1[j - leng];
//                     }
//                 }
                
//                 if (total == sum && i + j < min) {
//                     min = i + j + 2;
//                 }
//                 System.out.println(i + " " + j + " total " + total);
//             }
//         }
        
//         for (int i = -1; i < leng * 2; i++) {
//             if (i != -1) {
//                 if (i < leng) {
//                     s2 -= queue2[i];
//                 } else {
//                     // s1 -= queue2[i - leng];
//                 }
//             }
//             long total = s2;
            
//             for (int j = -1; j < leng * 2; j++) {
//                 if (j != -1) {
//                     if (j < leng) {
//                         if (i >= leng) {
//                             break;
//                         }
//                         total += queue1[j];
//                     } else  {
//                         if (i < leng) {
//                             break;
//                         }
//                         // total += queue1[j - leng];
//                     }
//                 }
                
//                 if (total == sum && i + j < min) {
//                     min = i + j + 2;
//                 }
//                 System.out.println(i + " " + j + " total " + total);
//             }
//         }
    
}
class Solution {
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = {};
        
        int[] discount = { 10, 20, 30, 40 };
        int[] bucket = new int[emoticons.length];   // 할인율을 중복순열로 선택
        answer = new int[]{ 0, 0 };
        answer = pick(discount, bucket, bucket.length, users, emoticons, answer);
        
        return answer;
    }
    
    public int[] pick(int[] items, int[] bucket, int k, int[][] users, int[] emoticons, int[] best) {
        if (k == 0) {   // 뽑기 완료 시
            int subscriber = 0;
            int revenue = 0;
            for (int i = 0; i < users.length; i++) {
                int purchase = 0;
                for (int j = 0; j < bucket.length; j++) {
                    if (bucket[j] >= users[i][0]) {     // 할인율이 기준보다 높으면 구매
                        purchase += (emoticons[j] * (100 - bucket[j]) * 0.01) / 100 * 100;
                    }
                    if (purchase >= users[i][1]) {  // 가격이 기준보다 높으면 서비스 가입
                        subscriber++;
                        purchase = 0;
                        break;
                    }
                }
                if (purchase > 0) {     // 서비스에 가입하지 않으면 그대로 구매
                    revenue += purchase;
                }
            }
            
            return new int[]{subscriber, revenue};
        }
        
        int lastIndex = bucket.length - 1 - k;
        int smallest = 0;
        if (bucket.length != k) {
            smallest = bucket[lastIndex];
        }
        
        for (int i = 0; i < items.length; i++) {
            bucket[lastIndex + 1] = items[i];
            int[] result = pick(items, bucket, k - 1, users, emoticons, best);
            
            if (result[0] > best[0]) {  // 결과값 비교
                best = result;
            } else if (result[0] == best[0] && result[1] > best[1]) {
                best = result;
            }
        }
        
        return best;
    }
}
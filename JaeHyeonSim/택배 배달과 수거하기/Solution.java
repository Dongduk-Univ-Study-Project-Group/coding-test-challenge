class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        int deliDone = n;   // 배달을 끝낸 집
        int pickDone = n;   // 수거를 끝낸 집
        int now, visit;     // 현위치, 방문할 집
        int deliBox, pickBox;    // 배달, 픽업할 상자 개수
        
        while (deliDone > 0 || pickDone > 0) {
            now = -1;
            deliBox = cap;
            pickBox = 0;
            int done = Math.max(deliDone, pickDone);
            
            for (visit = done - 1; visit >= 0; visit--) {
                
                if (deliveries[visit] == 0 && visit == deliDone - 1) {
                    deliDone = visit;
                }
                if (pickups[visit] == 0 && visit == pickDone - 1) {
                    pickDone = visit;
                }
                if (deliveries[visit] == 0 && pickups[visit] == 0) {
                    continue;
                }
                answer += Math.abs(visit - now);    // 방문 거리 계산
                now = visit;

                if (deliBox > 0) {  // 배달
                    if (deliveries[visit] >= deliBox) {
                        deliveries[visit] -= deliBox;
                        deliBox = 0;
                    } else {
                        deliBox -= deliveries[visit];
                        deliveries[visit] = 0;
                    }
                }

                if (pickBox < cap) {    // 수거
                    if (pickups[visit] >= cap - pickBox) {
                        pickups[visit] -= cap - pickBox;
                        pickBox = cap;
                    } else {
                        pickBox += pickups[visit];
                        pickups[visit] = 0;
                    }
                }
                
                if (deliBox == 0 && pickBox == cap) {
                    now = -1;
                    break;
                } else if (deliBox == 0) {
                    visit = pickDone;
                } else if (pickBox == cap) {
                    visit = deliDone;
                }
            }
            answer += Math.abs(visit - now);    // 남은 거리 계산
        }
        
        return answer;
    }
}
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        int bLeng = 0;
        int[] bucket = new int[board.length * board[0].length + 1];
        
        for (int i = 0; i < moves.length; i++) {
            int move = moves[i] - 1;
            
            for (int j = 0; j < board.length; j++) {
                if (board[j][move] == 0) {
                    continue;
                } else {
                    bucket[bLeng++] = board[j][move];
                    board[j][move] = 0;
                    if (bLeng > 1 && (bucket[bLeng - 1] == bucket[bLeng - 2])) {
                        answer += 2;
                        bLeng -= 2;
                    }
                    break;
                }
            }
        }
        
        return answer;
    }
}
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
        
        int[][] matrix = makeMatrix(rows, columns);
        
        answer = new int[queries.length];
        for (int k = 0; k < queries.length; k++) {
            int x1 = queries[k][0] - 1;
            int y1 = queries[k][1] - 1;
            int x2 = queries[k][2] - 1;
            int y2 = queries[k][3] - 1;
            
            answer[k] = rotate(matrix, x1, y1, x2, y2);
        }
        
        return answer;
    }
    
    public int[][] makeMatrix(int rows, int columns) {
        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = i * columns + j + 1;
            }
        }
        return matrix;
    }
    
    public int rotate(int[][] matrix, int x1, int y1, int x2, int y2) {
        int start = matrix[x1][y1];
        int min = start;
        
        for (int x = x1; x < x2; x++) {     // 왼쪽줄
            matrix[x][y1] = matrix[x + 1][y1];
            if (matrix[x][y1] < min) {
                min = matrix[x][y1];
            }
        }
        for (int y = y1; y < y2; y++) {     // 아랫줄
            matrix[x2][y] = matrix[x2][y + 1];
            if (matrix[x2][y] < min) {
                min = matrix[x2][y];
            }
        }
        for (int x = x2; x > x1; x--) {     // 오른쪽줄
            matrix[x][y2] = matrix[x - 1][y2];
            if (matrix[x][y2] < min) {
                min = matrix[x][y2];
            }
        }
        for (int y = y2; y > y1; y--) {     // 윗줄
            matrix[x1][y] = matrix[x1][y - 1];
            if (matrix[x1][y] < min) {
                min = matrix[x1][y];
            }
        }
        matrix[x1][y1 + 1] = start;
        
        return min;
    }
}
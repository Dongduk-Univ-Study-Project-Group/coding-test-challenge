class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] temp = new int[triangle.length][triangle[triangle.length-1].length];
        temp[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            temp[i][0] = temp[i - 1][0] + triangle[i][0];
            temp[i][i] = temp[i - 1][i - 1] + triangle[i][i];
            for (int j = 1; j <= i-1; j++) {
                temp[i][j] = Math.max(temp[i - 1][j - 1], temp[i - 1][j]) + triangle[i][j];
                answer = Math.max(answer, temp[i][j]);
            }
        }

        return answer;
    }
}
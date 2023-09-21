// 自顶向下
class Solution {
    int[][] memo;
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        memo = new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(memo[i], 10001);
        }
        int res = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            res = Math.min(res, dp(matrix, n-1, i));
        }
        return res;
    }
    public int dp(int[][] matrix, int i, int j){
        if(j < 0 || j >= matrix.length){
            return 10001;
        }
        if(i == 0){
            return matrix[i][j];
        }
        if(memo[i][j]!=10001){
            return memo[i][j];
        }
        memo[i][j] = matrix[i][j] + 
                    min(
                        dp(matrix, i-1, j-1),
                        dp(matrix, i-1, j),
                        dp(matrix, i-1, j+1)
                    );
        return memo[i][j];
    }
    public int min(int a, int b, int c){
        return Math.min(a, Math.min(b, c));
    }
}

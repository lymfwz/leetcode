/*
先写出算法框架，然后完善细节。
*/
class Solution {
    int[][] pre;
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        pre = new int[m+1][n+1];
        int[][] answer = new int[m][n];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                pre[i][j] = pre[i-1][j] + pre[i][j-1] - pre[i-1][j-1] + mat[i-1][j-1];
            }
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                int row1 = Math.max(i-k-1, 0), row2 = Math.min(i+k, m);
                int col1 = Math.max(j-k-1, 0), col2 = Math.min(j+k, n);
                answer[i-1][j-1] = pre[row2][col2] - pre[row1][col2] - pre[row2][col1] + pre[row1][col1];
            }
        }
        return answer;
    }
}

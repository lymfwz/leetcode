/*
dp - 自顶向下
*/
class Solution {
    int[][] memo;
    public int minInsertions(String s) {
        int n = s.length();
        memo = new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(memo[i], -1);
        return dp(s, 0, n-1);
    }
    public int dp(String s, int i, int j){
        if(i > j) return 0;
        if(i == j) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        char ch1 = s.charAt(i);
        char ch2 = s.charAt(j);
        if(ch1 == ch2) { // 无需修改
            memo[i][j] = dp(s, i+1, j-1);
        } else {
            memo[i][j] = Math.min(dp(s, i, j-1), dp(s, i+1, j)) + 1;
        }
        return memo[i][j];
    }
}
/*
动态规划 - 二维数组
*/

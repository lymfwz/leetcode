/*
 dp - 自顶向下
*/
class Solution {
    int[][] memo;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        memo = new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(memo[i], -1);
        return dp(text1, 0, text2, 0);
    }
    public int dp(String text1, int i, String text2, int j){
        if(i == text1.length() || j == text2.length()){
            return 0;
        }
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        char ch1 = text1.charAt(i);
        char ch2 = text2.charAt(j);
        if(ch1 == ch2){
            memo[i][j] = 1 + dp(text1, i+1, text2, j+1);
        } else {
            memo[i][j] = Math.max(dp(text1, i+1, text2, j),
                                    dp(text1, i, text2, j+1));
        }
        return memo[i][j];
    }
}
/*
动态规划 - 二维
*/
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            char ch1 = text1.charAt(i-1);
            for(int j=1;j<=n;j++){
                char ch2 = text2.charAt(j-1);
                if(ch1 == ch2){
                    dp[i][j] = dp[i-1][j-1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-1], Math.max(dp[i][j-1], dp[i-1][j]));
                }
            }
        }
        return dp[m][n];
    }
}
/*
动态规划 - 一维
*/
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        // int[][] dp = new int[m+1][n+1];
        int[] dp = new int[n+1];
        int[] pre = new int[n+1];
        for(int i=1;i<=m;i++){
            char ch1 = text1.charAt(i-1);
            int spre = 0;
            for(int j=1;j<=n;j++){
                char ch2 = text2.charAt(j-1);
                if(ch1 == ch2){
                    // dp[i][j] = dp[i-1][j-1] + 1;
                    dp[j] = spre + 1;
                } else {
                    // dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                    dp[j] = Math.max(dp[j-1], pre[j]);
                }
                spre = pre[j];
                pre[j] = dp[j]; // 给下一轮用
            }
        }
        // return dp[m][n];
        return dp[n];
    }
}

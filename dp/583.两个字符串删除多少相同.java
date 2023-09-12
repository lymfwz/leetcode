/*
dp - 自顶向下
*/
class Solution {
    int[][] memo;
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        memo = new int[m][n];
        for(int i=0;i<m;i++) Arrays.fill(memo[i], -1);
        return dp(word1, 0, word2, 0);
    }
    public int dp(String word1, int i, String word2, int j){
        int res = 0;
        if(i == word1.length()){
            res += word2.length() - j;
            return res;
        }
        if(j == word2.length()){
            res += word1.length() - i;
            return res;
        }
        if(memo[i][j] != -1) return memo[i][j];
        char ch1 = word1.charAt(i);
        char ch2 = word2.charAt(j);
        if(ch1 == ch2){
            memo[i][j] = dp(word1, i+1, word2, j+1);
        } else {
            memo[i][j] = Math.min(dp(word1, i, word2, j+1), dp(word1, i+1, word2, j)) + 1;
        }
        return memo[i][j];
    }
}
/*
动态规划 - 二维数组
*/
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1;i<=n;i++) dp[0][i] = i; // 这里需要初始化
        for(int i=1;i<=m;i++) dp[i][0] = i;
        for(int i=1;i<=m;i++){
            char ch1 = word1.charAt(i-1);
            for(int j=1;j<=n;j++){
                char ch2 = word2.charAt(j-1);
                if(ch1 == ch2) {
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
/*
动态规划 - 一维数组
*/
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // int[][] dp = new int[m+1][n+1];
        // for(int i=1;i<=n;i++) dp[0][i] = i;
        // for(int i=1;i<=m;i++) dp[i][0] = i;
        int[] dp = new int[n+1];
        int[] pre = new int[n+1];
        for(int i=1;i<=n;i++) {
            dp[i] = i;
            pre[i] = i;
        }
        for(int i=1;i<=m;i++){
            char ch1 = word1.charAt(i-1);
            dp[0] = i;
            for(int j=1;j<=n;j++){
                char ch2 = word2.charAt(j-1);
                if(ch1 == ch2) {
                    // dp[i][j] = dp[i-1][j-1];
                    dp[j] = pre[j-1];
                } else {
                    // dp[i][j] = Math.min(dp[i][j-1], dp[i-1][j]) + 1;
                    dp[j] = Math.min(dp[j-1], pre[j]) + 1;
                }
            }
            for(int j=1;j<=n;j++){
                pre[j] = dp[j];
            }
            pre[0] = i;
        }
        // return dp[m][n];
        return dp[n];
    }
}
/*
先求最长公共子序列，m+n - 2*lcs
*/
class Solution {
    public int minDistance(String word1, String word2) {
        int lcs = longestCommonSubsequence(word1, word2);
        return word1.length() - lcs + word2.length() - lcs;
    }
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

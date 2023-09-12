/*
dp - 自顶向下
*/
class Solution {
    int[][] memo; // 备忘录
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        memo = new int[n][n];
        for(int i=0;i<n;i++) Arrays.fill(memo[i], -1);
        return dp(s, 0, n-1);
    }
    public int dp(String s, int i, int j){
        if(i > j) return 0;
        if(i == j) return 1;
        if(memo[i][j] != -1) return memo[i][j];
        char ch1 = s.charAt(i);
        char ch2 = s.charAt(j);
        if(ch1 == ch2){
            memo[i][j] = 2 + dp(s, i+1, j-1);
        } else {
            memo[i][j] = Math.max(dp(s, i, j-1), dp(s, i+1, j));
        }
        return memo[i][j];
    }
}
/*
动态规划 ： 自底向上
*/
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i=0;i<n;i++) dp[i][i] = 1;
        for(int i=n-2;i>=0;i--){ 
            char ch1 = s.charAt(i);
            for(int j = i+1;j<n;j++){
                char ch2 = s.charAt(j);
                if(ch1 == ch2){
                    dp[i][j] = 2 + dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}
/*
动态规划 ： 一维数组优化 == 在原有二维上修改一下
*/
class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        // int[][] dp = new int[n][n];
        int[] dp = new int[n];
        // for(int i=0;i<n;i++) dp[i][i] = 1;
        for(int i=0;i<n;i++) dp[i] = 1;
        int[] pre = new int[n];
        for(int i=0;i<n;i++) pre[i] = 1;
        for(int i=n-2;i>=0;i--){ 
            char ch1 = s.charAt(i);
            for(int j = i+1;j<n;j++){
                char ch2 = s.charAt(j);
                if(ch1 == ch2){
                    // dp[i][j] = 2 + dp[i+1][j-1];
                    dp[j] = 2 + (i+1>j-1 ? 0 : pre[j-1]);
                } else {
                    // dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                    dp[j] = Math.max(pre[j], dp[j-1]);
                }
            }
            for(int j= i+1;j<n;j++) pre[j] = dp[j];
        }
        // return dp[0][n-1];
        return dp[n-1];
    }
}

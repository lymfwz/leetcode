/*
备忘录
*/
class Solution {
    int[][] memo;
    public int minDistance(String word1, String word2) {
        memo = new int[word1.length()+1][word2.length()+1];
        for(int i=0;i<=word1.length();i++){
            Arrays.fill(memo[i], -1);
        }
        return dp(word1, 0, word2, 0);
    }
    public int dp(String s, int i, String t, int j){
        if(i == s.length()){
            return t.length() - j;
        }
        if(j == t.length()){
            return s.length() - i;
        }
        if(memo[i][j] != -1) return memo[i][j];
        char ch1 = s.charAt(i);
        char ch2 = t.charAt(j);
        if(ch1 == ch2){
            int ans = dp(s, i+1, t, j+1);
            memo[i][j] = ans;
        } else {
            int insertOrDelete = Math.min(dp(s, i, t, j+1), dp(s, i+1, t, j)) + 1;
            int modify = dp(s, i+1, t, j+1) + 1;
            memo[i][j] = Math.min(insertOrDelete, modify);
        }
        return memo[i][j];
    }
}
/*
dp[i][j] 表示以i-1，j-1结尾的两个字符串的最小编辑距离
*/
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=n;i++) dp[0][i] = i;
        for(int i=0;i<=m;i++) dp[i][0] = i;
        for(int i=1;i<=m;i++){
            char ch1 = word1.charAt(i-1);
            for(int j=1;j<=n;j++){
                char ch2 = word2.charAt(j-1);
                if(ch1 == ch2){
                    dp[i][j] = dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
/*
改一维
*/
class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // int[][] dp = new int[m+1][n+1];
        // for(int i=0;i<=n;i++) dp[0][i] = i;
        // for(int i=0;i<=m;i++) dp[i][0] = i;
        int[] dp = new int[n+1];
        int[] pre = new int[n+1];
        for(int i=0;i<=n;i++) {
            dp[i] = i;
            pre[i] = i;
        }
        for(int i=1;i<=m;i++){
            char ch1 = word1.charAt(i-1);
            dp[0] = i;
            for(int j=1;j<=n;j++){
                char ch2 = word2.charAt(j-1);
                if(ch1 == ch2){
                    // dp[i][j] = dp[i-1][j-1];
                    dp[j] = pre[j-1];
                } else {
                    // dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1])) + 1;
                    dp[j] = Math.min(pre[j-1], Math.min(pre[j], dp[j-1])) + 1;
                }
            }
            for(int k=0;k<=n;k++){
                pre[k] = dp[k];
            }
        }
        // return dp[m][n];
        return dp[n];
    }
}

class Solution {
    int[][] memo;
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

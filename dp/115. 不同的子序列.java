// 自顶向下
class Solution {
    int[][] memo;
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        memo = new int[m][n];
        for(int i=0;i<m;i++) {
            Arrays.fill(memo[i], -1);
        }
        return dp(s, 0, t, 0);
    }
    public int dp(String s, int i, String t, int j){
        if(j == t.length()) return 1;
        if(s.length()-i < t.length() - j) return 0;
        if(memo[i][j]!=-1){
            return memo[i][j];
        }
        if(s.charAt(i) == t.charAt(j)){
            memo[i][j] = dp(s, i+1, t, j+1) + dp(s, i+1, t, j);
        } else {
            memo[i][j] = dp(s, i+1, t, j);
        }
        return memo[i][j];
    }
}

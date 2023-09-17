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

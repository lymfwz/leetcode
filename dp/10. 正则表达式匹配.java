class Solution {
    int[][] memo;
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        memo = new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(memo[i], -1);
        }
        return dp(s, 0, p, 0);
    }
    public boolean dp(String s, int i, String p, int j){
        if(j == p.length()) {
            return i == s.length();
        }
        if(i == s.length()) {
            if((p.length() - j) % 2 == 1) return false;
            for(int k = j+1;k<p.length();k+=2){
                if(p.charAt(k)!='*'){
                    return false;
                }
            }
            return true;
        }
        if(memo[i][j] != -1) return memo[i][j] == 1;
        boolean res = false;
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') { // 当前匹配
            if(j+1 < p.length() && p.charAt(j+1) == '*'){
                res |= (dp(s, i+1, p, j) || dp(s, i, p, j+2));
            } else {
                res = dp(s, i+1, p, j+1);
            }
        } else { // 当前不匹配
            if(j+1 < p.length() && p.charAt(j+1) == '*') {
                res = dp(s, i, p, j+2);
            } else {
                res = false;
            }
        }
        memo[i][j] = res ? 1 : 0;
        return memo[i][j] == 1;
    }
}

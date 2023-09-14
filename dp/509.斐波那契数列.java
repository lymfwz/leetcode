/*
使用备忘录的自顶向下动态规划
*/
class Solution {
    int[] memo;
    public int fib(int n) {
        memo = new int[n+1];
        Arrays.fill(memo, -1);
        memo[0] = 0;
        return dp(n);
    }
    public int dp(int n){
        if(n <= 1) return n;
        if(memo[n] != -1) return memo[n];
        memo[n] = dp(n-1) + dp(n-2);
        return memo[n];
    }
}
/*
自底向上
*/
class Solution {
    public int fib(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        if(n == 0) return 0;
        dp[1] = 1;
        for(int i=2;i<=n;i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}

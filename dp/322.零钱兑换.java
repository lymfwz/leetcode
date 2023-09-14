/*
自顶向下动态规划：这里的可达 -> 可达之前的不可达状态也是可达！
注意初始状态 0 与 可达状态 -1/value 不要重复，否则就不能用可达状态，时间复杂度就是O(2^n)
*/
class Solution {
    int[] memo;
    public int coinChange(int[] coins, int amount) {
        memo = new int[amount+1];
        return dp(coins, amount);
    }
    public int dp(int[] coins, int amount){
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        if(memo[amount] != 0) return memo[amount]; // 可达
        int ans = Integer.MAX_VALUE;
        for(int coin : coins){
            int temp = dp(coins, amount - coin);
            if(temp != -1){
                ans = Math.min(ans, temp + 1);
            }
        }
        return memo[amount] = (ans == Integer.MAX_VALUE ? -1 : ans);
    }
}
/*
自底向上动态规划
*/
class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1); // 初始化成不可能情况，不是Integer.MAX_VALUE是因为+1越界
        dp[0] = 0;
        for(int i=1;i<=amount;i++){
            for(int coin : coins){
                if(i - coin >= 0){
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }
        return dp[amount] == amount+1 ? -1 : dp[amount];
    }
}

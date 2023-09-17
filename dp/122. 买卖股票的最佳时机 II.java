// 二维
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0; // 不持有
        dp[0][1] = -prices[0]; // 持有股票
        for(int i=1;i<n;i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[n-1][0];
    }
}
// 一维
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int sold = 0;
        int hold = -prices[0];
        for(int i=1;i<n;i++){
            int temp = sold;
            sold = Math.max(sold, hold + prices[i]);
            hold = Math.max(hold, temp - prices[i]);
        }
        return sold;
    }
}

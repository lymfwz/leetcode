class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[4]; // hold1 sold1 hold2 sold2
        dp[0] = -prices[0];
        dp[2] = -prices[0];
        for(int i=1;i<n;i++){
            for(int j=0;j<4;j++){
                if(j%2==0){
                    if(j==0){
                        dp[j] = Math.max(dp[j], -prices[i]);
                    } else {
                        dp[j] = Math.max(dp[j], dp[j-1] - prices[i]);
                    }
                } else {
                    dp[j] = Math.max(dp[j], dp[j-1] + prices[i]);
                }
            }
        }
        return dp[3];
    }
}

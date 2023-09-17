class Solution {
    public int maxProfit(int k, int[] prices) {
        int[] dp = new int[2*k]; // hold1 sold1 hold2 sold2 ......
        int n = prices.length;
        for(int i=0;i<2*k;i+=2){
            dp[i] = -prices[0];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<2*k;j++){
                if(j==0) {
                    dp[j] = Math.max(dp[j], -prices[i]);
                    continue;
                }
                if(j % 2 == 0){
                    dp[j] = Math.max(dp[j], dp[j-1] - prices[i]);
                } else {
                    dp[j] = Math.max(dp[j], dp[j-1] + prices[i]);
                }
            }
        }
        return dp[2*k - 1];
    }
}

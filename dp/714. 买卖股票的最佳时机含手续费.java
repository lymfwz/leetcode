class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int sold = 0, hold = -prices[0];
        for(int i=1;i<n;i++){
            sold = Math.max(sold, hold + prices[i] - fee);
            hold = Math.max(hold, sold - prices[i]);
        }
        return sold;
    }
}

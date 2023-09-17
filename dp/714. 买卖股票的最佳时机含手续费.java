class Solution {
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int sold = 0, hold = -prices[0];
        for(int i=1;i<n;i++){
            int temp = sold;
            sold = Math.max(sold, hold + prices[i] - fee);
            hold = Math.max(hold, temp - prices[i]);
        }
        return sold;
    }
}

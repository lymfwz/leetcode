class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int hold = prices[0];
        int max = 0;
        for(int i=0;i<n;i++){
            hold = Math.min(hold, prices[i]);
            max = Math.max(max, prices[i] - hold);
        }
        return max;
    }
}

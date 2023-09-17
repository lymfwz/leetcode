// 三种状态
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int sold = 0, hold = -prices[0], freeze = 0;
        int max = 0;
        for(int i=1;i<n;i++){
            int temp = sold;
            sold = Math.max(sold, hold + prices[i]);
            hold = Math.max(hold, freeze - prices[i]);
            freeze = temp;
            max = Math.max(max, sold);
        }
        return max;
    }
}

class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        // dpi表示以i-1结尾的子数组最大和
        int res = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            dp[i+1] = Math.max(nums[i], dp[i] + nums[i]);
            res = Math.max(dp[i+1], res);
        }
        return res;
    }
}

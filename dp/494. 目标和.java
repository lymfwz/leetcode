// 二维
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++) {
            sum += nums[i];
        }
        if((sum + target) % 2 != 0 || sum + target < 0) return 0;
        target = (sum + target) / 2;
        // 0-1背包
        int[][] dp = new int[n+1][target+1];
        dp[0][0] = 1;
        for(int i=1;i<=n;i++) {
            dp[i][0] = 1; // 初始化
            for(int j=0;j<=target;j++) {
                dp[i][j] = dp[i-1][j]; // 当前即使用不了也可以继承之前的
                if(j >= nums[i-1]) {
                    dp[i][j] += dp[i-1][j-nums[i-1]]; // 使用当前数字的方案数 (当前数字不能重复使用)
                }
            }
        }
        return dp[n][target];
    }
}

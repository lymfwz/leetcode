/*
完全背包问题，双层for循环，注意初始化
*/
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int target = 0;
        int sum = 0;
        for(int i=0;i<n;i++){
            sum += nums[i];
        }
        if(sum % 2 != 0) return false;
        target = sum/2;
        boolean[][] dp = new boolean[n+1][target+1];
        for(int i=0;i<=n;i++) {
            dp[i][0] = true; // 初始化
        }
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=target;j++){
                if(j < nums[i-1]) {
                    dp[i][j] = dp[i-1][j]; // 装不下
                } else {
                    dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
                }
            }
        }
        return dp[n][target];
    }
}

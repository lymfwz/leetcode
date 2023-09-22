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
/*
降维
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
        // boolean[][] dp = new boolean[n+1][target+1];
        boolean[] dp = new boolean[target+1];
        // for(int i=0;i<=n;i++) {
        //     dp[i][0] = true; // 初始化
        // }
        dp[0] = true;
        for(int i=1;i<=n;i++) {
            // for(int j=1;j<=target;j++){
            //     if(j < nums[i-1]) {
            //         dp[i][j] = dp[i-1][j]; // 装不下
            //     } else {
            //         dp[i][j] = dp[i-1][j-nums[i-1]] || dp[i-1][j];
            //     }
            // }
            for(int j=target;j>=1;j--) {
                if(j >= nums[i-1]) {
                    dp[j] |= dp[j-nums[i-1]];
                }
            }
        }
        // return dp[n][target];
        return dp[target];
    }
}
// 自顶向下
class Solution {
    int[][] memo;
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i=0;i<n;i++) {
            sum += nums[i];
        }
        if(sum % 2 != 0) return false;
        int target = sum/2;
        memo = new int[n][target+1];
        return dp(nums, 0, target);
    }
    public boolean dp(int[] nums, int i, int target) {
        if(target < 0) return false;
        if(target == 0) return true;
        if(i == nums.length) {
            return false;
        }
        if(memo[i][target] != 0) {
            return memo[i][target] == 1;
        }
        memo[i][target] = (dp(nums, i+1, target - nums[i]) || dp(nums, i+1, target)) ? 1 : -1;
        return memo[i][target] == 1;
    }
}

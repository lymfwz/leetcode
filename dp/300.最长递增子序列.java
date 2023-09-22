/*
动态规划 - 一维
*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
/*
纸牌 + 二分法
*/
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] piles = new int[n]; // 牌堆
        int end = -1;
        for(int num : nums){
            int idx = getIndex(piles, num, end);
            if(idx == end + 1){
                end++;
            }
            piles[idx] = num;
        }
        return end + 1;
    }
    public int getIndex(int[] piles, int num, int end){ // 找下标位置
        int l = 0, r = end;
        int res = -1;
        while(l <= r){
            int mid = l + ((r - l)>>1);
            if(piles[mid] >= num){
                res = mid;
                r = mid - 1;
            } else {
                l = mid+1;
            }
        }
        return res == -1 ? end + 1 : res;
    }
}

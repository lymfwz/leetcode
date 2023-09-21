class Solution {
    public int splitArray(int[] nums, int k) {
        int n = nums.length;
        int lo = 0, hi = 0;
        for(int i=0;i<n;i++){
            lo = Math.max(lo, nums[i]);
            hi += nums[i];
        }
        int res = -1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(judge(nums, mid, k)){ // 划分的多了，可以减少划分
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return res;
    }
    public boolean judge(int[] nums, int mid, int k){
        int temp = 0;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            temp += nums[i];
            if(temp > mid){ // 这里大于才count++,因为保证了lo>=nums[i]
                temp = nums[i];
                count++;
            }
        }
        if(temp > 0){
            count++;
        }
        return count <= k;
    }
}

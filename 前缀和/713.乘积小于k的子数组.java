/*
前缀和 + 二分查找（>num）+ 取log + 防止差值（+ 1e-10）
总结：不如滑动窗口
*/
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        double[] pre = new double[n+1];
        pre[0] = 1;
        for(int i=0;i<n;i++){
            pre[i+1] = pre[i] + Math.log(nums[i]);
        }
        int count = 0;
        for(int i=1;i<=n;i++){
            double val = pre[i] - Math.log(k) + 1e-10;
            int idx = search(pre, 0, i-1, val);
            if(idx != -1){
                count += (i - idx);
            }
        }
        return count;
    }
    public int search(double[] pre, int l, int r, double num){ // >num 最zuo边界
        int res = -1;
        int left = l, right = r;
        while(left <= right){
            int mid = left + ((right-left)>>1);
            if(pre[mid] > num){
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return res;
    }
}

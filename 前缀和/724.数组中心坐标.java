/*
同LCR 012.寻找数组中心下标
*/
class Solution {
    int[] pre;
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        pre = new int[n+1];
        for(int i=0;i<n;i++){ // 初始化前缀数组
            pre[i+1] = pre[i] + nums[i];
        }
        for(int i=0;i<n;i++){ // 找最左端中心坐标
            int left = pre[i];
            int right = pre[n] - pre[i+1];
            if(left == right){
                return i;
            }
        }
        return -1;
    }
}

class Solution {
    int[] pre;
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        pre = new int[n+1];
        for(int i=0;i<n;i++){ // 初始化前缀数组
            pre[i+1] = pre[i] + nums[i];
        }
        for(int i=0;i<n;i++){ // 找最左端中心坐标
            int left = i == 0 ? 0 : pre[i];
            int right = i == n-1 ? 0 : (pre[n] - pre[i+1]);
            if(left == right){
                return i;
            }
        }
        return -1;
    }
}

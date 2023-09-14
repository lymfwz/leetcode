/*
子数组：连续
*/
class Solution {
    int[] pre;
    public int maxSubArrayLen(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        pre = new int[n+1];
        for(int i=0;i<n;i++) {
            pre[i+1] = pre[i] + nums[i];
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for(int i=1;i<=n;i++){
            if(map.containsKey(pre[i] - k)){
                res = Math.max(res, i - map.get(pre[i] - k));
            }
            map.putIfAbsent(pre[i], i);
        }
        return res;
    }
}

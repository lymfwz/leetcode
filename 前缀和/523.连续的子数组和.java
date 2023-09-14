/*
 使用 % 运算 + 前缀和 + 哈希表
*/
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] pre = new int[n+1];
        for(int i=0;i<n;i++){
            pre[i+1] = pre[i] + nums[i];
        }
        Map<Integer, Integer> map = new HashMap<>(); // 只放 pre[i] % k
        map.put(0, 0);
        for(int i=1;i<=n;i++){
            int re = pre[i] % k;
            if(re == 0 && i >= 2) return true; // 无需判断了，直接返回
            if(map.containsKey(re)){
                if(i - map.get(re) >= 2){
                    return true;
                }
            }
            map.putIfAbsent(re, i);
        }
        return false;
    }
}

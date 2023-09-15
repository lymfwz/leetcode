/*
前缀和 + 哈希表保存频次 + 先模k再+k再模k
*/
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // 频次
        int[] pre = new int[n+1];
        for(int i=0;i<n;i++){
            pre[i+1] = pre[i] + nums[i];
        }
        int count = 0;
        for(int i=1;i<=n;i++){
            int re = (pre[i] % k + k) % k;
            if(map.containsKey(re)){
                count += map.get(re);
            }
            map.put(re, map.getOrDefault(re, 0)+1);
        }
        return count;
    }
    // 0 -1 1 
}

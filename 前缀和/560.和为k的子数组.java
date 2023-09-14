/*
前缀和 + 哈希表 （存放出现的数和频次）
*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] pre = new int[n+1];
        for(int i=0;i<n;i++){
            pre[i+1] = pre[i] + nums[i];
        }
        Map<Integer, Integer> map = new HashMap<>(); // 值 - 频次
        map.put(0, 1);
        int count = 0;
        for(int i=1;i<=n;i++){
            if(map.containsKey(pre[i] - k)){
                count += map.get(pre[i] - k);
            }
            map.put(pre[i], map.getOrDefault(pre[i], 0) + 1);
        }
        return count;
    }
}

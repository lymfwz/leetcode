/*
前缀和 + 哈希表 + 数学公式 + 先放数据、再判断是否包含
将最小操作次数转为符合条件的子数组最长长度
*/
class Solution {
    public int minOperations(int[] nums, int x) {
        // 最长长度
        int n = nums.length;
        int[] pre = new int[n+1];
        int sum = 0;
        for(int i=0;i<n;i++){
            pre[i+1] = pre[i] + nums[i];
            sum += nums[i];
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        int minCount = Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            // prei - prex + x = sum
            int prex = pre[i] + x - sum;
            map.putIfAbsent(pre[i], i);
            if(map.containsKey(prex)){
                minCount = Math.min(n - i + map.get(prex), minCount);
            }
        }
        return minCount == Integer.MAX_VALUE ? -1 : minCount;
    }
}

/*
使用前缀和 + 哈希表，哈希表存放某个pre[i]最找出现的，以保证最长
*/
class Solution {
    int[] pre;
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        pre = new int[n+1];
        for(int i=0;i<n;i++){
            int ans = nums[i] == 0 ? -1 : 1;
            pre[i+1] = pre[i] + ans;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = 0;
        for(int i=0;i<n;i++){
            int cur = pre[i+1];
            if(map.containsKey(cur)){
                maxLen = Math.max(i - map.get(cur), maxLen);
            }
            map.putIfAbsent(cur, i);
        }

        return maxLen;
    }
}
/*
将前缀和数组化为变量 == 注意pre加的不是nums[i]而是0、1的个数
*/
class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxLen = 0;
        int pre = 0;
        for(int i=0;i<n;i++){
            pre += (nums[i] == 0 ? -1 : 1);
            if(map.containsKey(pre)){
                maxLen = Math.max(i - map.get(pre), maxLen);
            }
            map.putIfAbsent(pre, i);
        }

        return maxLen;
    }
}

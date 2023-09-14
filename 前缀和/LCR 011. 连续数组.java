/*
最长 - 没有的数才放
*/
class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n+1];
        for(int i=0;i<n;i++){
            pre[i+1] = pre[i] + (nums[i] == 1 ? 1 : -1);
        }
        int maxLen = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        for(int i=1;i<=n;i++){
            if(map.containsKey(pre[i])){
                maxLen = Math.max(maxLen, i - map.get(pre[i]));
            }
            map.putIfAbsent(pre[i], i); // 最长，缺席才放
        }
        return maxLen;
    }
}

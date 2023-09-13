/*
使用前缀和 + 哈希表保存最早出现的pre[i]
*/
class Solution {
    int[] pre;
    public int longestWPI(int[] hours) {
        int n = hours.length;
        pre = new int[n+1];
        for(int i=0;i<n;i++){
            // 劳累+1，不劳累-1
            pre[i+1] = pre[i] + (hours[i] > 8 ? 1 : -1);
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int maxBest = 0;
        for(int i=0;i<n;i++){
            int cur = pre[i+1];
            // pre[i+1] - pre[i] > 0
            for(Map.Entry<Integer, Integer> entry : map.entrySet()){
                if(entry.getKey() < cur){
                    maxBest = Math.max(maxBest, i - entry.getValue());
                }
            }
            map.putIfAbsent(cur, i);
        }
        return maxBest;
    }
}
/*
感觉滑动窗口的贪心思想更好(滑动窗口解不了，能解最小的窗口，最大无法扩展)
使用前缀和：
1. 前缀和>0 , 返回i+1
2. 前缀和<0 , 找pre-1 , 看下图的例子即可。
*/
class Solution {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        int pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int i=0;i<n;i++){
            pre += (hours[i] > 8 ? 1 : -1);
            if(pre > 0) { // 累计劳累天数 > 0
                res = Math.max(res, i+1);
            } else {
                if(map.containsKey(pre - 1)){
                    res = Math.max(res, i - map.get(pre - 1));
                }
                if(!map.containsKey(pre)){
                    map.put(pre, i);
                }
            }
        }
        return res;
    }
    // 1 2 3 2 1 0 -1 -2 -3 -2 -1 0 1 2 1 0 1 2 3 4 5 6 7 8 9 10
    // -1 -2 -3 -2 -1 0
    //  6  6  6  9  9 9
}

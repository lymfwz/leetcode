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
感觉滑动窗口的贪心思想更好
*/

/*
前缀和 + 哈希表 + "List".stream().mapToInt(Integer::intValue).toArray();
*/
class Solution {
    public int[][] findContinuousSequence(int target) {
        int mid = target/2 + 1;
        int pre = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 0);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=1;i<=mid;i++){
            pre += i;
            if(map.containsKey(pre - target)){
                int start = map.get(pre - target)+1;
                List<Integer> sub = new ArrayList<>();
                for(int j=start;j<=i;j++){
                    sub.add(j);
                }
                res.add(sub);
            }
            map.put(pre, i);
        }
        int[][] ans = new int[res.size()][];
        for(int i=0;i<res.size();i++){
            ans[i] = res.get(i).stream().mapToInt(Integer::intValue).toArray();
        }
        return ans;
    }
}

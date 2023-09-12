/*
降维到一维 ==> 最长子序列问题 (采用纸牌 + 二分查找)
*/
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        // w 升序，h降序==> 因为h不可能自己放进去自己（宽度相同时）
        Arrays.sort(envelopes, new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2){
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        }); 
        int[] piles = new int[n]; // 牌堆
        int end = -1;
        for(int i=0;i<n;i++){
            int num = envelopes[i][1];
            int idx = getIndex(piles, num, end);
            if(idx == end+1){
                end++;
            }
            piles[idx] = num;
        }
        return end+1;
    }
    public int getIndex(int[] piles, int num, int end){
        int l = 0, r = end;
        int res = -1;
        while(l <= r){
            int mid = l + ((r-l)>>1);
            if(piles[mid] >= num){
                res = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return res == -1 ? end+1 : res;
    }
}
/*
降维 - 采用动态规划
*/

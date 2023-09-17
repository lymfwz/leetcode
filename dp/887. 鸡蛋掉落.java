/*
base case + 二分查找（某次选择）
*/
class Solution {
    int[][] memo;
    public int superEggDrop(int k, int n) {
        memo = new int[k+1][n+1];
        for(int i=0;i<=k;i++) Arrays.fill(memo[i], -666);
        return dp(k, n);
    }
    public int dp(int k, int n){
        if(k == 1) return n; // 最坏情况
        if(n == 0) return 0; // 无需扔鸡蛋
        if(memo[k][n] != -666) return memo[k][n];
        int res = Integer.MAX_VALUE;
        // for(int i=1;i<=n;i++){ // 每一栋楼尝试
        //     res = Math.min(
        //         res,
        //         Math.max(dp(k, n-i), dp(k-1, i-1))+1 // 碎和没碎取最大值？最坏情况
        //     );
        // }
        int lo = 1, hi = n;
        while(lo <= hi){ // 二分找一次
            int mid = lo + (hi-lo)/2;
            int broken = dp(k-1, mid-1);
            int nbroken = dp(k, n-mid);
            if(broken > nbroken) {
                hi = mid-1;
                res = Math.min(res, broken+1);
            } else{
                lo = mid+1;
                res = Math.min(res, nbroken+1);
            }
        }
        memo[k][n] = res;
        return memo[k][n];
    }
}

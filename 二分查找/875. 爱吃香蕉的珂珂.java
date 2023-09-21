class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int lo = 1, hi = 0;
        for(int i=0;i<n;i++) {
            hi = Math.max(hi, piles[i]);
        }
        int res = -1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(count(piles, mid) <= (long)h) { // 吃的速度>=目标值
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return res;
    }
    public long count(int[] piles, int mid){
        long ans = 0;
        for(int i=0;i<piles.length;i++){
            ans += piles[i]/mid;
            if(piles[i]%mid!=0) ans++;
        }
        return ans;
    }
}

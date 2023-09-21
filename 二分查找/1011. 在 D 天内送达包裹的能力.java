class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;
        int lo=0, hi = 0;
        for(int i=0;i<n;i++) {
            lo = Math.max(lo, weights[i]);
            hi += weights[i];
        }
        int res = -1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(judge(weights, mid, days)){ // 运输能力强
                hi = mid - 1;
                res = mid;
            } else {
                lo = mid + 1;
            }
        }
        return res;
    }
    public boolean judge(int[] weights, int power, int days){
        int temp = 0;
        int count = 0;
        for(int i=0;i<weights.length;i++){
            temp+=weights[i];
            if(temp > power){
                temp = weights[i];
                count++;
            }
        }
        if(temp>0) count++;
        return count <= days;
    }
}

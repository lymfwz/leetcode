// 前缀和 + 二分查找 + Math.random() * pre[n] + 1
class Solution {
    int[] pre;
    public Solution(int[] w) {
        int n = w.length;
        pre = new int[n+1];
        for(int i=0;i<n;i++) pre[i+1] = pre[i] + w[i];
    }
    
    public int pickIndex() {
        int n = pre.length-1;
        int ra = (int) (Math.random() * pre[n] + 1);
        int lo = 1, hi = n;
        int res = -1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(pre[mid] >= ra){
                res = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return res - 1;
    }
}

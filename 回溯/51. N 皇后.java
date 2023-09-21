/*
使用位运算优化
*/
class Solution {
    int n;
    List<List<String>> res;
    int[] arr;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        this.n = n;
        arr = new int[n];
        int limit = n == 32 ? -1 : (1<<n)-1;
        backTrack(limit, 0, 0, 0, 0);
        return res;
    }
    public void addStr(){
        List<String> sub = new ArrayList<>();
        StringBuilder s = new StringBuilder();
        for(int i=0;i<n;i++) s.append(".");
        for(int i=0;i<n;i++){
            StringBuilder sb = new StringBuilder(s);
            int cur = arr[i];
            int idx = 0;
            while(cur!=0){
                if(cur==1) break;
                idx++;
                cur >>= 1;
            }
            sb.deleteCharAt(idx);
            sb.insert(idx, "Q");
            sub.add(sb.toString());
        }
        res.add(sub);
    }
    public void backTrack(int limit, int left, int cur, int right, int i){
        if(i == n){
            addStr();
            return;
        }
        int pos = limit & (~(cur | left | right));
        int rightmore = 0;
        while(pos!=0){
            rightmore = pos & (~pos + 1);
            pos -= rightmore;
            arr[i] = rightmore;
            backTrack(limit, (left | rightmore)<<1, (cur | rightmore), (right | rightmore)>>>1, i+1);
        }
    }
}

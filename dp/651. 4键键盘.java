// 动态规划
class Solution {
    public int maxA(int n) {
        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++){
            dp[i] = dp[i-1] + 1;
            for(int j=2;j<i;j++){ // dp[j-2] 表示 C V
                dp[i] = Math.max(dp[i], dp[j-2] * (i-j+1));
            }
        }
        return dp[n];
    }
}


// 备忘录 - 超时 n^3
class Solution {
    Map<String, Integer> map = new HashMap<>();
    public int maxA(int n) {
        // dp(n, num, copy);
        return dp(n, 0, 0);
    }
    public int dp(int n, int num, int copy){
        if(n <= 0) return num;
        String key = n+"_"+num+"_"+copy;
        if(map.containsKey(key)) return map.get(key);
        int res = Integer.MIN_VALUE;
        res = Math.max(res, dp(n-1, num+1, copy)); // A
        res = Math.max(res, dp(n-1, num+copy, copy)); // v
        res = Math.max(res, dp(n-2, num, num)); // C V
        map.put(key, res);
        return res;
    }
}

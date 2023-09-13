/*
从左到右降序的单调栈，从后往前遍历找到最长的表现良好的时间段
*/
class Solution {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        int[] pre = new int[n+1]; // 劳累的天数和
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int maxBest = 0;
        for(int i=0;i<n;i++){
            pre[i+1] = pre[i] + (hours[i] > 8 ? 1 : -1);
            if(pre[i+1] < pre[stack.peek()+1]){
                stack.push(i);
            }
        }
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && pre[i+1] > pre[stack.peek()+1]){
                maxBest = Math.max(maxBest, i - stack.pop());
            }
        }

        return maxBest;
    }
}

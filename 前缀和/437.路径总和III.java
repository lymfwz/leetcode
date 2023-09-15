/*
路径和满足了也不能直接return，继续遍历，后续可能有路径满足
*/
class Solution {
    int count = 0;
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null) return count;
        dp(root, targetSum);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return count;
    }
    public void dp(TreeNode root, long target){
        if(root == null) return;
        if(root.val == target) {
            count++;
        }
        dp(root.left, target - root.val);
        dp(root.right, target - root.val);
    }
}

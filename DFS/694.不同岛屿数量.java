/*
将岛屿按照固定顺序访问，然后序列化
*/
class Solution {
    public int numDistinctIslands(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Set<String> set = new HashSet<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    StringBuilder s1 = new StringBuilder();
                    dfs(grid, i, j, s1, 0);
                    set.add(s1.toString());
                }
            }
        }
        return set.size();
    }
    public void dfs(int[][] grid, int i, int j, StringBuilder sb, int dir){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0) {
            return;
        }
        grid[i][j] = 0;
        // 进层
        sb.append(dir).append(",");
        dfs(grid, i-1, j, sb, 1);
        dfs(grid, i+1, j, sb, 2);
        dfs(grid, i, j-1, sb, 3);
        dfs(grid, i, j+1, sb, 4);
        // 退层
        sb.append(-dir).append(",");
    }
}

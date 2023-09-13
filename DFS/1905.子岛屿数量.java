class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid1[i][j] == 0 && grid2[i][j] == 1){
                    dfs(grid2, i, j); // 取出非子集
                }
            }
        }
        int res = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid2[i][j] == 1){
                    res++;
                    dfs(grid2, i, j);
                }
            }
        }
        return res;
    }
    public void dfs(int[][] grid, int i, int j){
        if(i<0 || i>=grid.length || j<0 || j>=grid[0].length || grid[i][j] == 0){
            return;
        }
        grid[i][j] = 0;
        dfs(grid, i+1, j);
        dfs(grid, i, j+1);
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
    }
}

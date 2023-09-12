/*
先把边界岛屿淹掉，再统计即可。
*/
class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for(int i=0;i<n;i++){
            if(grid[0][i] == 0) dfs(grid, 0, i);
            if(grid[m-1][i] == 0) dfs(grid, m-1, i);
        }
        for(int i=0;i<m;i++){
            if(grid[i][0] == 0) dfs(grid, i, 0);
            if(grid[i][n-1] == 0) dfs(grid, i, n-1);
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0){
                    dfs(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }
    public void dfs(int[][] grid, int i, int j){
        if(i<0 || i>= grid.length || j<0 || j>=grid[0].length || grid[i][j]==1){
            return;
        }
        grid[i][j] = 1;
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
}

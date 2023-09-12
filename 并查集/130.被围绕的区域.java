/*
并查集 - 设置一个联通父节点 m*n
*/
class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        UnionFind uf = new UnionFind(m*n+1);
        int pa = m*n;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 || j==0 || i==m-1 || j == n-1){
                    if(board[i][j] == 'O'){
                        uf.union(i*n+j, m*n);
                    }
                }
                int cur = i*n + j;
                if(board[i][j] == 'O'){
                    if(i+1 < m && board[i+1][j] == 'O'){
                        uf.union(cur, (i+1)*n + j);
                    }
                    if(j+1 < n && board[i][j+1] == 'O'){
                        uf.union(cur, i*n + j+1);
                    }
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 'O' && !uf.connect(i*n+j, m*n)){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
class UnionFind{
    int[] fa;
    int[] rank;
    UnionFind(int m) {
        fa = new int[m];
        rank = new int[m];
        for (int i = 0; i < m; i++) {
            fa[i] = i;
            rank[i] = 1;
        }
    }

    int find(int x) {
        if (x == fa[x]) {
            return x;
        }
        return fa[x] = find(fa[x]);
    }

    boolean union(int i, int j) {
        i = find(i);
        j = find(j);
        if (i == j) {
            return false;
        }
        if (rank[i] > rank[j]) {
            fa[j] = i;
        } else {
            if(rank[i] == rank[j]) rank[j]++;
            fa[i] = j;
        }
        return true;
    }

    boolean connect(int i, int j){
        return find(i) == find(j);
    }
}

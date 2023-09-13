class Solution {
    public int minimumCost(int n, int[][] connections) {
        UnionFind uf = new UnionFind(n+1); //方便计算
        Arrays.sort(connections, (a,b)->a[2]-b[2]);
        int minCost = 0;
        for(int i=0;i<connections.length;i++){
            int[] c = connections[i];
            if(uf.union(c[0], c[1])){ // 连通
                minCost += c[2];
            }
        }
        for(int i=2;i<=n;i++){
            if(!uf.connect(1, i)){ // 一旦发现不连通，直接返回-1
                return -1;
            }
        }
        return minCost;
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

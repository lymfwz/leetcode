class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        UnionFind uf = new UnionFind(n);
        List<int[]> edges = new ArrayList<>();
        // 😃points每个点不相同，因此可以用i表示点
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                int xi = points[i][0], yi = points[i][1];
                int xj = points[j][0], yj = points[j][1];
                int dist = Math.abs(xi - xj) + Math.abs(yi - yj);
                edges.add(new int[]{i, j, dist});
            }
        }
        Collections.sort(edges, (a,b)->a[2]-b[2]);
        int minCost = 0;
        for(int[] e : edges){
            if(uf.union(e[0], e[1])){
                minCost += e[2];
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

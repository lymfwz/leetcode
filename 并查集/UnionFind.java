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


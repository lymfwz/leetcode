class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26);
        for(String s : equations){
            if(s.charAt(1) == '='){
                uf.union(s.charAt(0)-'a', s.charAt(3)-'a'); // 相等字母连通
            }
        }
        for(String s : equations){
            if(s.charAt(1) == '!'){
                if(uf.connect(s.charAt(0)-'a', s.charAt(3)-'a')){ // 不等字母连通直接返回false
                    return false;
                }
            }
        }
        return true;
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

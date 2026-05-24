class Solution {
    class UnionFind{
        public int[] parent;
        public int[] rank;
        int count;
        UnionFind(int n){
            parent = new int[n];
            rank = new int[n];
            for(int i = 0; i<n; i++){
                parent[i] = i;
            }
            count = n;
        }

        public int find(int x){
            if(parent[x]!=x){
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int a, int b){
            int rootA = find(a);
            int rootB = find(b);
            if(rootA == rootB)
                return;
            if(rank[rootA]<rank[rootB]){
                parent[rootA] = rootB;
            }
            else if(rank[rootA]>rank[rootB]){
                parent[rootB] = rootA;
            }
            else{
                parent[rootB] = rootA;
                rank[rootA]++;
            }
            count--;
        }
    }
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for(int[] edge: edges){
            uf.union(edge[0], edge[1]);
        }
        return uf.count;
    }
}

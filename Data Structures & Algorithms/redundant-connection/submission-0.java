class Solution {
     class UnionFind{
        int[] rank;
        int[] parent;

        UnionFind(int n){
            rank = new int[n];
            parent = new int[n];
            for(int i = 0; i<n; i++){
                parent[i] = i;
            }
        }

        public int find(int x){
            if(parent[x]!=x)
                parent[x] = find(parent[x]);
            return parent[x];
        }

        public boolean union(int x, int y){
            int px = find(x);
            int py = find(y);
            if(px == py)
                return false;

            if(rank[px]<rank[py])
                parent[px] = py;
            else if(rank[px]>rank[py])
                parent[py] = px;
            else{
                rank[px]++;
                parent[py] = px;
            }
            return true;
        }
    }

    public int[] findRedundantConnection(int[][] edges) {
        UnionFind find = new UnionFind(edges.length+1);
        for(int[] edge : edges){
            if(!find.union(edge[0], edge[1]))
                return edge;
        }
        return new int[]{};
    }
}

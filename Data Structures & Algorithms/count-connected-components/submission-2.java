class Solution {
    public int countComponents(int n, int[][] edges) {
        int parent[] = new int[n];
        int count = 0;
        for(int i = 0;i<n;i++){
            parent[i] = i;
        }
        for(int[] edge : edges){
            int node1 = edge[0];
            int node2 = edge[1];
            parent[node2] = parent[node1];
        }
        for(int i = 0;i<n;i++){
            if(parent[i] == i)
                count++;
        }
        return count;
    }
}

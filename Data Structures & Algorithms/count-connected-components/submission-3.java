class Solution {
    int res;
    public int countComponents(int n, int[][] edges) {
        res = n;
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] edge : edges){
            adj.computeIfAbsent(edge[0], k-> new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k-> new ArrayList<>()).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        for(Integer key : adj.keySet()){
            helper(adj, visited, key);
        }
        return res;
    }

    void helper(HashMap<Integer, List<Integer>> adj, Set<Integer> visited, int node){
        visited.add(node);
        List<Integer> neighbors = adj.get(node);
        for(Integer neighbor : neighbors){
            if(visited.contains(neighbor))
                continue;
            visited.add(neighbor);
            res--;
            helper(adj, visited, neighbor);
        }
    }
}

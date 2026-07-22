class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();
        for(int i = 0; i<n; i++)
            adj.put(i, new ArrayList<>());
        
        for(int[] edge : edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        Set<Integer> visited = new HashSet<>();
        if(hasCycle(0, adj, -1, visited))
            return false;

        return visited.size() == n;
    }

    public boolean hasCycle(int node, HashMap<Integer, List<Integer>> adj, int head, Set<Integer> visited){
        visited.add(node);

        for(int newNode : adj.get(node)){
            if(newNode == head)
                continue;
            
            if(visited.contains(newNode))
                return true;

            if(hasCycle(newNode, adj, node, visited))
                return true;
        }
        return false;
    }


}

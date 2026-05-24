class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        for(int[] edge : edges){
            adj.computeIfAbsent(edge[0], k->new ArrayList<>()).add(edge[1]);
            adj.computeIfAbsent(edge[1], k->new ArrayList<>()).add(edge[0]);
        }

        HashSet<Integer> visited = new HashSet<>();
        if(!helper(0, visited, adj, -1)){
            return false;
        }

        return visited.size() == n;
    }

    public boolean helper(int currNode, Set<Integer> visited, HashMap<Integer, List<Integer>> adj, int prevNode){
        visited.add(currNode);

        List<Integer> neighbors = adj.getOrDefault(currNode, new ArrayList<>());
        for(Integer neighbor : neighbors){
            if(neighbor == prevNode)
                continue;
            
            if(visited.contains(neighbor))
                return false;
            
            if(!helper(neighbor, visited, adj, currNode))
                return false;
        }

        return true;
    }
}

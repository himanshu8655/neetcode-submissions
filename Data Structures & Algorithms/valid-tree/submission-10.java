class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i<n; i++){
            map.put(i, new ArrayList<>());
        }
        for(int[] edge : edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        if(hasCycle(0, visited, map, -1))
            return false;
        
        return visited.size() == n ? true : false;
    
    }

    public boolean hasCycle(int node, Set<Integer> visited, Map<Integer, List<Integer>> map, int prevNode){
        
        visited.add(node);

        for(Integer newNode : map.get(node)){
            if(newNode == prevNode)
                continue;
            if(visited.contains(newNode))
                return true;

            if(hasCycle(newNode, visited, map, node))
                return true;
        }

        return false;
    }

}

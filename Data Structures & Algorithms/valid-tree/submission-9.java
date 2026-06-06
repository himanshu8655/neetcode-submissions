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
        if(hasCycle(0, -1, map, visited)){
            return false;
        }

        return visited.size() == n;
    }

    public boolean hasCycle(
        int node,
        int parent,
        Map<Integer, List<Integer>> map,
        Set<Integer> visited){
            visited.add(node);
            for(Integer neighbor : map.get(node)){
                if(parent == neighbor)
                    continue;
                if(visited.contains(neighbor))
                    return true;
                if(hasCycle(neighbor, node, map, visited))
                    return true;
            }

            return false;
    }
}

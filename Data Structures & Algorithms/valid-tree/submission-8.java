class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, ArrayList<Integer>> hmp = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        for(int i = 0; i<n; i++){
            hmp.put(i, new ArrayList<>());
        }
        for(int[] edge : edges){
            hmp.computeIfAbsent(edge[1], k->new ArrayList<Integer>()).add(edge[0]);
            hmp.computeIfAbsent(edge[0], k->new ArrayList<Integer>()).add(edge[1]);
        }
        if(!helper(0, -1, hmp, visited))
            return false;
        
        return visited.size() == n;
    }

    public boolean helper(
        int node, 
        int prevNode, 
        HashMap<Integer, ArrayList<Integer>> hmp,
        Set<Integer> visited
        ) {
            visited.add(node);
            for(Integer neighbor : hmp.get(node)){
                if(neighbor == prevNode)
                    continue;
                if(visited.contains(neighbor)){
                    return false;
                }
                if(!helper(neighbor, node, hmp, visited)){
                    return false;
                }
            }

            return true;
    }
}

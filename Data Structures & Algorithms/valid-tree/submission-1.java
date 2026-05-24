class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        //0 -> 1, 2, 3
        //1 -> 0, 4
        //2->0
        //3 -> 0
        for(int[] edge : edges){
            map.computeIfAbsent(edge[0], k->new ArrayList<>()).add(edge[1]);
            map.computeIfAbsent(edge[1], k->new ArrayList<>()).add(edge[0]);
        }

        HashSet<Integer> visited = new HashSet<>();
         if (!dfs(map, visited, 0, -1)) return false;

        return visited.size() == n;
    }

    public boolean dfs(HashMap<Integer, List<Integer>> map, Set<Integer> visited, int currNode, int prevNode){
        visited.add(currNode);
        List<Integer> neighbors = map.getOrDefault(currNode, new ArrayList<>());
        for(Integer num : neighbors){
            if(num == prevNode)
                continue;
            if (visited.contains(num)) return false;
            if(!dfs(map, visited, num, currNode))
                return false;
        }

        return true;
    }
}

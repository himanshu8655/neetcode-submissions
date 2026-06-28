class Solution {
    public int countComponents(int n, int[][] edges) {
        int result = 0;
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();

        for(int i = 0; i<n; i++){
            adjList.put(i, new ArrayList<>());
        }
        for(int[] edge : edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        HashSet<Integer> visited = new HashSet<>();
        for(int i = 0; i<n; i++){
            if(visited.contains(i))
                continue;
            dfs(i, visited, adjList);
            result++;
        }

        return result;
    }

    public void dfs(int i, HashSet<Integer> visited, Map<Integer, List<Integer>> adjList){
        visited.add(i);
        for(Integer newNode : adjList.get(i)){
            if(visited.contains(newNode))
                continue;
            dfs(newNode, visited, adjList);
        }
    }
}

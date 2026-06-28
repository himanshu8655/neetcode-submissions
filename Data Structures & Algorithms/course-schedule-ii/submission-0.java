class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, List<Integer>> hmp = new HashMap<>();
        int[] visited = new int[numCourses];

        for(int[] pre : prerequisites)
            hmp.computeIfAbsent(pre[0], lst->new ArrayList<Integer>()).add(pre[1]);
        
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, visited, hmp, res)) {
                return new int[] {};
            }
        }

        int[] ans = new int[numCourses];
        for(int i = 0; i<res.size(); i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
    public boolean dfs(int i, int[] visited, HashMap<Integer, List<Integer>> hmp, List<Integer> res){
        if(visited[i] == 1)
            return true;
        
        if(visited[i] == 2)
            return false;
        
        visited[i] = 2;
        for(Integer val : hmp.getOrDefault(i,new ArrayList<Integer>())){
            if(dfs(val, visited, hmp, res) == false){
                return false;
            } 
        }
        visited[i] = 1;
        res.add(i);
        return true;
    }
}
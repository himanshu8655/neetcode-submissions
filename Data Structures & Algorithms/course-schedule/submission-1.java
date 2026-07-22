class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i<numCourses; i++){
            map.put(i, new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            map.get(pre[0]).add(pre[1]);
        }

        int[] visited = new int[numCourses];

        for(int i = 0; i<numCourses; i++){
            if(hasCycle(visited, map, i))
                return false;
        }

        return true;
    }

    public boolean hasCycle(int[] visited, HashMap<Integer, List<Integer>> map, int i){
        if(visited[i] == 1)
            return true;
        
        if(visited[i] == 2)
            return false;

        visited[i] = 1;

        for(int num : map.get(i)){
            if(hasCycle(visited, map, num)){
                return true;
            }
        }
        visited[i] = 2;
        return false;

    }
}

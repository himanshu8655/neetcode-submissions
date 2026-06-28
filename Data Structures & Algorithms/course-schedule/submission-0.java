class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        
        for(int i = 0; i<numCourses; i++){
            adjList.put(i, new ArrayList<Integer>());
        }

        for(int[] pre : prerequisites){
            adjList.get(pre[0]).add(pre[1]);
        }

        int[] visited = new int[numCourses];
        for(int i = 0; i<numCourses; i++){
            if(hasCycle(visited, adjList, i))
                return false;
        }

        return true;
    }

    public boolean hasCycle(int[] visited, HashMap<Integer, List<Integer>> adjList, int course){
        if(visited[course] == 1)
            return true;
        if(visited[course] == 2)
            return false;

        visited[course] = 1;

        for(Integer newCourse : adjList.get(course)){
            if(visited[newCourse] == 1)
                return true;
            if(hasCycle(visited, adjList, newCourse))
                return true;
        }

        visited[course] = 2;
        return false;
    }
}

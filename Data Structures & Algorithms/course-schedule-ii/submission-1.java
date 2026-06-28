class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> adjList = new HashMap<>();
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i<numCourses; i++){
            adjList.put(i, new ArrayList<Integer>());
        }

        for(int[] pre : prerequisites){
            adjList.get(pre[0]).add(pre[1]);
        }

        int[] visited = new int[numCourses];
        for(int i = 0; i<numCourses; i++){
            if(hasCycle(visited, adjList, i, res))
                return new int[]{};
        }
        int[] intArray = new int[res.size()];

        // Manually copy elements (Java handles unboxing automatically)
        for (int i = 0; i < res.size(); i++) {
            intArray[i] = res.get(i);
        }

        return intArray;
    }

    public boolean hasCycle(int[] visited, HashMap<Integer, List<Integer>> adjList, int course, List<Integer> res){
        if(visited[course] == 1)
            return true;
        if(visited[course] == 2)
            return false;

        visited[course] = 1;

        for(Integer newCourse : adjList.get(course)){
            if(visited[newCourse] == 1)
                return true;
            if(hasCycle(visited, adjList, newCourse, res))
                return true;
        }

        visited[course] = 2;
        res.add(course);
        return false;
    }
}
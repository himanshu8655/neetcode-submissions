class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Set<String> pacificVisited = new HashSet<>();
        Set<String> atlanticVisited = new HashSet<>();
        List<List<Integer>> result  = new ArrayList<>();
        for(int i = 0;  i<heights[0].length; i++){
            dfs(0,i,-1, pacificVisited, heights);
            dfs(heights.length-1, i, -1, atlanticVisited, heights);
        }

        for(int i = 0;  i<heights.length; i++){
            dfs(i,0, -1, pacificVisited, heights);
            dfs(0, heights[0].length-1, -1, atlanticVisited, heights);
        }

        for(int i = 0; i<heights.length; i++)
            for(int j = 0; j<heights[0].length; j++){
                if(atlanticVisited.contains(i + "%" + j) && pacificVisited.contains(i + "%" + j))
                result.add(new ArrayList<>(Arrays.asList(i,j)));
            }

            return result;
    }

    public void dfs(int i, int j, int prev, Set<String> visited, int[][] heights){
        if(i<0 || j<0 || i>=heights.length || j>=heights[0].length ||
        visited.contains(i + "%" + j) || heights[i][j]<prev){
            return;
        }

        visited.add(i + "%" + j);
        dfs(i, j+1, heights[i][j], visited, heights);
        dfs(i+1, j, heights[i][j], visited, heights);
        dfs(i, j-1, heights[i][j], visited, heights);
        dfs(i-1, j, heights[i][j], visited, heights);
        
    }
}

class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i<grid.length; i++)
        for(int j = 0; j<grid[i].length; j++){
            int no = grid[i][j];
            if(no == 0)
            queue.add(new int[]{i,j});
        }
        
        while(!queue.isEmpty()){
            int[] pair = queue.poll();
            int[][] dir = {{1,0}, {-1, 0}, {0,1}, {0, -1}};
            for(int[] d : dir){
                int new_col = pair[1]+d[1];
                int new_row = pair[0]+d[0];
                if(new_row<0 || new_col<0 || new_row>=grid.length || new_col>=grid[0].length || grid[new_row][new_col]!=Integer.MAX_VALUE)
                    continue;
                grid[new_row][new_col] = grid[pair[0]][pair[1]]+1;
                queue.add(new int[]{new_row, new_col});
            
            }
        }
    }
}

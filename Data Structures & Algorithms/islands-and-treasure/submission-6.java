class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<String> queue = new LinkedList<>();
        for(int i = 0; i<grid.length; i++){
            for(int j = 0; j<grid[0].length; j++){
                if(grid[i][j] == 0)
                    queue.add(i +"%"+j);
            }
        }
        int itr = 0;
        while(!queue.isEmpty()){
            int n = queue.size();
            
            itr++;
            for(int k = 0; k<n; k++){
                String[] cellKey = queue.poll().split("%");
            int i = Integer.parseInt(cellKey[0]);
            int j = Integer.parseInt(cellKey[1]);
            if(i<0 || j<0 || i>=grid.length || j>=grid[0].length)
                continue;
                if(j-1>=0 && grid[i][j-1] == Integer.MAX_VALUE){
                    grid[i][j-1] = itr;
                    queue.add(i + "%" + (j-1));
                }

                if(j+1<grid[0].length && grid[i][j+1] == Integer.MAX_VALUE){
                    grid[i][j+1] = itr;
                    queue.add(i + "%" + (j+1));
                }
                    

                if(i-1>=0 && grid[i-1][j] == Integer.MAX_VALUE){
                    grid[i-1][j] = itr;
                    queue.add(i-1 + "%" + j );
                }
                    

                if(i+1<grid.length && grid[i+1][j] == Integer.MAX_VALUE){
                    grid[i+1][j] = itr;
                    queue.add(i+1 + "%" + j);
                }
                    
            }
        }
    }
}

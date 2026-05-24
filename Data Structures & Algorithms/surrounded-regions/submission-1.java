class Solution {
    public void solve(char[][] board) {
        Set<String> visited = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i<m; i++){
            dfs(i,0,board, visited);
            dfs(i,n-1,board, visited);
        }

        for(int i = 0; i<n; i++){
            dfs(0,i,board, visited);
            dfs(m-1,i,board, visited);
        }

        for(int i = 0; i<board.length; i++)
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j]=='O')
                    board[i][j]='X';
            }
        
           for(int i = 0; i<board.length; i++)
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j]=='T')
                    board[i][j]='O';
            }
    }

    public void dfs(int i, int j, char[][] board, Set<String> visited){
        if(i<0 || j<0 || i>=board.length || j>=board[i].length || board[i][j]!='O' || visited.contains(encrypt(i,j)))
            return;
        
        board[i][j] = 'T';
        visited.add(encrypt(i,j));
        dfs(i-1,j,board, visited);
        dfs(i+1,j,board,  visited);
        dfs(i,j+1,board,  visited);
        dfs(i,j-1,board,  visited);
    }

    public String encrypt(int i, int j){
        return i+"%"+j;
    }
}

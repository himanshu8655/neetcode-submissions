class Solution {
    public void solve(char[][] board) {
        for(int i = 0; i<board[0].length; i++){
            helper(board, 0, i);
            helper(board, board.length-1, i);
        }

        for(int i = 0; i<board.length; i++){
            helper(board, i, 0);
            helper(board, i, board[0].length-1);
        }

        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j] == 'O')
                    board[i][j] = 'X';
                if(board[i][j] == 'T')
                    board[i][j] = 'O';
            }
        }

    }

    public void helper(char[][] board, int i, int j){
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] != 'O')
            return;
        
        board[i][j] = 'T';
        helper(board, i+1, j);
        helper(board, i-1, j);
        helper(board, i, j+1);
        helper(board, i, j-1);
    }
}

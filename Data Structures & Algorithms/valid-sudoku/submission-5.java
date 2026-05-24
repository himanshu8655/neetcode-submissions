class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> suduko = new HashSet<>();

        for(int i = 0; i<board.length; i++)
            for(int j = 0; j<board[0].length; j++){
                char c = board[i][j];
                if(c == '.')
                    continue;
                boolean row = suduko.add("row "+i + " :" + c);
                boolean col = suduko.add("col "+j + " :" + c);
                boolean box = suduko.add("box at row: " + i/3 + "col :" + j/3 + "val :" + c);
                if(!row || !col || !box)
                    return false;
            }
        
        return true;
    }
}

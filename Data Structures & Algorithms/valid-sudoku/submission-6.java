class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> suduko = new HashSet<>();

        for(int i = 0; i<board.length; i++)
            for(int j = 0; j<board[0].length; j++){
                char c = board[i][j];
                if(c == '.')
                    continue;
                boolean row = suduko.add(c + "at row: " + i);
                boolean col = suduko.add(c + "at col: " + j);
                boolean box = suduko.add(c + "at box : " +i/3 + " " + j/3);
                if(!row || !col || !box){
                    return false;
                }
            }
        return true;
    }
}

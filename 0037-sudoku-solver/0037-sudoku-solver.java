class Solution {
    public void solveSudoku(char[][] board) {
        helper(0, 0, board);
    }

  private boolean helper(int row, int col, char[][] board){
    if(row == 9) {
      return helper(0, col+1, board);
    }
    if (col == 9) {
      return true;
    }
      
    if(board[row][col] != '.'){
      return helper(row+1, col, board);
    }

    for(int k = 1; k <= 9; k++){
      char c = (char) (k+ '0');
      // if current value is valid for current cell
      if(areRowAndColumnsValid(row, col, board, c) 
          && isSubBoardValid(row, col, board, c)){
        board[row][col] = c;
        if(helper(row+1, col, board))
        return true;
        board[row][col] = '.';
      }
    }
      
    return false;
      
  }
    
    private boolean areRowAndColumnsValid(int i, int j, char[][] board, char c){
    for(int p = 0; p < 9; p++){
      if(board[i][p] == c) return false;
    }
    for(int p = 0; p < 9; p++){
      if(board[p][j] == c) return false;
    }

    return true;
  }

  private boolean isSubBoardValid(int i, int j, char[][] board, char c){
    int br = (i/3) * 3;
    int bc = (j/3) * 3;
    for(int x = 0; x < 3; x++){
      for(int y = 0; y < 3; y++){
        if(board[x + br][y + bc] == c) return false;
      }
    }
    return true;
  }
    
}
class Solution {
    fun solveSudoku(board: Array<CharArray>): Unit {
        helper(board, 0, 0);
    }
    
    private fun helper(board: Array<CharArray>, r : Int, c : Int) : Boolean {
        if(c == 9){
            return helper(board, r+1, 0)
        }
        if(r == 9){
            return true   
        }
        if(board[r][c] != '.'){
            return helper(board, r, c+1)
        }
        
        for(k in '1'..'9'){
            if(isValid(board, r, c, k)){
                board[r][c] = k
                if(!helper(board, r,c+1)){ // backtracking
                    board[r][c] = '.'
                }else{
                    return true // missing this initially
                }
            }
        }
        return false
    }
    
    private fun isValid(board : Array<CharArray>, r: Int, c: Int, k: Char) : Boolean {
        if(k in board[r]) return false
        for(i in 0..8){
            if(k == board[i][c]) return false
        }
        
        val row = (r/3)*3
        val col = (c/3)*3
        for(i in 0..2){
            for(j in 0..2){
                if(k == board[i+row][j+col]) return false
            }
        }
        
        return true
    }
    
}
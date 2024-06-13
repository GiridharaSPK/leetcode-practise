class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rowMaps = Array(9){ HashSet<Char>() };
        val colMaps = Array(9){ HashSet<Char>() };
        val sqMaps = Array(3) { Array(3) { HashSet<Char>() }};
        for(r in 0..8){
            for(c in 0..8){
                val curr = board[r][c]
                if(curr == '.') continue
                if(rowMaps[r].contains(curr) 
                   || colMaps[c].contains(curr)
                   || sqMaps[r/3][c/3].contains(curr)){
                    return false
                }
                rowMaps[r].add(curr)
                colMaps[c].add(curr)
                sqMaps[r/3][c/3].add(curr)
            }
        }
        return true
    }
}
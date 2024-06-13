class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rowSet = new HashSet[9];
        HashSet<Character>[] colSet = new HashSet[9];
        HashSet<Character>[][] sqSet = new HashSet[3][3];
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                char curr = board[i][j];
                if(curr == '.') continue;
                
                if(rowSet[i] == null){
                    rowSet[i] = new HashSet<Character>();
                }
                if(colSet[j] == null){
                    colSet[j] = new HashSet<Character>();
                }
                if(sqSet[i/3][j/3] == null){
                    sqSet[i/3][j/3] = new HashSet<Character>();
                }
                if(rowSet[i].contains(curr)
                  || colSet[j].contains(curr)
                  || sqSet[i/3][j/3].contains(curr)){
                    return false;
                }
                rowSet[i].add(curr);
                colSet[j].add(curr);
                sqSet[i/3][j/3].add(curr);
                
            }
        }
        return true;
    }
}
class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        if(m < 3 || n < 3) return;
        
        for(int i = 0; i < n; i++){
            dfs(board, m, n, 0, i,'O', 'V');
            dfs(board, m, n, m-1, i, 'O', 'V');
        }
        
        for(int i = 0; i < m; i++){
            dfs(board, m, n, i, 0, 'O', 'V');
            dfs(board, m, n, i, n-1, 'O', 'V');
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'O') board[i][j] = 'X';
                // dfs(board, m, n, i, j, 'O', 'X');
            }
        }
        
        for(int i = 0; i < m;i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 'V') board[i][j] = 'O';
                // dfs(board, m, n, i, j, 'V', 'O');
            }
        }
    }
    
    private void dfs(char[][] board, int m, int n, int r, int c, char first, char updated){
        if(board[r][c] == first){

            board[r][c] = updated;
            int[][] dir = {{-1,0},{0,1},{0,-1},{1,0}};

            for(int i = 0; i < 4; i++){
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];
                if(isSafe(nr, nc, m, n)){
                    dfs(board, m, n, nr, nc, first, updated);
                }
            }
        }
    }
    
    private boolean isSafe(int r, int c, int m, int n){
        return (r >= 0 && c >= 0 && r < m && c < n);
    }
}
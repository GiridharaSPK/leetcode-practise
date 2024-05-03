class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        for(int i = 0; i < m; i++){
            if(grid[i][0] == 0){
                dfs(grid, m, n, i, 0);
            }
            if(grid[i][n-1] == 0){
                dfs(grid, m, n, i, n-1);
            }
        }
        
        for(int i = 0; i < n; i++){
            if(grid[0][i] == 0){
                dfs(grid, m, n, 0, i);
            }
            if(grid[m-1][i] == 0){
                dfs(grid, m, n, m-1, i);
            }
        }
        
        int count = 0;
        
        for(int i = 0; i < m; i ++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 0){
                    count++;
                    dfs(grid, m, n, i, j);
                }
            }
        }
        return count;
    }
    
    private void dfs(int[][] grid, int m, int n, int r, int c){
        if(grid[r][c] == 1) return;
        grid[r][c] = 1;
        if(r-1 >= 0) dfs(grid, m, n, r-1, c);
        if(r+1 < m) dfs(grid, m, n, r+1, c);
        if(c-1 >= 0) dfs(grid, m, n, r, c-1);
        if(c+1 < n) dfs(grid, m, n, r, c+1);
        
    }
    
}
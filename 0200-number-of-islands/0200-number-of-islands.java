class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islandsCount = 0;
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n ; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    islandsCount++;
                    dfs(grid, visited, m, n, i, j);
                }
            }
        }
        return islandsCount;
    }
    
    private void dfs(char[][] grid, boolean[][] visited, 
                     int m, int n, int cr, int cc) {
        if(visited[cr][cc]) return;
        
        visited[cr][cc] = true;
        if(cr - 1 >= 0 && grid[cr-1][cc]=='1'){
            dfs(grid, visited, m, n, cr-1, cc);
        }
        if(cc - 1 >= 0 && grid[cr][cc-1]=='1'){
            dfs(grid, visited, m, n, cr, cc-1);
        }
        if(cr + 1 < m && grid[cr+1][cc]=='1'){
            dfs(grid, visited, m, n, cr+1, cc);
        }
        if(cc + 1 < n && grid[cr][cc+1]=='1'){
            dfs(grid, visited, m, n, cr, cc+1);
        }
        return;
    }
}
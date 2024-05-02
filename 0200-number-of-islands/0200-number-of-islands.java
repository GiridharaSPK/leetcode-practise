class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int islandsCount = 0;
        boolean[][] visited = new boolean[m][n];
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    islandsCount++;
                    Queue<Point> q = new LinkedList<Point>(); 
                    q.add(new Point(i, j));
                    bfs(grid, visited, m, n, q);
                }
            }
        }
        
        /*for(int i = 0; i < m; i++){
            for(int j = 0; j < n ; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    islandsCount++;
                    dfs(grid, visited, m, n, i, j);
                }
            }
        }*/
        return islandsCount;
    }
    
    private void bfs(char[][] grid, boolean[][] visited,
                     int m, int n, Queue<Point> q){
        while(!q.isEmpty()){
        
            Point curr = q.remove();
            if(!visited[curr.x][curr.y]){
                visited[curr.x][curr.y] = true;
                if(curr.x -1 >= 0 && grid[curr.x-1][curr.y] == '1'){
                    q.add(new Point(curr.x-1, curr.y));
                }
                if(curr.x +1 < m && grid[curr.x+1][curr.y] == '1'){
                    q.add(new Point(curr.x+1, curr.y));
                }
                if(curr.y-1 >= 0 && grid[curr.x][curr.y-1] == '1'){
                    q.add(new Point(curr.x, curr.y-1));
                }
                if(curr.y+1 < n && grid[curr.x][curr.y+1] == '1'){
                    q.add(new Point(curr.x, curr.y+1));
                }
            }
        }
        return;
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

class Point{
    int x;
    int y;
    
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
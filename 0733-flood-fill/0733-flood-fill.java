class Point{
    int x;
    int y;
    
    Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int fc = image[sr][sc]; //first color
        int m = image.length;
        int n = image[0].length;
        
        // * if the initial color is same as given color no need to dfs
        if(fc == color) return image; 
        
        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(sr, sc));
        bfs(image, m, n, q, color, fc);
        
        // dfs(image, sr, sc, m, n, color, fc);
        return image;
    }
    
    private void bfs(int[][] image, int m, int n, Queue<Point> q, int color, int fc){
        while(!q.isEmpty()){
            Point p = q.remove();
            if(image[p.x][p.y] != fc) continue; // already colored
            
            image[p.x][p.y] = color; // color
            int[][] dir = {{-1,0},{0,1},{0,-1},{1,0}};

            // traverse to surrounding nodes
            for(int k = 0; k < 4;k++){
                int nr = p.x + dir[k][0];
                int nc = p.y + dir[k][1];
                if(isSafe(nr, nc, m, n)) // check each node if valid to traverse
                    q.add(new Point(nr, nc));
            }
        }
    }
    
    private boolean isSafe(int r, int c, int m, int n){
        return r >=0 && r < m && c >= 0 && c < n;
    }
    
    private void dfs(int[][] image, int r, int c, int m, int n, int color, int fc){
        if(image[r][c] != fc) return; // already color changed from inital color to new color
        // can also add extra check if  '== color' (|| image[r][c] == color) - but appears redundant - this check is to see if it has to be colored
        
        image[r][c] = color;
        int[][] dir = {{-1,0}, {0, 1}, {1, 0}, {0, -1}};
        for(int k=0; k < 4; k++){
            int nr = r+dir[k][0];
            int nc = c+dir[k][1];
            if(isSafe(nr, nc, m, n)){
                dfs(image, nr, nc, m, n, color, fc);
            }
        }
        
        /*if(r+1 < m) dfs(image, r+1, c, m, n, color, fc);
        if(c+1 < n) dfs(image, r, c+1, m, n, color, fc);
        if(c-1 >= 0) dfs(image, r, c-1, m, n, color, fc);
        if(r-1 >= 0) dfs(image, r-1, c, m, n, color, fc);*/

    }
}

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int fc = image[sr][sc]; //first color
        int m = image.length;
        int n = image[0].length;
        
        if(fc == color) return image;
        
        dfs(image, sr, sc, m, n, color, fc);
        return image;
    }
    
    private boolean isSafe(int r, int c, int m, int n){
        return r >=0 && r < m && c >= 0 && c < n;
    }
    
    private void dfs(int[][] image, int r, int c, int m, int n, int color, int fc){
        if(image[r][c] != fc) return; // adding extra check if  '== color' (|| image[r][c] == color)
        
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

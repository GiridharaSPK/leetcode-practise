class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int fc = image[sr][sc];
        int m = image.length;
        int n = image[0].length;
        
        if(fc == color) return image;
        
        dfs(image, sr, sc, m, n, color, fc);
        return image;
    }
    
    private void dfs(int[][] image, int r, int c, int m, int n, int color, int fc){
        if(image[r][c] != fc) return;
        
        image[r][c] = color;
        if(r+1 < m) dfs(image, r+1, c, m, n, color, fc);
        if(c+1 < n) dfs(image, r, c+1, m, n, color, fc);
        if(c-1 >= 0) dfs(image, r, c-1, m, n, color, fc);
        if(r-1 >= 0) dfs(image, r-1, c, m, n, color, fc);

    }
}

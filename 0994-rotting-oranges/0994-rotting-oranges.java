class Solution {
    public int orangesRotting(int[][] grid) {
        // edge cases : 
        // all cannot rotten -> -1
        // no rotten -> -1
        // no fresh -> 0
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        HashSet<Point> rotten = new HashSet<Point>();
        Queue<Point> q = new LinkedList<Point>();
        int count = 0; // count of fresh oranges at the given minute
        int min = 0; // minutes
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                Point curr = new Point(i, j);
                if(grid[i][j] == 2){
                    rotten.add(curr);
                    q.offer(curr); // {0,0}
                }else if(grid[i][j]==1){
                    count++;
                }
            }
        }
        
        // no rotten oranges
        if(q.isEmpty()){
            // no fresh oranges - already solution
            if(count == 0){
                return 0;
            }
            // there are fresh oranges but no rotten oranges
            return -1;
        }

        while(!q.isEmpty()){
            int size = q.size();  // 1 -> 2
            while(size > 0){ // 2
                Point curr = q.poll();
                size--; 
                for(int[] d : dir){
                    int nr = curr.r + d[0];
                    int nc = curr.c + d[1];
                    Point next = new Point(nr, nc);
                    if(isValid(nr, nc, rows, cols) && !rotten.contains(next) && grid[nr][nc]==1){
                        count--;
                        q.offer(next);
                        rotten.add(next);
                    }
                }
            }
            if(size == 0 && !q.isEmpty()){
                min++; 
            }
        }
        if(count > 0){
            return -1;
        }
        
        return min;
    }
    
    private boolean isValid(int r, int c, int rows, int cols){
        return (r >= 0 && c >= 0 && r < rows && c < cols);
    }
    
    class Point{
        int r;
        int c;
        Point(int r, int c){
            this.r = r;
            this.c = c;
        }
        
        public int hashCode() {
            return 31 * r + 37 * c;
        }
        
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if(!(obj instanceof Point)){
                return false;
            }
            Point p = (Point) obj;
            return p.r == r && p.c == c;
        }
 
    }
    
}
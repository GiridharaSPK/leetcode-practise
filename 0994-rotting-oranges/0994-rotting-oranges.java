class Solution {
    public int orangesRotting(int[][] grid) {
        // edge cases : 
        // all cannot rotten -> -1
        // no rotten -> -1
        // no fresh -> 0
        
        int rows = grid.length;
        int cols = grid[0].length;
        
        int[][] dir = {{0,1},{1,0},{-1,0},{0,-1}};
        HashSet<int[]> rotten = new HashSet<int[]>();
        Queue<int[]> q = new LinkedList<int[]>();
        int count = 0; // count of fresh oranges at the given minute
        int min = 0; // minutes
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                int[] curr = {i, j};
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
                int[] curr = q.poll();
                size--; 
                for(int[] d : dir){
                    int nr = curr[0] + d[0];
                    int nc = curr[1] + d[1];
                    int[] next = {nr, nc};
                    if(isValid(nr, nc, rows, cols) 
                        && !rottenContains(rotten, next) 
                        && grid[nr][nc] == 1){
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
    
    private boolean rottenContains(HashSet<int[]> set, int[] pt){
        for(int[] curr : set){
            if(curr[0] == pt[0] && curr[1] == pt[1]) return true;
        }
        return false;
    }
    
    private boolean isValid(int r, int c, int rows, int cols){
        return (r >= 0 && c >= 0 && r < rows && c < cols);
    }
    
}
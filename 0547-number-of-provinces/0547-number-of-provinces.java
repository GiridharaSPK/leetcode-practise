class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                count++;   
                dfs(isConnected, n, i, visited);
            }
        }
        return count;
    }
    
    
    private void dfs(int[][] isConnected, int n, int i, boolean[] visited){
        if(visited[i]) {
            return;
        }
        visited[i] = true;
        for(int j = 0; j < n; j++){
            if(isConnected[i][j] == 1 && visited[j]==false){
                dfs(isConnected, n, j, visited);
            }
        }
        
        return;
    }
    
}
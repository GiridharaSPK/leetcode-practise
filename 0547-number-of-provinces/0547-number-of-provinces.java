class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        //bfs 
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                count++;   
                Queue<Integer> q = new LinkedList<Integer>();
                q.add(i);
                bfs(isConnected, n, visited, q);
            }
        }
        
        /* // dfs
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                count++;   
                dfs(isConnected, n, i, visited);
            }
        }*/
        return count;
    }
    
    private void bfs(int[][] isConnected, int n, boolean[] visited, Queue<Integer> q){
        int curr = q.remove();
        if(visited[curr]) return;
        
        visited[curr]=true;
        for(int i = 0; i < n; i++){
            if(isConnected[curr][i] == 1 && visited[i] == false){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            bfs(isConnected, n, visited, q);
        }
        
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
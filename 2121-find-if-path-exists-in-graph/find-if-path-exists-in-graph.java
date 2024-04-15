class Solution {
    
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination) return true;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<Integer>();
        
        //construct graph as adj list
        HashMap<Integer, List<Integer>> g = new HashMap();
        for(int i = 0 ;i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            g.computeIfAbsent(u, value -> new ArrayList<Integer>()).add(v);
            g.computeIfAbsent(v, value -> new ArrayList<Integer>()).add(u);

        }
        return dfs(n, g, source, destination, visited, q);
        
        /*int[][] graph = new int[n][n];
        for(int i = 0 ;i < edges.length; i++){
            graph[edges[i][0]][edges[i][1]] = 1;
            graph[edges[i][1]][edges[i][0]] = 1;
            if(graph[source][destination] == 1) return true;
        }
        
        return bfs(n, graph, source, destination, visited, q);
        //return dfs(n, graph, source, destination, visited);
        */
    }
    
     /* private boolean bfs(int n, HashMap<Integer, List<Integer>> g, 
                        int s, int d, boolean[] v, Queue<Integer> q){
        List<Integer> temp = g.get(s);
        v[s] = true;
        for(int i = 0; i < temp.size(); i++){
            if(!v[temp.get(i)]){
                if(temp.get(i) == d) return true;
                q.add(temp.get(i));
            }
        }
        if(q.isEmpty()) return false;
        boolean ans = bfs(n, g, q.remove(), d, v, q);
        if(ans) return true;
        return false;
    }*/
    
    private boolean dfs(int n, HashMap<Integer, List<Integer>> g, 
                        int s, int d, boolean[] v, Queue<Integer> q){
        if(s == d) return true;
        List<Integer> temp = g.get(s);
        v[s] = true;
        for(int i = 0; i < temp.size(); i++){
            int next = temp.get(i);
            if(!v[next]){
                if(next == d) return true;
                boolean ans = dfs(n, g, next, d, v, q);
                if(ans) return true;
            }
        }
        return false;
    }
    
    /* MLE 
    public boolean bfs(int n, int[][] g, int s, int d, boolean[] v, Queue<Integer> q){
        if(g[s][d] == 1) return true;
        v[s] = true;
        for(int i = 0; i < n; i++){
            if(!v[i] && g[s][i] == 1) {
                q.add(i);
            }
        }
        if(!q.isEmpty() && bfs(n, g, q.poll(), d, v, q)) return true;
        return false;
        
    }*/
    
    
    // Memory Limit Exceeded
   /* public boolean dfs(int n, int[][] g, int s, int d, boolean[] v){
        if(g[s][d]==1) return true;
        v[s] = true;
        for(int i = 0; i < n; i++){
            if(!v[i] && g[s][i] == 1){
                if(dfs(n, g, i, d, v)) return true;
            }
        }
        return false;
    }*/
}
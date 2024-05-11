class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap();
        HashSet<Integer> visited = new HashSet();
        HashSet<Integer> done = new HashSet();
        for(int i = 0; i < prerequisites.length; i++){
            graph.computeIfAbsent(
                prerequisites[i][0],  
                v -> new ArrayList()
            ).add(prerequisites[i][1]);
        }
        
        for(int i = 0; i < numCourses; i++){   
            boolean check = dfs(graph, i, visited);
            // boolean check = dfs(graph, i, visited, done);
            if(!check) return false;
        }
        return true;
    }
    
    private boolean dfs(HashMap<Integer, ArrayList<Integer>> graph, int i, 
                        HashSet<Integer> visited){
        if(visited.contains(i)){
           return false; 
        }
        if(graph.get(i) == null){
            return true;
        }
        visited.add(i);
        ArrayList<Integer> adj = graph.get(i);
        for(int j = 0; j < adj.size(); j++){
            boolean check = dfs(graph, adj.get(j), visited);
            if(!check) return false; 
        }
        visited.remove(i);
        graph.put(i, null);
        return true;
    }
    
   /* private boolean dfs(HashMap<Integer, ArrayList<Integer>> graph, int i, 
                        HashSet<Integer> visited, HashSet<Integer> done){
        if(visited.contains(i)){
           return false; 
        }
        if(done.contains(i) || (graph.get(i) == null)){
            return true;
        }
        done.add(i);
        visited.add(i);
        ArrayList<Integer> adj = graph.get(i);
        for(int j = 0; j < adj.size(); j++){
            boolean check = dfs(graph, adj.get(j), visited, done);
            if(!check) return false; 
        }
        visited.remove(i);
        return true;
    }*/
}
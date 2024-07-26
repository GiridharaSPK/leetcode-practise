class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // approach 1 (neetcode)
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap();
        HashSet<Integer> visited = new HashSet();

        // build graph
        for(int i = 0; i < prerequisites.length; i++){
            graph.computeIfAbsent(
                prerequisites[i][0],  
                v -> new ArrayList()
            ).add(prerequisites[i][1]);
        }

        // traverse each node - check if there is a cycle 
        // within each node's connected nodes using dfs
        for(int i = 0; i < numCourses; i++){   
            boolean check = dfs(graph, i, visited);
            // detected a cycle? return false
            if(!check) return false;
        }
        // no cycles, return true
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
        // visit each node and it's children
        visited.add(i);
        ArrayList<Integer> adj = graph.get(i);
        for(int j = 0; j < adj.size(); j++){
            boolean check = dfs(graph, adj.get(j), visited);
            if(!check) return false; 
        }
        // once visited current node and its connections, remove current node (backtracking)
        visited.remove(i);
        graph.put(i, null);
        return true;
    }
    
    // approach 2 (advanced approach covers course-schedule-ii)
    // have to traverse level wise
    // first, nodes with 0 indegree
    // then other nodes by reducing the dependent courses on each visit
    public boolean canFinish(int numCourses, int[][] prerequisites) {       
       
        ArrayList<Integer> visited = new ArrayList<Integer>();
        int[] indegree = new int[numCourses];
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<Integer, ArrayList<Integer>> ();
        
        // buildGraph
        // track indegree
        for(int i = 0; i < numCourses; i++){
            graph.put(i, new ArrayList<Integer>());
        }
        for(int[] edge : prerequisites){
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }
        
        // traverse nodes with no dependencies
        for(int key : graph.keySet()){
            if(indegree[key] == 0){
                visited.add(key);
            }
        }
        
        // traverse dependent nodes by reducing indegree on each visit
        for(int i = 0; i < visited.size(); i++){
            ArrayList<Integer> nodes = graph.get(visited.get(i));
            for(int j = 0; j < nodes.size(); j++){
                indegree[nodes.get(j)]--;
                if(indegree[nodes.get(j)] == 0){
                    visited.add(nodes.get(j));
                }
            }
        }
        return visited.size() == numCourses; 
        // visited list is topologically sorted
    }
}

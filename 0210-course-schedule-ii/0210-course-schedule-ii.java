class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashSet<Integer> visiting = new HashSet();
        HashSet<Integer> visited = new HashSet();
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap();
        //converting to adj list
        for(int i = 0; i < prerequisites.length; i++){
            graph.computeIfAbsent(prerequisites[i][0], 
                v -> new ArrayList()).add(prerequisites[i][1]);    
        }
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for(int i = 0; i < numCourses; i++){
            boolean checkloop = dfs(graph, i, visited, visiting, ans);
            if(!checkloop){ // detected a loop
              return new int[0];  
            } 
        }
        
        int arr[] = new int[ans.size()];
        for(int j=0; j<ans.size(); j++){
          arr[j] = ans.get(j);
        }
        
        return arr;
    }
    
    private boolean dfs(
        HashMap<Integer, ArrayList<Integer>> graph, 
        int i, 
        HashSet<Integer> visited, 
        HashSet<Integer> visiting, 
        ArrayList<Integer> ans
    ){
        if(visiting.contains(i)){
            return false;
        }
        if(visited.contains(i)){ 
            return true;
        }
        visited.add(i);
        visiting.add(i);
        
        ArrayList<Integer> list = graph.get(i);
        if(list!=null){
            for(int j = 0; j < list.size(); j++){
                boolean checkloop = dfs(graph, list.get(j), visited, visiting, ans);
                if(!checkloop) return false;
            }
        }
        ans.add(i);
        visiting.remove(i);
        return true;
    }
}
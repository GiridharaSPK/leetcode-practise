class Solution {
    class Pair{
        int dist;
        int adjNode;
        
        Pair(int dist, int adjNode){
            this.dist = dist;
            this.adjNode = adjNode;
        }
    }
    
    public int networkDelayTime(int[][] times, int n, int k) {
        int ans = -1;
        int max = -1;
        int currentDist = 0;
        
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a, b) -> a.dist - b.dist);
        HashMap<Integer, ArrayList<Pair>> map = new HashMap<Integer, ArrayList<Pair>>();
        HashSet<Integer> visited = new HashSet<Integer>();
        
        //convert to adj list
        for(int i = 0; i < times.length; i++){
            map.computeIfAbsent(
                times[i][0], 
                v -> new ArrayList<Pair>()).add(new Pair(times[i][2], times[i][1])
           );
        }
        
        //add first element (k as given) to the heap
        pq.offer(new Pair(0, k));
        
        //iterate over heap until gets empty - O(V)
        while(!pq.isEmpty()){
            
            Pair temp = pq.poll();
            if(visited.contains(temp.adjNode)) continue;
            //visting first time 
            visited.add(temp.adjNode);
            
            currentDist = temp.dist; // distance travelled so far
            if(max < currentDist) max = currentDist; 
            // max distance from k - will be the answer when all nodes are connected
            
            // add to pq using bfs (cant use dfs because we cant track of distances or need a hashmap etc..)
            if(map.containsKey(temp.adjNode)){
                ArrayList<Pair> list = map.get(temp.adjNode);
                for(int i = 0; i < list.size(); i++){
                    temp = list.get(i);
                    // update distances of further nodes 
                    temp.dist += currentDist; // adding distance traversed until now to dists of all adj nodes
                    // (^^ cant use dfs)
                    pq.offer(temp);
                }
            }
        }
        
        if(visited.size() == n){
            ans = max;
        }
        
        return ans;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        if(points.length < 2) return 0;
        
        int cost = 0;
        int ans = 0;
        int node = 0; //start node
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        int[] temp = new int[2];
        temp[0] = cost;
        temp[1] = ans;
        pq.offer(temp);
        
        HashMap<Integer, ArrayList<int[]>> map = new HashMap();
        
        //building adj list
        for(int i = 0; i < points.length; i++){
            // ArrayList<Integer> list = new ArrayList();
            for(int j = i+1; j < points.length; j++){
                int dist = Math.abs(points[j][0] - points[i][0]) 
                    + Math.abs(points[j][1] - points[i][1]);
                int[] ar1 = new int[2];
                ar1[0] = dist;
                ar1[1] = j;
                // list.add(ar);
                map.computeIfAbsent(i, v -> new ArrayList<int[]>()).add(ar1);
                int[] ar2 = new int[2];
                ar2[0] = dist;
                ar2[1] = i;
                // list.add(ar);
                map.computeIfAbsent(j, v -> new ArrayList<int[]>()).add(ar2);
            }
        }
        
       
        HashSet<Integer> visited = new HashSet();
        while(!pq.isEmpty() && visited.size() < points.length){
            temp = pq.poll();
            cost = temp[0];
            node = temp[1];
            if(visited.contains(node)){
                continue;
            }
            visited.add(node);
            ans += cost;
            // add neighbors of node to pq
            ArrayList<int[]> list = map.get(node);
            for(int i = 0; i < list.size(); i++){
                pq.offer(list.get(i));
            }
        }
        
        return ans;
        
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // imp - edge case n=k
        // create a max heap
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)-> dist(b) - dist(a));
        for(int i = 0; i < points.length; i++){
            // add to pq
            // remove an element if pq.size > k
            // dont do, pq.size() == k
                // as we might miss a potential ans if the input is already sorted
            if(pq.size() > k){ 
                pq.poll();
            }
            int[] p = {points[i][0], points[i][1]};
            pq.add(p);
            // pq at any give point has a max of k+1 elements or less
        }
        if(pq.size() == k+1) // check size before removing (k+1)th element
            pq.poll();
        
        int[][] ans = new int[k][2];
        int i = 0;
        while(pq.size() > 0){
            int[] p = pq.poll();
            ans[i][0] = p[0];
            ans[i][1] = p[1];
            i++;
        }
        return ans;
    }
    
    private int dist(int[] p){
        return (int)(Math.pow(p[0],2)+ Math.pow(p[1],2));
    }
    
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // quick sort - quick select
        int low = 0;
        int high = points.length-1;
        while(low < high){
            int pivot = partition(points, low, high); //returns pivot index 
            // left of pivot all elements less than pivot
            if(pivot == k){
                break;
            }else if(pivot < k){
                low = pivot+1;
            }else{
                high = pivot-1;
            }
        }
        
        return Arrays.copyOfRange(points, 0, k);
        
        /* Priority Queue approach 56 ms
        // imp - edge case when n = k
        // edge case when pq.size() doesnt exceed k at any point
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
            pq.offer(points[i]);
            // pq at any give point has a max of k+1 elements or less
        }
        if(pq.size() == k+1) // imp - check size before removing (k+1)th element
            pq.poll();
        
        int[][] ans = new int[k][2];
        int i = 0;
        while(pq.size() > 0){
            int[] p = pq.poll();
            ans[i][0] = p[0];
            ans[i][1] = p[1];
            i++;
        }
        return ans;*/
    }
    
    private int partition(int[][] points, int low, int high){
        int[] pivot = points[high];
        int ptr = low;
        // distance from origin of ptr index point is less than pivot
        // swap the ithe position val with ptr 
        for(int i = low; i < high; i++){   
            if(isFirstPointerCloser(points[i], pivot)){
                int[] temp = points[i];
                points[i] = points[ptr];
                points[ptr] = temp;
                ptr++;
            }
        }
        // swap ptr and pivot i.e. high index
        int[] temp = points[ptr];
        points[ptr] = points[high];
        points[high] = temp;
        
        return ptr;
    }
    
    private int dist(int[] p){
        return (int)(Math.pow(p[0],2)+ Math.pow(p[1],2));
    }
    
    private boolean isFirstPointerCloser(int[] p1, int[] p2){
        return dist(p1) < dist(p2);
    }
    
}
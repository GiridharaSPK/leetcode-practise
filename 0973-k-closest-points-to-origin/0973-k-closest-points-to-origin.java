class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // imp - edge case n=k
        // create a max heap
        PriorityQueue<Point> pq = new PriorityQueue<Point>((a,b)-> dist(b) - dist(a));
        for(int i = 0; i < points.length; i++){
            // add to pq
            // remove an element if pq.size > k
            // dont do, pq.size() == k
                // as we might miss a potential ans if the input is already sorted
            if(pq.size() > k){ 
                pq.poll();
            }
            pq.add(new Point(points[i][0], points[i][1]));
            // pq at any give point has a max of k+1 elements
        }
        if(pq.size() == k+1) // check size before removing (k+1)th element
            pq.poll();
        
        int[][] ans = new int[k][2];
        int i = 0;
        while(pq.size() > 0){
            Point p = pq.poll();
            ans[i][0] = p.x;
            ans[i][1] = p.y;
            i++;
        }
        return ans;
    }
    
    private int dist(Point p){
        return (int)(Math.pow(p.x,2)+ Math.pow(p.y,2));
    }
    
    class Point{
        int x;
        int y;
        Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
}
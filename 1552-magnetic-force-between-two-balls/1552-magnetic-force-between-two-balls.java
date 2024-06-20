class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int n = position.length;
        
        // search for possible distances 
        // using binary search between 1 and n-1
        
        int left = 1; // min possible dist
        int right = position[n-1] - position[0]; // max possible dist
        int ans = -1;
        while(left <= right){
            int mid = left + (right-left)/2;
            if(isPossible(mid, position, m)){
                ans = mid;
                left = mid+1; // trying for larger gap
            }else{
                right = mid-1; // too high dist, reduce it
            }
        }
        return ans;
    }
    
    private boolean isPossible(int dist, int[] pos, int m){
        int last = pos[0]; // placed a ball at min pos
        m--;
        // place balls periodically or a next nearest bucket
        for(int i = 1; i < pos.length && m > 0; i++){
            if(pos[i] - last >= dist){
                m--;
                last = pos[i];
            }
        }
        return m == 0;
    }
    
}
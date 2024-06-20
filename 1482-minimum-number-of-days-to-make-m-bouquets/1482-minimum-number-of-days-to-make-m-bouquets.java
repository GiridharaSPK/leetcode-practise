class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        long n = bloomDay.length;
        if(n < (long) m * k) return -1;
        
        int max = bloomDay[0];
        int min = bloomDay[0];
        for(int i = 1; i < n; i++){
            if(max < bloomDay[i]) max = bloomDay[i];
            if(min > bloomDay[i]) min = bloomDay[i];
        }
        // linear search
        /*int day = min;
        while(day <= max){
            // check if we can make m bouquets today
            if(count(bloomDay, k, day) == m){
                return day;
            }
            day++;
        }*/
        
        // binary search
        int l = min;
        int r = max;
        int ans = max;
        while(l <= r){
            int mid = l + (r-l)/2;
            int temp = count(bloomDay, k, mid);
            if(temp == m){
                ans = mid;
                r = mid-1;
            }else if(temp < m){
                l = mid+1;
            }else if(temp > m){
                r = mid-1;
            }
        }
        
        return ans;
    }
    
    // returns number of bouquets can be made on current day
    private int count(int[] bloomDay, int k, int day){
        // single iteration to count
        int f = 0; // counts num of bloomed flowers
        int c = 0; // counts num of bouqets
        for(int i = 0; i < bloomDay.length; i++){
            if(bloomDay[i] <= day){
                f++;
            }else{
                c += f/k;
                f = 0;
            }
        } 
        c += f/k;
        
        return c;
        // sliding window to count
        // more complicated logic (takes time) 
        // (2 loops + breaking into chunks of k + traversing after a chunk + edge cases)
        // counting only for valid chunks
        // giving TLE probably because of O(n * k) 
        // avoid sliding window if iteration pass is possible
        // avoid dual loops (to handle less edge cases) if can be done with a single loop
        /*int l = 0;
        int r = 0;
        int count = 0;
        while(l < bloomDay.length){
            if(bloomDay[l] <= day){
                r = l;
                while(r < bloomDay.length && bloomDay[r] <= day){
                    if(r-l+1 == k){
                        l = r; // end of the current window (increments outside the 1st if)
                        count++;
                        break;
                    }
                    r++;
                }
                r = l+1;
            }
            l++;
        }
        return count;*/
    }
}
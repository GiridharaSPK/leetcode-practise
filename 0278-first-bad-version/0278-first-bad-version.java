/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        // test cases 
        // 1. empty
        // 2. 1 element (yes) and 2 elements (first is ans, second is ans)
        // 3. 5 elements -> ans at 1,2,3,4,5 
        
        if(n == 1) return 1;
        
        int first = 1;
        int last = n;
        int mid = 0;
        
        while(first < last){
            mid = first + (last-first)/2;
            if(isBadVersion(mid)){
                last = mid;
            }else{
                first = mid+1;
            }
        }
        return first; // always dont return mid - based on logic return first/mid/last
        
        // trying for more optimal approach - 100%
        // got 72.53%
        /*int first = 1;
        int last = n;
        int mid = 0;
        int ans = n;
        
        while(first <= last){
            mid = first + (last-first)/2;
            if(isBadVersion(mid)){
                last = mid-1;
                ans = mid;
            }else{
                first = mid+1;
            }
        }
        return ans; */
    
    }
}
class Solution {
    // ** binary search - every single +1 or -1, <=, <, >, >= is important 
    // ** always try to reduce search space by half
    // ** update boundaries every time i.e. start and end or high or low 
    // ** when updating boundaries think if mid can be answer or not thoroughly
    // ** (mid should get updated automatically every iteration)
    
    // test cases
    // 1 - 1 element 2 element arrays
    // single rotation
    // n-1 rotations
    // mid rotations - min is exactly at mid or pivot is at mid
    // all equal elements or duplicate elements
    
    public int findMin(int[] nums) {
        
        // ITERATIVE APPROACH  (striver and neetcode's)
        // maintain an ans var - update it each iteration
        int low = 0;
        int high = nums.length-1;
        int ans = nums[0];
        while(low <= high){
            int mid = low + (high-low)/2; 
            // main logic of search
            // we arent searching in a sorted side of the array but found a sorted one
            // so this would be the answer
            if(nums[low] <= nums[high]){
                ans = Math.min(ans, nums[low]);
                break;
            }
            // iterating - breaking search space into half and assuming min at each level
            if(nums[low] <= nums[mid]){ // sorted array low-mid search mid+1 to end
                low = mid+1;
                ans = Math.min(ans, nums[low]);
            }else{ // search between low - mid
                high = mid;
                ans = Math.min(ans, nums[mid]);
            }
        }
        return ans;
        
        // MISTAKE - do later
        // RECURSIVE APPROACH 1 - with a reference variable
        // int[] res = {nums[0]}; // returns answer // ** dont initialise with 0
        // return helper(nums, 0, nums.length-1, res);
        
        // MISTAKE - do later
        // RECURSIVE APPROACH 2 (** simplified recursive approach 1)
        // return helper(nums, 0, nums.length-1);
    }
    
    /*private int helper(int[] nums, int start, int end, int[] res){
        int mid = start + (end-start)/2;
        int n = end-start+1;
        if(start >= end) return nums[start];
        // ** if(nums[mid] < nums[(mid+1)%n] && nums[mid] < nums[(mid-1)%n]
        // ** unnecessary worry about +1 -1 %n etc. so ..
        // we can compare with start and end instead
        // as we are checking for smallest num
        if(nums[mid] < nums[(mid+1)%n] && nums[mid] < nums[(n+mid-1)%n]){
            res[0] = Math.min(res[0], nums[mid]);
        }
        if(nums[start] <= nums[mid])
            return helper(nums, mid+1, end, res);
        else if(nums[mid] < nums[end])
            return helper(nums, start, mid, res);
        else 
            // already sorted - rotated as many times as length of array
            return res[0];
    }
    
    private int helper(int[] nums, int start, int end){
        int mid = start + (end-start)/2;
        int n = end-start+1;
        // if(nums[mid] < nums[(mid+1)%n] && nums[mid] < nums[(mid-1)%n]
        // unnecessary worry about +1 -1 %n etc. so ..
        // we can compare with start and end instead
        // as we are checking for smallest num
        if(nums[mid] <= nums[(mid+1)%n] && nums[mid] <= nums[(mid-1)%n]){
            return nums[mid];
        }
        if(nums[start] <= nums[mid])
            return helper(nums, mid+1, end);
        else if(nums[mid] <= nums[end])
            return helper(nums, start, mid);
        else 
            // already sorted - rotated as many times as length of array
            return nums[0];
    }*/
    
}

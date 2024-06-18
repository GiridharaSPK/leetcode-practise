class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        // we have to find just 1 peak
        // so look for most probable peak from mid at every iteration
        // i.e. look for nums[mid] and nums[mid+1] and move towards a potential solution
        while(l < r){
            int mid = l + (r-l)/2;
            if(mid+1 < nums.length && nums[mid] < nums[mid+1]){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        return l;
        
        // Initially i chose to compare nums[mid], nums[mid-1]
        // where i have to handle and extra case of mid == 0 
        // and still giving TLEs for others cases
        // ** NOTE : if we have to handle extra cases like that, 
        // ** (hint)  we have to think of a different approach
        // it was also ambigous in chosing to update l or r with test cases
        
    }
}
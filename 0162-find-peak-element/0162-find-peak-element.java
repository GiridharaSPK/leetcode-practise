class Solution {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length-1;
        // we have to find just 1 peak
        // so look for most probable peak from mid at every iteration
        while(l < r){
            int mid = l + (r-l)/2;
            if(isPeak(nums, mid)) return mid;
            if(mid+1 < nums.length && nums[mid] < nums[mid+1]){
                l = mid+1;
            }else{
                r = mid;
            }
        }
        return l;
    }
    
    private boolean isPeak(int[] nums, int index){
        if(index + 1 <= nums.length && nums[index] < nums[index+1]){
            return false;
        }
        if(index - 1 >= 0 && nums[index] < nums[index-1]){
            return false;
        }
        return true;
    }
}
class Solution {
    public int search(int[] nums, int target) {
        int low = 0; 
        int high = nums.length-1;
        int mid = low; 
        // test case - 1 element, 2 element
        while(low < high){
            mid = low + (high-low)/2;
            if(nums[mid] == target){
                return mid;
            }
            // if(nums[low] < nums[mid])
            // ** IMP - low can be equal to mid at some iteration so make it '<='
            if(nums[low] <= nums[mid]){ 
                // left of mid - sorted 
                // IMP ** to search within sorted check both conditions
                // IMP ** target lies between mid and low 
                if(target < nums[mid] && target >= nums[low]){
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }else{
                // right of mid is sorted 
                // IMP ** to search within sorted check both conditions
                // IMP ** target lies between mid and high
                if(target > nums[mid] && target <= nums[high]){
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }
        // found element
        if(low < nums.length && nums[low] == target)
            return low;
        if(high >=0 && nums[high] == target)
            return high;
        
        // target not found
        return -1;
    }
}
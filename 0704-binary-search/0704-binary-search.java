class Solution {
    public int search(int[] nums, int target) {
        
        // test case
        // 1. no elments
        // 2. single element array (equals target and not equals)
        // 3. 2 element array (has target and not)
        // 4. target at mid / mid+1 /mid-1/ end/ start
        
        int n = nums.length;
        if(n == 0) return -1;
        
        int left = 0;
        int right = nums.length -1;
        
        while(left <= right){
            int mid = left + (right-left)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        
        return -1;
    }
}
class Solution {
    fun findPeakElement(nums: IntArray): Int {
        var l = 0
        var r = nums.size - 1
        // [1], [1,2], [2,1]
        // [1,3,2]
        // [1,2,3]
        // [3,2,1]
        // [1 3 4 2]
        // [1 4 3 2]

        // we have to find just 1 peak
        // so look for most probable peak from mid at every iteration
        // i.e. look for nums[mid] and nums[mid+1] and move towards a potential solution
        while(l < r){
            val mid = l + (r-l)/2
            if(nums[mid] > nums[mid+1]){
                r = mid
            }else{
                l = mid+1
            }
        }
        return l
        
        // Initially i chose to compare nums[mid], nums[mid-1]
        // where i have to handle and extra case of mid == 0 
        // and still giving TLEs for others cases
        // ** NOTE : if we have to handle extra cases like that, 
        // ** (hint)  we have to think of a different approach
        // it was also ambigous in chosing to update l or r with test cases
    }
}
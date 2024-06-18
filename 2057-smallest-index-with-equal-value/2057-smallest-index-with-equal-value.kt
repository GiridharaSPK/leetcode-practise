class Solution {
    fun smallestEqual(nums: IntArray): Int {
        for(i in nums.indices){
            if(nums[i] == i%10){
                return i;
            }
        }
        return -1;
    }
}
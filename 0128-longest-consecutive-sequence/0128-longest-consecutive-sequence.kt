class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        if(nums.size == 0) return 0
        
        val set = nums.toHashSet()
        
        var max = 1
        for(num in set){
            if(!set.contains(num-1)){
                var count = 1
                var curr = num
                while(set.contains(curr+1)){
                    count++
                    curr++
                }
                max = Math.max(count, max)
            }
        }
        
        return max
    }
}
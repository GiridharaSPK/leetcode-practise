class Solution {
    fun maximumLength(nums: IntArray): Int {
        for(i in 0..nums.size-1){
            nums[i] = nums[i]%2
        }
        
        var ans = 0
        var count = 0
        var bit = 0
        for(i in 0..nums.size-1){
            if(nums[i] == bit){
                bit = 1 - bit
                count++
            }
        }
        ans = Math.max(ans, count)

        count = 0
        bit = 1
        for(i in 0..nums.size-1){
            if(nums[i] == bit){
                bit = 1 - bit
                count++
            }
        }
        ans = Math.max(ans, count)

        count = 0
        bit = 0
        for(i in 0..nums.size-1){
            if(nums[i] == bit){
                count++
            }
        }
        ans = Math.max(ans, count) 
       
        count = 0
        bit = 1
        for(i in 0..nums.size-1){
            if(nums[i] == bit){
                count++
            }
        }
        ans = Math.max(ans, count)
        
        return ans
    }
}
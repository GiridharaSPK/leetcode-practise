class Solution {
    fun minKBitFlips(nums: IntArray, k: Int): Int {
        // optimised space from prev apporach (without using deque or queue)
        // O(n) time and constant space
        var count = 0
        var curr_window_count = 0
        var i = 0
        for(i in 0..nums.size-1){
            if(i >= k && nums[i-k] == 2){
                curr_window_count--
            }
            
            if((nums[i] + curr_window_count)%2==0){
                if(i + k > nums.size){
                    return -1
                }
                nums[i] = 2
                curr_window_count++
                count++
            }
        }
        return count
        
        // O(n) time O(k) space
        /*val q : Deque<Int> = LinkedList<Int>()// stores indices of flip positions
        var count = 0
        var i = 0
        while(i < nums.size){
            while(!q.isEmpty() && q.peekFirst() < i-k+1){
                q.pollFirst()
            }
            
            // if((nums[i] == 0 && q.size%2==0) || (nums[i]==1 && q.size%2==1)){
            if((nums[i] + q.size)%2==0){
                if(i + k > nums.size){
                    return -1 
                }
                count++
                q.offer(i)
            }
            i++;
        }
        return count*/
    }
}
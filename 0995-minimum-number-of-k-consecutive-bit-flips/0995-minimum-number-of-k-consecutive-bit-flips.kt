class Solution {
    fun minKBitFlips(nums: IntArray, k: Int): Int {
        
        val q : Deque<Int> = LinkedList<Int>()// stores indices of flip positions
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
        return count
    }
}
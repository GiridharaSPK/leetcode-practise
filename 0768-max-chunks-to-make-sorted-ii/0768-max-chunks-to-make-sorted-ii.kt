class Solution {
    fun maxChunksToSorted(arr: IntArray): Int {
        
        
        // pre computation approach
        val minArr = IntArray(arr.size) { ind -> arr[ind] }
        
        for(ind in arr.size-2 downTo 0){
            minArr[ind] = Math.min(minArr[ind+1], minArr[ind])
        }
        var max = Int.MIN_VALUE // max until now
        var count = 0
        for(i in arr.indices){
            if(arr[i] > max)
                max = arr[i]
            if(i+1< arr.size && max <= minArr[i+1]){ // max until now <= min from next
                count++
            }
        }
        return count+1  
    }
}
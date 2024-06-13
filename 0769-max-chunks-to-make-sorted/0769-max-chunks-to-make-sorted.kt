class Solution {
    fun maxChunksToSorted(arr: IntArray): Int {
        // if sorted - break into single elements
        // if not sorted - chunk
        var count = 0
// 2, 1, 6, 8, 9        
        for(i in arr.indices){
            var min = Int.MAX_VALUE
            var max = Int.MIN_VALUE
            for(j in arr.indices){
                // find max in left of i ()
                if(max < arr[j] && j <= i){
                    max = arr[j]
                }
                // find min in right of i
                if(min > arr[j] && j > i){
                    min = arr[j]
                }
            }
            if(min >= max){
                count++
            }
        }
        return count
    }
}


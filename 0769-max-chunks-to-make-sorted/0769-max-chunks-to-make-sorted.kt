class Solution {
    fun maxChunksToSorted(arr: IntArray): Int {
        // without O(n) space - given integers range from 0 to n-1 and unique
        // max until now should be equal to index - to chunk
        var max = arr[0]
        var count = 0
        for(i in arr.indices){
            if(max < arr[i]) max = arr[i]
            if(max == i) count++
        }
        return count
        
        // pre computation approach - O(n) space + O(n) time
        /*val minArr = IntArray(arr.size) { ind -> arr[ind] }
        // stores min from right to index
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
        return count+1 // (last chunk) */
        
        // brute force - O(n^2)
        // if sorted - break into single elements
        // if not sorted - chunk
        /*var count = 0
// 2, 1, 6, 8, 9        
        for(i in arr.indices){
            var min = Int.MAX_VALUE
            var max = Int.MIN_VALUE
            for(j in arr.indices){
                // find max in left of i (including i)
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
        return count*/
    }
}


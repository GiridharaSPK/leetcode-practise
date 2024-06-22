class Solution {
    fun maxSatisfied(customers: IntArray, grumpy: IntArray, minutes: Int): Int {
        // calculating initial happy customers
        var happy = 0
        for(i in customers.indices){
            if(grumpy[i] == 0){
                happy += customers[i]
            }
        }
        // sliding window - secret 
        var left = 0
        var right = 0 
        var max = 0
        while(right < customers.size){
            if(right - left + 1 > minutes){
                if(grumpy[left] == 1){
                    happy -= customers[left]
                }
                left++
            }
            if(grumpy[right] == 1){
                happy += customers[right]
            }
            right++
            
            if(max < happy) max = happy
        }
        return max
    }
}
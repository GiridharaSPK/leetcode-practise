class Solution {
    fun maximumTotalDamage(power: IntArray): Long {
        val freq = HashMap<Int, Int>();
        for(i in power){
            freq.put(i, freq.getOrDefault(i,0) + 1);
        }
        
        val uniquePowers = ArrayList<Int>(freq.keys)
        uniquePowers.sort()
        val n = uniquePowers.size
        val dp = LongArray(n)
        
        // first element /smallest element
        val e = uniquePowers.get(0)
        dp[0] = e * freq.get(e)!!.toLong()
        
        for(i in 1..n-1){
            // include only current element
            val curr = uniquePowers.get(i)
            var currSum: Long = curr * freq.get(curr)!!.toLong()
            var maxSum = currSum
            
            // check currentElement-1 and currentElement-2 
            if(i-1>=0 && uniquePowers.get(i-1) in curr-2..curr-1 && dp[i-1] > maxSum)
                maxSum = dp[i-1]
            
            if(i-2>=0 && uniquePowers.get(i-2) == curr-2 && dp[i-2] > maxSum)
                maxSum = dp[i-2]
            
            // include current element and elements lesser than e-2 if exists 
            var j = i
            while(j>=0 && uniquePowers.get(j) >= curr-2){
                j--
            }
            if(j>=0 && dp[j] + currSum > maxSum){
                maxSum = dp[j] + currSum
            }
            dp[i] = maxSum
        }
        
        return dp[n-1]
    }
}
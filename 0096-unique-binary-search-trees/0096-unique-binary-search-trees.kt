class Solution {
   
    fun numTrees(n: Int): Int {
        val dp = IntArray(n+1)
        dp[0] = 1
        dp[1] = 1

        for(j in 2..n){
            for(i in 1..j){
                dp[j] += dp[i-1] * dp[j-i]
            } 
        }
        return dp[n]
    }
}
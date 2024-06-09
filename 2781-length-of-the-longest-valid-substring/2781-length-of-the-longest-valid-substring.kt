class Solution {
    fun longestValidSubstring(word: String, forbidden: List<String>): Int {
        val set = HashSet<String>() // O(n) space complexity
        for(w in forbidden)
            set.add(w)
            
        val n = word.length
        var ans = 0

        var left = 0 // start valid substrings 
        for(i in 0..n-1){ // for each substring start with charAt(i)
            val maxCheck = Math.max(i-9, left) // check only with prev 10 chars - constraint
            // inner loop max is 10 iterations - constant time
            for(j in i downTo maxCheck){ 
                // for i = 20, checking substrings 19-20, 18-20, ... 11-20 for forbidden
                // unless a forbidden string is already in between (ex. at 12-15 -> check upto 13-20)
                // traverse in reverse - have to check for substring in increasing order of len and with i
                var cur = word.substring(j,i+1)
                if(set.contains(cur)){
                    left = j+1
                    break  // imp - if a substring contains break it
                }
            }
            ans = Math.max(ans, i-left+1)
        }
        
        return ans
        
    }
}
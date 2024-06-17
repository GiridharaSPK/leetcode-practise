
class Solution {
    fun judgeSquareSum(c: Int): Boolean {
        
        // approach 2 - Two pointer
        var l = 0
        var r = Math.sqrt(c.toDouble()).toInt()
        
        while(l <= r){
            val sum = l*l + r*r
            if(sum == c) return true
            
            // added sum < 0 for sum overflow cases
            if(sum > c || sum < 0) r--
            else l++
        }
        return false
        
        
        // approach 1 - Linear O(sqrt of c) - similar to Two Sum
        /*val set = HashSet<Int>()
        
        val root = Math.sqrt(c.toDouble()).toInt();
        for(i in 0..root){
            set.add(c - i*i);
            if(set.contains(i*i)) return true;
        }
        return false;*/
        
    }
}
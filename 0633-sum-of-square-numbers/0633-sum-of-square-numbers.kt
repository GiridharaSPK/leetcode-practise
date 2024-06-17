class Solution {
    fun judgeSquareSum(c: Int): Boolean {
        // approach 1 - Linear O(n) - similar to Two Sum
        val set = HashSet<Int>()
        
        val root = Math.sqrt(c.toDouble()).toInt();
        for(i in 0..root){
            set.add(c - i*i);
            if(set.contains(i*i)) return true;
        }
        return false;
        
    }
}
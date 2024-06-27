class Solution {

    fun lengthOfLongestSubstring(s: String): Int {
        var max = 0
        var l = 0
        var r = 0
        val map = HashMap<Char, Int>()
        while(r < s.length && l < s.length){
            val c = s[r]
            if(map.containsKey(c)){
                while(l < s.length && map.get(c) != l){
                    map.remove(s[l])
                    l++
                }
                l++
            }
            map.put(c, r)
            max = Math.max(max, r-l+1)
            r++
        }
        return max
    }
}
class Solution {
    fun minWindow(s: String, t: String): String {
        
        if(t.length > s.length) return ""
        
        var found = 0
        val map = hashMapOf<String, Int>();
        for(i in 0..t.length-1){
            val cs = t.substring(i,i+1)
            if(map.containsKey(cs)){
                map[cs] = map[cs]!! + 1
            }else{
                map[cs] = 1
                found++
            }
        }
        // O(m) TC + O(m) SC
        // map has required num of characters of each char
        
        var minLength = s.length+1
        var minStart = 0
        var minEnd = s.length-1

        var done = 0
        
        var l = 0
        var r = 0
        while(r < s.length){
            // increase substring length - move right pointer
            if(found > done){ 
                val cs = s.substring(r,r+1)
                // if found a req char, reduce count
                if(map.containsKey(cs)){ 
                    map[cs] = map[cs]!! - 1
                    // if found a req char completely(with freq match) 
                    if(map[cs] == 0){ 
                        // increase done counter
                        done++
                        // can check found==done and update minLength
                        // but do that in the left pointer iteration 
                        // which moves when found==done
                        // to find shorted length strings
                    }
                }
            }
            
            // decrease substring length - increase left using loop (not another if)
            while(l <= r && found == done){ 
                if(found == done && minLength > r-l+1){
                    minStart = l
                    minEnd = r
                    minLength = r-l+1 
                }
                val cs = s.substring(l,l+1)
                if(map.containsKey(cs)){
                    if(map[cs] == 0){
                        done--
                    }
                    map[cs] = map[cs]!! + 1
                }
                l++
            }
            
            // move right or increase right pointer further
            // to search for better substrings
            r++
        }
        
        // if not found any substring
        if(minLength > s.length) return ""
        
        return s.substring(minStart,minEnd+1)
    }
}
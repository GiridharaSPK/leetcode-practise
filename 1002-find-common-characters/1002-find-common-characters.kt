class Solution {
    fun commonChars(words: Array<String>): List<String> {
        val ans = ArrayList<String>();
        
        // approach with limited space - comparing only 2 words at once
        var i = 1;
        val commonMap = countCharacters(words[0])
        while(i < words.size){
            val map = countCharacters(words[i])
            for(k in commonMap.keys){
                commonMap[k] = Math.min(commonMap[k]!!, map[k] ?: 0)
            }
            i++;
        }
        
        for(letter in commonMap.keys){
            for(count in 1..commonMap[letter]!!)
                ans.add(letter)
        }
                
        // approach with lot of space - length of all strings 
        /*val wordMap = mutableMapOf<String, MutableMap<String, Int>>()
        // build wordMap
        for(word in words){
            wordMap[word] = countCharacters(word)
        }
        val firstWord = words[0]
        for(i in 0..firstWord.length-1){
            val cs = firstWord.substring(i,i+1)
            var flag = true
            for(word in wordMap.keys){
                if(!wordMap[word]!!.containsKey(cs)){
                    flag = false
                    break;
                }
            }
            // the current char string is prseent in all wordMap freqs
            if(flag){ 
                ans.add(cs)
                for(word in wordMap.keys){
                    val m = wordMap[word]!!
                    m[cs] = m[cs]!!.minus(1)
                    if(m[cs] == 0) {
                        m!!.remove(cs)
                    }
                }
            }
        }*/
        
        return ans
    }
    
    private fun countCharacters(word: String) : MutableMap<String, Int>{
        val map = mutableMapOf<String, Int>() // frequency
        
        for(i in 0..word.length-1){
            val cs = word.substring(i,i+1)
            map[cs] = map.getOrDefault(cs, 0)+1
        }
        
        return map
    }
}
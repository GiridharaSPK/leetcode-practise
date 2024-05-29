class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) return false;

        // approach without storing all chars of magazine
        int[] pos = new int[26]; // only 26 chars
        // stores positions of last found magazine char
        for(char c: ransomNote.toCharArray()){
            int index = magazine.indexOf(c, pos[c-'a']); 
            //returns first occurance after pos[c-'a'] position
            if(index == -1) return false;
            pos[c-'a'] = index + 1; // to search next time after the current index
        }
        return true;
        
        // approach using array for better performance
        // faster than 80.64%
        /*int[] ar = new int[26];
        for(char c : magazine.toCharArray()){
            ar[c-'a']++;
        }
        
        for(char c : ransomNote.toCharArray()){
            if(ar[c-'a'] <= 0) return false;
            ar[c-'a']--;
        }
        return true;*/
        
        // faster than 38%
        /*HashMap<Character, Integer> map = new HashMap<>();
        
        for(char c : magazine.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c,1);
            }
        }
        
        for(char c : ransomNote.toCharArray()){
            if(map.containsKey(c) && map.get(c) > 0){
                map.put(c, map.get(c)-1);
            }else{
                return false;
            }
        }
        
        return true;*/
    }
}
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // approach using array for better performance
        int[] ar = new int[26];
        for(char c : magazine.toCharArray()){
            ar[c-'a']++;
        }
        
        for(char c : ransomNote.toCharArray()){
            if(ar[c-'a'] <= 0) return false;
            ar[c-'a']--;
        }
        return true;
        
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
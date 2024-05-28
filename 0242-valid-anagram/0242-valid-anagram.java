class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.isEmpty() && t.isEmpty()) return true;
        if(s.length()!=t.length()) return false;
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c)+1);
            }else{
                map.put(c, 1);              
            }
        }
        
        for(int i = 0; i < t.length(); i++){
            char c = t.charAt(i);
            if(map.containsKey(c) && map.get(c) > 0){
                map.put(c, map.get(c)-1);
            }else{
                return false;            
            }
        }
        return true;
    }
}
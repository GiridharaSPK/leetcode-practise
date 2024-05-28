class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.isEmpty() && t.isEmpty()) return true;
        if(s.length()!=t.length()) return false;
        
        // using extra space
        /*HashMap<Character, Integer> map = new HashMap<Character, Integer>();
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
        return true;*/
        
        // without using extra space - sort the string
        /*String[] sc = s.split("");
        Arrays.sort(sc);
        String s1 = String.join("", sc);
        
        String[] tc = t.split("");
        Arrays.sort(tc);
        String t1 = String.join("", tc);*/
        
        char[] sc = s.toCharArray();
        Arrays.sort(sc);
        String s1 = String.valueOf(sc);
        
        char[] tc = t.toCharArray();
        Arrays.sort(tc);
        String t1 = String.valueOf(tc);
        
        return s1.equals(t1);
    }
}
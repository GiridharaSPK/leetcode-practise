class Solution {
    public boolean validPalindrome(String s) { 
        // test cases - "", "a", "abb", "abccb", "abcdba", "acbbda", "abcca", "abbca"
        if(s.isEmpty() || s.length() == 1) return true;

        int start = 0;
        int end = s.length()-1;
        int count = 0;
        
        // recursive apporoach faster than 99.71%
        return helper(s, start, end, true);   
        
        // iterative approach faster than 12.36%
        /*while(start < end){
            char cs = s.charAt(start);
            char ce = s.charAt(end);
            
            if(cs != ce){
                String ss1 = s.substring(start, end);
                if(ss1.equals(new StringBuilder(ss1).reverse().toString()))
                    return true;
                
                String ss2 = s.substring(start+1, end+1);
                if(ss2.equals(new StringBuilder(ss2).reverse().toString()))
                    return true;
                
                return false;    
            }
            start++;
            end--;
        }
        return true;*/
    }
    
    private boolean helper(String s, int start, int end, boolean flag){
        
        while(start < end){
            char cs = s.charAt(start);
            char ce = s.charAt(end);
            
            if(cs != ce){
                if(flag) // if flag is false dont go further
                    return helper(s, start+1, end, false) || helper(s, start, end-1, false);
                else 
                    return false;
            }
            start++;
            end--;
        }
        
        return true;
    }
}
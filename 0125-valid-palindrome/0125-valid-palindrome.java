class Solution {
    public boolean isPalindrome(String s) {
        // test cases
        //1 - only alphabets? should i ignore others
        //2 - empty string
        //3 - all non alphanumeric chars
        if(s.isEmpty()) return true;
        
        int start = 0;
        int last = s.length()-1;
        
        // approch 1: with single while loop
        // doing only 1 thing in an iteration
            // either checking start and last ptrs if not valid and move ptrs to next chars
            // or comparing current chars for palindrome and move to next chars
            // in both cases moving only 1 step in 1 iteration
        while(last >= 0 && start < s.length() && last >= start){
            char cs = s.charAt(start);
            char cl = s.charAt(last);
            
            if(!Character.isLetterOrDigit(cs)){
                start++;
            }else if(!Character.isLetterOrDigit(cl)){
                last--;
            }else{
                if(Character.toLowerCase(cs) != Character.toLowerCase(cl)) 
                    return false;
                start++;
                last--;
            }
        }
        
        // approach 1 : with multiple while loops
        /**while(last >= start){
            // should be 'while' not 'if' - move to next character
            while(last >= 0){  //** cannot combine isLetter check and decrement 
                // can decrease to -ve inside this loop 
                // inner loop needs check 
                // make sure every loop ends correctly
                if(!Character.isLetter(s.charAt(last)) && !Character.isDigit(s.charAt(last)))
                    last--; 
                else break;
            }
            if(last < 0) break;
            while(start < s.length()){
                if(!Character.isLetter(s.charAt(start)) && !Character.isDigit(s.charAt(start)))
                    start++;
                else break;
            }
            if(start >= s.length()) break;
            if(Character.toLowerCase(s.charAt(last)) != Character.toLowerCase(s.charAt(start))) 
                return false;
            start++;
            last--;
        }*/

        return true;
    }
}
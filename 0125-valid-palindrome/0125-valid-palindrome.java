class Solution {
    public boolean isPalindrome(String s) {
        // test cases
        //1 - only alphabets? should i ignore others
        //2 - empty string
        if(s.isEmpty()) return true;
        
        int start = 0;
        int last = s.length()-1;
        
        // approch 1: with single while loop
        // doing only 1 thing in an iteration - (slower than approach 1)
            // either checking start and last ptrs if not valid and move ptrs to valid chars
            // or comparing chars for palindrome check and ** move to next
        /**while(last >= start){
            if(last < 0) break;
            if(start >= s.length()) break;
            if(!Character.isDigit(s.charAt(start)) && !Character.isLetter(s.charAt(start))){
                start++;
            }else if(!Character.isDigit(s.charAt(last)) && !Character.isLetter(s.charAt(last))){
                last--;
            }else{
                if(Character.toLowerCase(s.charAt(start)) 
                   != Character.toLowerCase(s.charAt(last))) 
                    return false;
                start++;
                last--;
            }
        }*/
        
        // approach 1 : with multiple while loops
        while(last >= start){
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
        }

        return true;
    }
}
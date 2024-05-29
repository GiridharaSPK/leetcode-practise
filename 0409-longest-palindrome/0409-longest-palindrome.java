class Solution {
    public int longestPalindrome(String s) {
        if(s.length() < 2) return s.length();
        
        // each char with even freq can be added to palindrome
        // each char with odd freq can be added freq-1 times
        // and finally 1 odd freq char
        
        int[] ar = new int[58];
        //26+6+26 (ASCII has 6 different chars between upper and lower case alphabet)
        
        for(char c: s.toCharArray()){
            ar[c-'A']++;
        }
        int ans = 0;
        boolean flag = false;// flag to check if there is atleast 1 freq char
        for(int i = 0; i < 58; i++){
            int val = ar[i];
            if(val%2==0){
                ans+=val;
            }else{
                flag = true;// has at least 1 odd
                ans+=val-1;
            }
        }
        if(flag) 
            ans+=1;
        return ans;
    }
}
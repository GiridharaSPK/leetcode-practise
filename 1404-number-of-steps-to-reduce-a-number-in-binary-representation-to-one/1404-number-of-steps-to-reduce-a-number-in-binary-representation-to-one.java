class Solution {
    public int numSteps(String s) {
        
        int l = s.length(); // 10001
        int count = 0;
        
        // approach with carry, no extra space -> O(n) time 
        int carry = 0;
        for(int i = l-1; i > 0 ; i--){
            // int temp = (Character.getNumericValue(s.charAt(i)) + carry)%2; // adding 1
            // if(temp == 1){ 
            if((carry == 0 && s.charAt(i) == '1') || (carry == 1 && s.charAt(i) == '0')){
                carry=1;
                count+=2; // add 1 and remove 0
            }else{
                count++; // remove 0 (even num case or part of addition case)
            }
        }
        if(carry == 1) // atleast 1 'add 1' step eventually it gets carried to 0th bit
            count++; // 0th bit have to be 1, if carry -> 10 and remove 0 else return count 
        
        return count;
        
        // O(n^2) time + O(n) space 
        /*char[] c = ("0"+s).toCharArray();
        for(int i = l; i > 1 ; i--){
            // check last bit
            // if 1, add 1 and count++ 
            // else direct count++ (remove zero is taken care by i--)
            if(c[i] == '1'){ 
                int j = i;
                while(c[j] == '1'){
                    c[j] = '0';
                    j--;
                }
                c[j] = '1';
                i++; // redoing the same index again after modification to '0'
            }
            count++; 
        }
        if(c[0] == '0' && c[1] == '1') return count;
        
        if(c[0] == '1' && c[1] == '0') count++;
        if(c[0] == '1' && c[1] == '1') count+=2;
        
        return count; */
    }
}
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int i = n-1;
        int carry = 1;
        while(i>=0 && carry == 1){
            digits[i] = digits[i]+carry;
            carry = digits[i]/10;
            digits[i] = digits[i]%10;
            i--;
        }
        if(carry == 1){
            int[] ans = new int[n+1];
            ans[0] = 1;
            for(int j = 1; j < n+1; j++){
                ans[j] = digits[j-1];
            }
            return ans;
        }else{
            return digits;
        }
    }
}
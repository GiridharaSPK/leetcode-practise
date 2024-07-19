import java.math.BigInteger;

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // first approach
        /*int i = n-1;
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
        }*/
        
        // more logical approach
        
        /*for(int i = n-1; i >= 0; i--){
            if(digits[i] == 9){
                digits[i] = 0;
            }else{
                digits[i]++;
                return digits;
            }
        }
        // only for all 9s case
        int[] ans = new int[n+1];
        ans[0] = 1;
        return ans;*/
        
        // apporach using BigInteger
        StringBuilder sb = new StringBuilder();
        for(int d : digits){
            sb.append(d);
        }
        
        BigInteger num = new BigInteger(sb.toString());
        String str = num.add(BigInteger.ONE).toString();
        
        char[] chars = str.toCharArray();
        int[] ans = new int[chars.length];
        for(int i = 0; i < chars.length; i++){
            ans[i] = chars[i] - '0';
        }
        return ans;
    }
}
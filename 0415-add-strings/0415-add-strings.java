class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length()-1;
        int j = num2.length()-1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        
        while(i>=0 && j>=0){
            int sum = Character.getNumericValue(num1.charAt(i)) + Character.getNumericValue(num2.charAt(j)) + carry;
            carry = sum/10;
            sb.append(sum%10);
            i--;
            j--;
        }
        while(i>=0){
            int sum = Character.getNumericValue(num1.charAt(i)) + carry;
            carry = sum/10;
            sb.append(sum%10);
            i--;
        }
        while(j>=0){
            int sum = Character.getNumericValue(num2.charAt(j)) + carry;
            carry = sum/10;
            sb.append(sum%10);
            j--;
        }
        if(carry>0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}
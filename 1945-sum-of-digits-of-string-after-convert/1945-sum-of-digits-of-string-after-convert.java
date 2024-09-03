class Solution {
    public int getLucky(String s, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            sb.append(s.charAt(i)-'a'+1);
        }
        String str = sb.toString();
        for(int i = 0; i < k; i++){
            str = String.valueOf(sumOfDigits(str));
        }
        return Integer.parseInt(str);
    }
    
    private int sumOfDigits(String str){
        int ans = 0;
        for(int i = 0; i < str.length(); i++){
            ans+= Character.getNumericValue(str.charAt(i));
        }
        return ans;
    }
    
}
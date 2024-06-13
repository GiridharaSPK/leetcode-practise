class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        
        char[] chars = s.toCharArray();
        long sum = 0;
        for(int i = chars.length-1; i >=0; i--){
            sum += shifts[i];
            long temp = (chars[i] - 'a' + sum)%26;
            chars[i] = (char) ((int)temp + 'a');
        }    
        
        return String.valueOf(chars);
    }
}
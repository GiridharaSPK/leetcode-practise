class Solution {
    public String firstPalindrome(String[] words) {
        for(int i = 0; i < words.length; i++){
            if(isPal(words[i])){
                return words[i];
            }
        }
        return "";
    }

    private boolean isPal(String word){
        return (word.equals(reverse(word)));
    }

    private String reverse(String word){
        StringBuilder sb = new StringBuilder();
        for(int i = word.length()-1; i >= 0; i--){
            sb.append(word.charAt(i));
        }
        return sb.toString();
    }
}
class Solution {
    public String addBinary(String a, String b) {
        if(a == "0") return b;
        if(b == "0") return a;
        
        char[] aa = a.toCharArray(); //array of a
        char[] ab = b.toCharArray(); // array of b
        int ap = aa.length-1;// a ptr
        int bp = ab.length-1;// b ptr
        
        String ans = "";
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(ap >= 0 || bp >= 0 || carry == 1){
            if(ap>=0){
                carry += aa[ap] - '0';
            }
            if(bp>=0){
                carry += ab[bp] - '0';
            }
            sb.append(carry%2);
            carry = carry/2;
            
            ap--;
            bp--;
        }
        return sb.reverse().toString();
    }
    
}
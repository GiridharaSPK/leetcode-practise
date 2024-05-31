class Solution {
    public int numSteps(String s) {
        
        int l = s.length();
        // 01101  
        // 01110
        // 0111
        // 01000
        // 0100
        // 010
        // 01
        int count = 0;
        char[] c = ("0"+s).toCharArray();
        for(int i = l; i > 1 ; i--){
            if(c[i] == '1'){
                c[i] = '0';
                int j = i-1;
                while(c[j] == '1'){
                    c[j] = '0';
                    j--;
                }
                c[j] = '1';
                i++;
            }
            count++;
        }
        if(c[0] == '0' && c[1] == '1') return count;
        
        if(c[0] == '1' && c[1] == '0') count++;
        if(c[0] == '1' && c[1] == '1') count+=2;
        
        return count;
    }
}
class Solution {
    public boolean judgeSquareSum(int c) {
        /*if(c < 3) return true;
        
        long l = 0;
        long r = c-1;
        
        while(l <= r){
            if(l*l + r*r == c){
                return true;
            }
            if(l*l + r*r < c){
                l++;
            }else{
                r--;
            }
        }
        
        return false;*/
        
        //O(n)
        HashSet<Integer> set = new HashSet<Integer>();
        
        for(int i = 0; i <= (int)Math.sqrt(c); i++){
            set.add(c - i*i);
            if(set.contains(i*i))
                return true;            
        }
        return false;
    }
}
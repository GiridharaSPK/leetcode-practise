class Solution {
    public boolean judgeSquareSum(int c) {
        // two pointer approach
        int l = 0;
        int r = (int)Math.sqrt(c);
        
        while(l <= r){
            long sum = l*l + r*r;
            if(sum == c){
                return true;
            }
            // to manage overflowed integers r--
            // sum of squares will never be -ve unless overflowed
            if(sum > c || sum < 0){
                r--;
            }else{
                l++;
            }
        }
        
        return false;
        
        //O(n)
        /*HashSet<Integer> set = new HashSet<Integer>();
        
        // for(int i = 0; i*i <= c; i++){ -> TLE - has to find sq at each iteration
        for(int i = 0; i <= (int) Math.sqrt(c); i++){
            set.add(c - i*i);
            if(set.contains(i*i))
                return true;            
        }
        return false;*/
    }
}
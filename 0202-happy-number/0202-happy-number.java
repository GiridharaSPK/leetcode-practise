class Solution {
    HashMap<Integer, Boolean> ans = new HashMap();
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        // to avoid endless looping maintain set
        return helper(n, set);
    }
    
    private boolean helper(int n, HashSet<Integer> set){
        if(n == 1) return true;
        if(set.contains(n)) return false;

        set.add(n);
        double d = 0;
        while(n > 0){
            d = d + Math.pow(n%10,2);
            n = n/10;
        }
        return helper((int)d, set);
    }
}
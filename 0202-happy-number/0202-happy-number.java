class Solution {
    public boolean isHappy(int n) {
        
        // approach 2: use Floyd's cycle finding algorithm - rabbit and hare approach
        int slow = n;
        int fast = slow; // start with next to make it enter the loop
        while(slow != 1){
            slow = next(slow);
            fast = next(next(fast));
            if(slow == fast) break;
        }
        return slow == 1;
        
        // approach 1: use recursion and set of visited nodes to detect cycle
        // to avoid endless looping maintain set
        /*HashSet<Integer> set = new HashSet<Integer>();
        return helper(n, set);*/
    }
    
    private int next(int n){
        double d = 0;
        while(n > 0){
            d = d + Math.pow(n%10,2);
            n = n/10;
        }
        return (int)d;
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
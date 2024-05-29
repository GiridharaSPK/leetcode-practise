class Solution {
    public boolean isHappy(int n) {
        
        // approach 3: use Floyd's cycle finding algorithm - rabbit and hare approach
        // start at same place
        int slow = n;
        int fast = slow;
        while(slow != 1){ // dont put slow!=fast in while because they both start same values
            slow = next(slow);
            fast = next(next(fast));
            if(slow == fast) break;
        }
        /*
        // approach 2: use Floyd's cycle finding algorithm - rabbit and hare approach
        // fast starts a little ahead of slow
        
        int slow = n;
        // starting fast 1 step ahead of slow - to make it enter the while loop
        int fast = next(n); 
        while(slow != 1 && slow!=fast){
            slow = next(slow);
            fast = next(next(fast));
            if(slow == fast) break;
        }
        */
        
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
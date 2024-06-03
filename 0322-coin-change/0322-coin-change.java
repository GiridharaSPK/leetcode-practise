class Solution {
    public int coinChange(int[] coins, int amount) {
        // dynamic programming
        int[] dp = new int[amount+1];
        Arrays.fill(dp, amount+1); // tried with int.MAX_VALUE some edge cases are failing
        dp[0] = 0;
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < coins.length; j++){
                if(i >= coins[j]){
                    dp[i] = Math.min(dp[i], dp[i-coins[j]]+1); 
                    // when adding 1 here, if dp is pre-filled with max_value 
                    // it can become -ve value
                    // which might affect dp[i] further calculations
                }
            }
        }
        int ans = dp[amount];
        // memoization
        /*int[] mem = new int[amount+1];
        Arrays.fill(mem, Integer.MAX_VALUE);
        int ans = helper(coins, amount, 0, mem);*/
        // recurive approach
        /*int ans = helper(coins, amount, 0);*/
        if(ans > amount) return -1;
        return ans;
    }
   
     private int helper(int[] coins, int amount, int count, int[] mem){
        if(amount < 0){ 
            return -1;
        }
        if(mem[amount] <= amount){
            return mem[amount];
        }
        if(amount == 0){ 
            return count;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){
            if(amount >= coins[i]){
                int temp = helper(coins, amount-coins[i], count+1, mem);
                if(temp == -1) 
                    break;
                if(temp < min){
                    min = temp;
                }
            }
        }
        mem[amount] = min;
        return min;
    }
    
    
    private int helper(int[] coins, int amount, int count){
        if(amount < 0){ 
            return -1;
        }
        if(amount == 0){ 
            return count;
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++){
            if(amount >= coins[i]){
                int temp = helper(coins, amount-coins[i], count+1);
                if(temp == -1) 
                    break;
                if(temp < min){
                    min = temp;
                }
            }
        }
        return min;
    }
}
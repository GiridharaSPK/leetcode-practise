class Solution {
    public int maxProfit(int[] prices) {
        // extension of sliding window - ** summation of all increments - no DP
        int n = prices.length;
        int total = 0;
        if(n < 2) return total;
        
        int left = 0;
        int right = 0;
        
        
        // add differences of max value and left for each upslope
        // while(right < n){
        //     int profit = 0;
        //     if(right < n-1 && prices[right] <= prices[right+1]){
        //         right++;
        //     }else{
        //         total = total + (prices[right] - prices[left]);
        //         left = right+1;
        //         right = left;
        //     }
        // }
        
        // add all increments ** 
        while(right+1 < n){
            if(prices[right] < prices[right+1]){
                total+= prices[right+1] - prices[right];
            }
            right++;
        }
        
        return total;
    }
    
    // trying using recursion/memoization - [TLE]
    /*public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] mem = new int[n][2];
        
        return helper(prices, 0, true, mem);
    }  
     
    private int helper(int[] prices, int ind, boolean canBuy, int[][] mem){
        if(ind >= prices.length) return 0;
        
        if(canBuy && mem[ind][1] > 0) return mem[ind][1];
        if(!canBuy && mem[ind][0] > 0) return mem[ind][0];
        
        if(canBuy){
            // can buy now
            mem[ind][1] = Math.max(
                - prices[ind] + helper(prices, ind+1, false, mem),
                0 + helper(prices, ind+1, true, mem)
            );
            return mem[ind][1];
        }else{
            // cant buy now
            mem[ind][0] = Math.max(
                prices[ind] + helper(prices, ind+1, true, mem), // sell now, buy next 
                0 + helper(prices, ind+1, false, mem) //skip now, sell next
            );
            return mem[ind][0];
         }
     }*/
         
    // trying using DP
    /*public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][2]; // [0 - sellnow or cantbuynow][1 - buynow]
        // all are 0s initially
        // traverse in reverse - nth index {0,0} is the profit 
            // dummy column to get started with reverse memoization
            // profit will be 0 when no stocks to be bought /sold in that stage 
        
        for(int i = n-1; i >= 0; i--){
            // cant buy now 
            dp[i][0] = Math.max( 
                prices[i] + dp[i+1][1], // sell (+ add curr to profit) and buy next
                0 + dp[i+1][0] // skip now (+ 0) and sell next
            );
            // can buy now
            dp[i][1] = Math.max( 
                -prices[i] + dp[i+1][0], // buy (+ add -curr to profit) and sell next
                0 + dp[i+1][1] // skip now (+ 0) and buy next
            );
        }
        
        return dp[0][1]; // need to return - 0th column and have to buy case
    }*/
    
    
}
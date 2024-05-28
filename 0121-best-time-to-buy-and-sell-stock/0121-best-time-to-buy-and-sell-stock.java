class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int max = 0;
        
        // approach 2: sliding window
        if(n < 2) return 0;
        
        int left = 0;
        int right = 1;
        
        while(right < n){
            if(prices[left] < prices[right]){
                if(max < prices[right] - prices[left]){
                    max = prices[right] - prices[left];
                }
                right++;
            }else{
                left = right;
                right = left+1;
            }
        }
        
        
        // approach 1: precompution of best sell + traversal for max profit
        // O(n) time + O(n) space
        // pre computation of max at each i
        /*int[] maxFromHere = new int[n];
        maxFromHere[n-1]= prices[n-1];
        for(int i = n-2; i >= 0; i--){
            maxFromHere[i] = Math.max(maxFromHere[i+1], prices[i]);
        }
        
        // traversing for max profit at each i
        for(int i= 0; i < n-1; i++){//left ptr
            int profit = maxFromHere[i] - prices[i];
            if(max < profit){
                max = profit;
            }
        }*/
        
        return max;
    }
}
class Solution {
    public int maxProfit(int[] prices) {
        // extension of sliding window - ** summation of all increments - no DP
        int n = prices.length;
        int total = 0;
        if(n < 2) return total;
        
        int left = 0;
        int right = 0;
        
        /* 
        // add differences of max value and left for each upslope
        while(right < n){
            int profit = 0;
            if(right < n-1 && prices[right] <= prices[right+1]){
                right++;
            }else{
                total = total + (prices[right] - prices[left]);
                left = right+1;
                right = left;
            }
        }*/
        
        // add all increments ** 
        while(right+1 < n){
            if(prices[right] < prices[right+1]){
                total+= prices[right+1] - prices[right];
            }
            right++;
        }
        
        return total;
    }
    
    
}
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] maxFromHere = new int[n];
        
        maxFromHere[n-1]= prices[n-1];
        for(int i = n-2; i >= 0; i--){
            maxFromHere[i] = Math.max(maxFromHere[i+1], prices[i]);
        }
        
        int max = 0;
        for(int i= 0; i < n-1; i++){//left ptr
            int profit = maxFromHere[i] - prices[i];
            if(max < profit){
                max = profit;
            }
        }
        return max;
    }
}
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        
        // striver's approach - calculate product from 2 sides reset at 0
        // we can get this idea by trying with a lot of test cases
        /*int maxProduct = Integer.MIN_VALUE;
        int pref_product = 1; // to keep track of products from left
        int suf_product = 1; //to keep track of products from right
        int i = 0;
        while(i < n){
            pref_product *= nums[i];
            suf_product *= nums[n-i-1];
            if(maxProduct < pref_product){
                maxProduct = pref_product;
            }
            if(maxProduct < suf_product){
                maxProduct = suf_product;
            }
            if(suf_product == 0){
                suf_product = 1;
            }
            if(pref_product == 0){ // resets if encountered 0
                pref_product = 1;
            }
            i++;
        }
        
        return maxProduct;*/
        
        //neetcode's approach - // slower than strivers, but more intuitive 
        // (modification of kadane's)
        // at 0s we reset the values 
        // to track negative products we need to maintain 2 products 
        // currMax and currMin 
        // currMin could exceed currMax if multiplied again with another num
        
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int i = 0;
        int currMax = 1;
        int currMin = 1;
        while(i < n){
            // storing them so that we compare values before updating each of them
            int temp1 = currMax*nums[i]; 
            int temp2 = currMin*nums[i];
            currMax = Math.max(Math.max(temp1, temp2), nums[i]); 
            // if temp is not used currMax gets updated for next step
            currMin = Math.min(Math.min(temp1, temp2), nums[i]);
            max = Math.max(max, currMax);
            min = Math.min(min, currMin);
            if(currMax == 0)
                currMax = 1;
            if(currMin == 0)
                currMin = 1;
            i++;
        }
        
        return max;
    }
}
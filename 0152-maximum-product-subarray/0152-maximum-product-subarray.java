class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int maxProduct = Integer.MIN_VALUE;
        
        // striver's approach - calculate product from 2 sides reset at 0
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
        return maxProduct;
    }
}
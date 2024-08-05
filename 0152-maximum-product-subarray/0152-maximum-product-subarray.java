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
        
        /*double min = Long.MAX_VALUE;
        double max = Long.MIN_VALUE;
        double currMax = 1;
        double currMin = 1;
        for(int i = 0; i < n; i++){
            // *** storing them so that we compare values before updating each of them
            double temp1 = currMax*nums[i]; 
            double temp2 = currMin*nums[i];
            currMax = Math.max(Math.max(temp1, temp2), nums[i]); 
            // if temp is not used currMax gets updated for next step
            currMin = Math.min(Math.min(temp1, temp2), nums[i]);
            max = Math.max(max, currMax);
            min = Math.min(min, currMin);
            
            // not required when we are storing max 
            // updated by comparing with current max seperately
            // if(currMax == 0)
            //     currMax = 1;
            // if(currMin == 0)
            //     currMin = 1;
        }
        
        return (int) max;*/
        
        // approach 3
        // traverse from both directions
        /*
        double leftProduct = 1;
        double rightProduct = 1;
        double max = nums[0];
        for(int i = 0; i < n; i++){            
            leftProduct *= nums[i];
            max = Math.max(max, leftProduct);
            rightProduct *= nums[n-i-1];
            max = Math.max(max, rightProduct);
            
            if(leftProduct == 0){
                leftProduct = 1;
            }
            if(rightProduct == 0){
                rightProduct = 1;
            }
        }
        return (int) max;*/
        
        // approach 4 - my approach during mock interview
        // over complicated version of approach 2
          boolean hasZero = false;
          double ans = Integer.MIN_VALUE;
          double max = 1; // current window max
          double min = 1;
          int p = 0;
          while(p < nums.length){
            if(nums[p] != 0){
              double temp = max;
              max = Math.max(nums[p], Math.max(nums[p]*max, nums[p]*min)); // 24*4
              min = Math.min(nums[p], Math.min(nums[p]*temp, nums[p]*min)); //
              ans = Math.max(ans, max);
            }else{
              // reset
              hasZero = true;
              max = 1;
              min = 1;
            }

            p++;
        }
      if(ans <= 0 && hasZero){
        return 0;
      }
      return (int)ans;
    
        
    }
}
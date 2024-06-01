class Solution {
    public int[] productExceptSelf(int[] nums) {
        
        
        // approach 1 - calculating totalProduct, productWithoutZeros, and num of zeros
        int zeroCount = 0;
        int product = 1;
        int pwz = 1; // product without zero
        int[] ans = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            product *= nums[i];
            if(nums[i]==0)
                zeroCount++;
            else
                pwz*=nums[i];
        }
        if(zeroCount == 1){
            Arrays.fill(ans, 0);
            for(int i = 0; i < nums.length; i++){  
                if(nums[i] == 0)
                    ans[i] = pwz;
            }
        }else{
            // multiple zeros or no zeros
            for(int i = 0; i < nums.length; i++){  
                if(nums[i]!=0)
                    ans[i] = product/nums[i];
                else 
                    ans[i] = 0;
            } 
        }
        
        return ans;
    }
}
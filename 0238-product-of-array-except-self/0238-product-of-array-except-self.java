class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        // approach 2 - prefix and suffix products
        int n = nums.length;
        int[] p = new int[n];
        int[] s = new int[n];
        p[0] = 1;
        s[n-1] = 1; 
        
        for(int i = 1; i < n; i++){
            p[i] = p[i-1]*nums[i-1];
            s[n-i-1] = s[n-i]*nums[n-i];
        }
        for(int i = 0; i < n; i++){
            ans[i] = p[i]*s[i];
        }
        
        // approach 1 - calculating totalProduct, productWithoutZeros, and num of zeros
        /*int zeroCount = 0;
        int product = 1;
        int pwz = 1; // product without zero
        
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
        }*/
        
        return ans;
    }
}
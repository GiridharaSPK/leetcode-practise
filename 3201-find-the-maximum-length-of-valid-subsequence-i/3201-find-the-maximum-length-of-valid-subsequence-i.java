class Solution {
    public int maximumLength(int[] nums) {
        if(nums.length == 2) return 2;
        
        for(int i = 0; i < nums.length; i++){
            nums[i] = nums[i]%2;
        }
        
        int ans = 0;
        int count = 0;
        int bit = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == bit){
                bit = 1-bit;
                count++;
            }
        }        
        ans = Math.max(ans, count);
        
        count = 0;
        bit = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == bit){
                bit = 1-bit;
                count++;
            }
        }        
        ans = Math.max(ans, count);
        
        count = 0;
        bit = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == bit){
                // bit = 1-bit;
                count++;
            }
        }        
        ans = Math.max(ans, count);

        count = 0;
        bit = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == bit){
                // bit = 1-bit;
                count++;
            }
        }        
        ans = Math.max(ans, count);
        return ans;
    }

}
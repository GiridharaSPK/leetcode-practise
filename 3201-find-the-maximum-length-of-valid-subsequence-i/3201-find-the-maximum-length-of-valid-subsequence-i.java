class Solution {
    public int maximumLength(int[] nums) {
        // simpler apporach
        int evenCount = 0;
        int oddCount = 0;
        int altCount = 0; // counts subsequences of alternating odd and even nums
        int bit = nums[0]%2;
        
        for(int i = 0; i < nums.length; i++){
            if(nums[i]%2 == 0){
                evenCount++;
            }
            if(nums[i]%2 != 0){
                oddCount++;
            }
            if(nums[i]%2 == bit){
                bit = 1-bit;
                altCount++;
            }
        }
        
        return Math.max(altCount, Math.max(oddCount, evenCount));
        /*        
        // converting to 0s and 1s
        for(int i = 0; i < nums.length; i++){
            nums[i] = nums[i]%2;
        }
        
        // counting subsequences of alternating bits starting 0
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
        
        // counting subsequences of alternating bits starting 1
        count = 0;
        bit = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == bit){
                bit = 1-bit;
                count++;
            }
        }        
        ans = Math.max(ans, count);
        
        // counting subsequences of 0s
        count = 0;
        bit = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == bit){
                // bit = 1-bit;
                count++;
            }
        }        
        ans = Math.max(ans, count);

        // counting subsequences of 1s
        count = 0;
        bit = 1;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == bit){
                // bit = 1-bit;
                count++;
            }
        }        
        ans = Math.max(ans, count);
        return ans;*/
    }

}
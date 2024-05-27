class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = nums[0]+nums[1]+nums[2];
        if(nums.length == 3) return ans;
        
        int min = Integer.MAX_VALUE;
        // similar to 3sum 
        // traverse all and keep track of min
        // but no mention of duplicates 
        Arrays.sort(nums);
        
        for(int i = 0; i < nums.length-2; i++){
            int j = i+1;
            int k = nums.length-1;
            
            while(j < k){
                int sum = nums[i]+nums[j]+nums[k];
                // i and target are fixed - can only change j and k
                // update abs_min and ans, whenever found a closer triplet
                if(min > Math.abs(sum - target)){
                    min = Math.abs(sum - target);
                    ans = sum;
                }
                
                if(sum > target){
                    k--;
                }else if(sum < target){
                    j++;
                }else{
                    return target;
                }
            }
            
        }
        
        return ans;
    }
}
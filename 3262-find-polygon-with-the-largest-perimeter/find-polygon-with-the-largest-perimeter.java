class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums); 
        // moving left to right
        long sum = 0;
        long ans = -1;

        for(int i : nums){
            if(sum > i)
                ans = sum + i;
            sum += i;
        }
        return ans;
        /*
        // using prefix sum
        long sum = 0;
        for(int i = 1; i < nums.length; i++){
            sum += nums[i-1];
        }
        int j = nums.length - 1;
        while(j>0 && nums[j] >= sum){
            sum -= nums[j-1];
            j--;
        }
        if(j < 2) return -1;
        return sum + nums[j];
        */
    }

}
class Solution {
    public long largestPerimeter(int[] nums) {
        Arrays.sort(nums);
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
        long[] ps = new long[nums.length];
        ps[0] = 0;
        for(int i = 1; i < nums.length; i++){
            ps[i] = ps[i-1]+nums[i-1];
        }
        int j = nums.length - 1;
        while(j>0 && nums[j] >= ps[j]){
            j--;
        }
        if(j < 2) return -1;
        return ps[j] + nums[j];
        */
    }

}
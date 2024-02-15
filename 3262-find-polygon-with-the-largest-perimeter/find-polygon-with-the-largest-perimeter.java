class Solution {
    public long largestPerimeter(int[] nums) {
        // moving left to right
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
        Arrays.sort(nums); 
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

    /**
        //prefix sum array
         Arrays.sort(nums);
        // if(nums.length < 3 || getCount(nums) < 3) return -1;
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

    /**
    // Brute Force
    public long largestPerimeter(int[] nums) {
        if(nums.length < 3 || getCount(nums) < 3) return -1;

        if(getSum(nums) <= 2 * getMax(nums)){
            removeMax(nums);
            return largestPerimeter(nums); 
        }
        return getSum(nums);
    }

    private int getCount(int[] ar){
        int c = 0;
        for(int i : ar){
            if(i > 0) c++;
        }
        return c;
    }

    private long getSum(int[] ar){
        long sum = 0;
        for(int i : ar){
            sum+= i;
        } 
        return sum;
    }

    private int getMax(int[] ar){
        int max = -1;
        for(int i : ar){
            if(i > max) max=i;
        } 
        return max;
    }

    private void removeMax(int[] nums){
        int m = 0;
        int max = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(max < nums[i]){
                max = nums[i];
                m = i;
            }
        }
        nums[m] = 0;
    }

        
         */
    }

}
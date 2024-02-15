class Solution {
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


}
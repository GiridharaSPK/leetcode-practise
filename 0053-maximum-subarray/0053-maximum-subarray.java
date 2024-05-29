class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        // not required base cases
        // if(n == 0) return 0;
        // if(n == 1) return nums[0];
        
        int i = 0;
        int j = 0;
        int maxSum = Integer.MIN_VALUE;
        int sum = 0; // current sum
        
        // kadene's algo
        while(i < n && j < n){
            sum += nums[j];
            // only max values of sum are stored in maxSum
            if(sum > maxSum){
                maxSum = sum;
            }
            // if current sum doesnt add any value - reset sum and i (put it at next of j)
            if(sum < 0){
                sum = 0;
                i = j+1;
            }
            // move right pointer
            j++;
        }
        return maxSum;
    }
}
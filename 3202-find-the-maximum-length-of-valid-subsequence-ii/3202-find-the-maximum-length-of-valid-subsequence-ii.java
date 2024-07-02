class Solution {
    public int maximumLength(int[] nums, int k) {     
        int n = nums.length;
        int[][] dp = new int[n][k]; 
        int ans = 0;
        
        for(int[] row: dp){
            Arrays.fill(row, 1);
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                int rem = (nums[i]+nums[j])%k;
                dp[i][rem] = Math.max(dp[i][rem], dp[j][rem]+1);
                ans = Math.max(ans, dp[i][rem]);
            }
        }
        
        return ans;
    }
}
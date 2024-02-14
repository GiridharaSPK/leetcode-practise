class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] ans = new int[nums.length];
        int i = 0;
        int j = 1;
        int k = 0;
        while(i < ans.length - 1 || j < ans.length){
            if(nums[k] > 0){
                ans[i] = nums[k];
                i+=2;
            }else{
                ans[j] = nums[k];
                j+=2;
            }
            k++;
        }
        return ans;
    }
}
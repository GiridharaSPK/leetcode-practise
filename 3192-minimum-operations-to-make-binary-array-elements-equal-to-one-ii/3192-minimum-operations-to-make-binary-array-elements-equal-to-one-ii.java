class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++){
            int temp = count%2;
            // if((nums[i] == 0 && temp==0) || (nums[i] == 1 && temp==1)){
            if(nums[i] == temp){
                count++;
            }
        }
        return count;
    }

}
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length < 3) return nums.length;
        int f = 2;
        int s = 2;
        while(f < nums.length){
            if(nums[f] == nums[s-2]){
                
            }else{
                nums[s] = nums[f];
                s++;
            }
            f++;
        }
        return s;
    }
}
class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int count = 0;
        int j = -1;
        while(i < nums.length){
            if(nums[i] == val) {
                j = i+1;
                while(j < nums.length && nums[j] == val){
                    j++;    
                }
                if(j != nums.length)
                swap(nums, i, j);
            }
            i++;
        }
        i=0;
        while(i<nums.length){
            if(nums[i]==val) count++;i++;
        }
        return nums.length - count;
    }

    private void swap(int[] ar, int i, int j){
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
}
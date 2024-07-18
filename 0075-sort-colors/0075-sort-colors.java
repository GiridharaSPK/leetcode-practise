class Solution {
    public void sortColors(int[] nums) {
        int l = 0; // before l everything is 0
        int r = nums.length-1; // after r everything is 2
        
        int i = 0; // before i everything is 0 and 1
        
        // while(i < nums.length && l < r){ 
        // gives wrong ans
        // i should'nt cross r
        
        while(i <= r){ 
            if(nums[i] == 0){
                swap(nums, i, l);
                // nums[l] can only be 1 after swap
                // if its 2 it would've been already swapped
                l++;
                i++; 
            }else if (nums[i] == 2){
                swap(nums, i, r);
                r--; // not incrementing i - after swap new nums[i] can be 0 or 1
            }else{
                i++;
            }
        }
        
        // similar valid approach
        /*i = nums.length - 1;
        while(i >= l){
            if(nums[i] == 2){
                swap(nums, i, r);
                r--;
            }else if(nums[i] == 0){
                swap(nums, i, l);
                l++;
                i++;
            }
            i--;
        }*/
        
    }
    
    private void swap(int[] ar, int p1, int p2){
        int temp = ar[p1];
        ar[p1] = ar[p2];
        ar[p2] = temp;
    }
    
}
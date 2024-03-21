class Solution {
    public int[] shuffle(int[] nums, int n) {
        if (nums.length % 2 != 0) return nums;
        int i = 0;
        while(i<nums.length){
		int currIndex = i;
		int nextIndex = 0, nextNum = 0;
		int currNum = nums[currIndex];
        while(currNum>0){
            if(currIndex >= n){
                nextIndex = 2*(currIndex-n)+1;
            }else{
                nextIndex = 2*currIndex;
            } 
            //store nextNum
            nextNum = nums[nextIndex];
            //update array
            nums[nextIndex] = -1*currNum;
            //swap nums and indices
            currIndex = nextIndex;
            currNum = nextNum;
        }
        i++;
        }
        shift(nums);
        return nums;

    }
    
    private void shift(int[] ar){
        for (int i = 0; i < ar.length; i++){
            if(ar[i] < 0) ar[i]= -1*ar[i];
        }
    }
    
    private void print(int[] ar){
        for (int i = 0; i < ar.length; i++){
            System.out.print(ar[i]);
        }
    }

    
}
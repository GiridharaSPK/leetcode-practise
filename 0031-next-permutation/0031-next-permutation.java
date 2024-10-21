class Solution {
    public void nextPermutation(int[] nums) {
        int pivInd = findPivotFromEnd(nums);
        if(pivInd != -1){
            int nxtGrtrElInd = nextGreaterElementIndex(nums, pivInd);
            swap(nums, pivInd, nxtGrtrElInd);
        }
        reverse(nums, pivInd+1);
        return;
    }
    
    private int findPivotFromEnd(int[] nums){
        for(int i = nums.length-2; i >= 0; i--){
            if(nums[i+1] > nums[i]){
                return i;
            }
        }
        return -1;
    }
    
    private int nextGreaterElementIndex(int[] nums, int pivInd){
        for(int i = nums.length-1; i > pivInd; i--){
            if(nums[pivInd] < nums[i]){
                return i;
            }
        }
        return pivInd+1;
    }
    
    private void reverse(int[] nums, int start){
        int end = nums.length-1;
        
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
    
    private void swap(int[] ar, int pos1, int pos2){
        int temp = ar[pos1];
        ar[pos1] = ar[pos2];
        ar[pos2] = temp;
    }
    
}
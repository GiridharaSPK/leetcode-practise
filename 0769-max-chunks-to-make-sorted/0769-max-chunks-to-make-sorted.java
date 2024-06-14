class Solution {
    public int maxChunksToSorted(int[] arr) {
        // given integers range from 0 to n-1
        // and unique
        // chunk can be made if max until now (from left) === index
        
        int count = 0;
        int max = arr[0]; //Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(max < arr[i]) max = arr[i];
            if(max == i) count++;
        }
        
        return count;
    }
}
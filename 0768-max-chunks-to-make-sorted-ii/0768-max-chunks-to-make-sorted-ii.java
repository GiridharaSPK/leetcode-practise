class Solution {
    public int maxChunksToSorted(int[] arr) {
        
        // pre compute min array from right to left
        int[] minArray = new int[arr.length];
        int n = arr.length;
        minArray[n-1] = arr[n-1];
        for(int i = n-2; i>=0 ;i--){
            minArray[i] = Math.min(minArray[i+1], arr[i]);
        }
        
        // calculate max from left to right (no need to store as we just need curr max)
        int max = Integer.MIN_VALUE;
        int count = 0;
        for(int i = 0; i < n; i++){
            if(max < arr[i]){
                max = arr[i];
            }
            // if current max <= next min -> can chunk
            if(i+1 < n && max <= minArray[i+1])
                count++;
        }
        return count+1; // add 1 for last chunk
    }
}
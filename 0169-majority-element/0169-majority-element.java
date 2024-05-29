class Solution {
    public int majorityElement(int[] nums) {
        // freq sort - using maxheaps
        // hashmap - if count > n/2 return
        // arrays.sort() return ar[n/2]
        
        // Boyer-Moore's Voting algorithm
        // works only if there always exists a majority element(freq > n/2)
        
        int count = 0;
        int ans = 0;
        for(int i=0; i < nums.length; i++){
            if(count == 0){ // start or expected element failed
                ans = nums[i]; // update new expected element
                count++; // update count to 1
            }else if(ans == nums[i]){ //seeing the same elmt (expect ans) multiple times
                count++; // increase count
            }else{ // current num if different than expected ans
                count--; // seeing other elements
            }
        }
        
        return ans;
        
    }
}
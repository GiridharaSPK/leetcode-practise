class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int left = 0; // subarray start
        int right = 0; // subarray end
        int mid = 0; // notes first odd in subarray
        
        int ans = 0; // 
        int count = 0; // odd count
        while(right < nums.length){
            // if curr num is odd increase count
            if(nums[right]%2 == 1){
                count++;
            }
            // if we have more than k odds 
            // shrink window by increasing left
            while(count > k){
                if(nums[left]%2 == 1){
                    count--;
                }
                left++; 
                mid = left;
            }
            if(count < k){
                right++;
            }else if(count == k){ 
                while(nums[mid]%2 == 0 && mid < right){
                    mid++;
                }
                ans += mid-left+1;
                right++;
            } 
            // count > k // this logic leads to TLEs if written here
            // moved to top 
            // update left - as soon as count is greater than k
            /*else{ 
                while(count > k){
                    if(nums[left]%2 == 1){
                        count--;
                    }
                    left++;
                    mid = left;
                }*/
            }
            return ans;
        }

        // approach without using mid
        // improvisation of the above approach
        // updating ans by incrementing left upto first odd 
        // (little more complex logic to comeup with at once)
        // [copied from discuss]
        /*int count=0, n=nums.length;
        int right=0;
        // sliding window: find first k odd elements
        for(; right<n; right++) {
            if(nums[right]%2==1 && ++odd==k) break;
        }
        if(odd<k) return 0;
        int subarrays=0, count=1;
        int left=-1;
        // sliding window: count nice subarrays end at every index
        for(; right<n; right++) {
            if(nums[right]%2==1) {
                count=1;
                while(nums[++left]%2!=1) {
                    count++;
                }
            }
            subarrays += count;
        }
        return subarrays;*/
}
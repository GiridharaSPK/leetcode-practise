class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        /*int left = 0; // 
        int right = 0; // 
        
        int ans = 0; // 
        int count = 0; // 
        while(right < nums.length){
            if(count < k){
                if(nums[right]%2 == 1){
                    count++;
                }
                right++;
            }else{ // count >= k
                if(nums[left]%2 == 1){  
                    count--;
                }
                left++;
            }
            if(count == k){
                ans++;
            }
        }
        return ans;*/

        int odd=0, n=nums.length;
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
        return subarrays;
    }
}
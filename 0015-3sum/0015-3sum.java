class Solution {
    public List<List<Integer>> threeSum(int[] nums) {        
        List<List<Integer>> ans = new ArrayList<>();
        
        // test cases
        // 1 - all 0s // 0 0 0 0, 0 0 0
        // 2 - multiple duplicates of same triplets // -1 0 0 0 0 1 1 1 1
        // 3 - no duplicates - same i different j, k // 1 2 0 -1 -3 , 1 2 0 -1 -5 -3
        // 4 - 3 or 4 element arrays 
        
        // approach 1
        // 3 loops O(n cube)
        
        // approach 2
        // 2 loops + hashmap to find nums[i]+nums[j]=-nums[k] 
            // => O(n square) time + O(n) space
        
        // approach 3 : 
        // (we need not return indexes) 
        // and (a solution better than O(n square) without sorting)
        // sort + iterate and 2 sum (j,k) for each i
        
        // * mentioned that ans shouldnt contain duplicates - very important
        // have to skip possible duplicate solutions
        
        Arrays.sort(nums); // O(nlogn)
        for(int i = 0; i < nums.length-2; i++){
            
            // for sorted array, first element can only be -ve 
            if(nums[i] > 0) 
                break;
            
            // skip duplicates of nums[i]            
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            
            // two sum for nums[i] = -(nums[j]+nums[k])
            // List<Integer> triplet = new ArrayList<>();
            int target = -nums[i];
            int j = i+1;
            int k = nums.length-1;
            
            // have to skip duplicates of nums[j] and nums[k]
            /**
            // going to right most nums[j] 
            // validate for all 0s
            while(j < k && nums[j] == nums[j+1]){ 
                j++;
            }
            
            while(k > j && nums[k-1] == nums[k]){ // going to left most nums[k]
                k--;
            }*/
            // **[doing it above the 2-sum loop doesnt work for all 0s case]
            
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                
                if(sum < 0){ // (nums[j] + nums[k]) < target
                    j++;
                }else if(sum > 0){ // (nums[j] + nums[k]) > target
                    k--;
                }else{
                    // sum == 0 or nums[j] + nums[k] == target
                    // triplet.add(nums[i]);
                    // triplet.add(nums[j]);
                    // triplet.add(nums[k]);
                    // ans.add(triplet);
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    
                    // triplet = new ArrayList<>();     
                    // dont forget to break or move next
                    // *[move next] 
                        // move to next unique nums[j]
                    while(j < k && nums[j] == nums[j+1]) 
                        j++;
                    j++;
                    while(j < k && nums[k] == nums[k-1])
                        k--;
                    k--;
                }
            }
            
        }
        
        return ans;
    }
}
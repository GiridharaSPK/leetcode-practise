class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length ; i++){
            int curr = nums[i];
            int req = target - curr;
            if(map.containsKey(curr)){
                ans[0] = map.get(curr);
                ans[1] = i;
                break;
            }else{    
                map.put(req, i);
            }
        }
        
        return ans;
    }
}
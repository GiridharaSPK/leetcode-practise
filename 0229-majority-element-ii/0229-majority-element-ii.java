class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<>(); //stores only 3 entries
        
        for(int num: nums){
            if(map.containsKey(num)){
                map.put(num, map.get(num)-1);
            }else if(map.size() == 3){ 
                // reduce count by 1 and add element
                
                // reduce count and remove if 0
                /*for(int key : map.keySet()){
                    map.put(key, map.get(key)-1);
                }
                // removing 0 valued keys to maintain hashmap size less than 3
                map.entrySet().removeIf(entry -> entry.getValue() == 0);*/
                
                // create a new temp set to avoid concurrency exception
                for (int k : new HashSet<Integer>(map.keySet()))
                if (map.get(k) == 1)
                    map.remove(k);
                else
                    map.put(k, map.get(k) - 1);
                // add element
                map.put(num, 1);
            }else{ 
               // seen new element, and map size < 3 - add to map
               map.put(num, 1); 
            }
        }
        
        // verify and add to ans
        for(int num : map.keySet()){
            int count = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] == num) count++;
            }
            if(count > nums.length/3)
                ans.add(num);
        }
        return ans;
    }
}
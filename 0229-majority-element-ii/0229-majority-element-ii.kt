class Solution {
    fun majorityElement(nums: IntArray): List<Int> {
        // extension of Boyre Moore majority vote algorithm
        
        if(nums.size < 2) return nums.toList();
        
        // var ans = listOf<Int>(); // readonly list of kotlin
        val ans = ArrayList<Int>();
        val map = HashMap<Int,Int>();
        
        for(n in nums){
            if(map.containsKey(n)){
                map.put(n, map.get(n)!!.plus(1));
            }else if(map.size == 3){
                for(k in map.keys){
                    val v = map.get(k)!!;
                    map.put(k, v-1);
                }
                map.entries.removeIf {it.value == 0}
                map.put(n,1);
            }else{
                map.put(n,1);
            }
        }
        
        // validate the expected ans
        for(k in map.keys){
            var count = 0;
            for((i, num) in nums.withIndex()){
                if(nums[i] == k){
                    count++;
                }
            }
            if(count > nums.size/3){
                // ans += k; // can be used for for readonly list
                ans.add(k);
            }
        }
        
        return ans;
    }
}
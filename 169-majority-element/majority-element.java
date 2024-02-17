class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> f = new HashMap<Integer, Integer>();
        for(int i : nums){
            f.put(i, f.getOrDefault(i, 0)+1);
            if(f.get(i) > nums.length/2) return i;
        }
        return -1;
    }
}